package filters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.member.Users;

import java.io.IOException;

public class CommonRequestWrapper extends HttpServletRequestWrapper {
    public CommonRequestWrapper(HttpServletRequest request, HttpServletResponse response) {
        super(request);

        // 요청 전 공통 처리 부분
        // 로그인 여부
        HttpSession session = request.getSession();
        Users userInfo = (Users) session.getAttribute("users");
        boolean isLogin = userInfo != null;
        request.setAttribute("userInfo", userInfo);
        request.setAttribute("isLogin", isLogin);

        /** 접근 제한 페이지 여부 체크 */
        boolean isAccessible = true;

        String URI = request.getRequestURI();

        // 회원 전용 URL - 미로그인 상태인 경우
        if (!isLogin) {
            for (String url : getMemberOnlyUrls()) {
                if (URI.indexOf(url) != -1) {
                    isAccessible = false;
                }
            }
        }

        // 비회원 URL - 로그인 상태인 경우
        if (isLogin) {
            for (String url : getGuestOnlyUrls()) {
                if (URI.indexOf(url) != -1) {
                    isAccessible = false;
                }
            }
        }
        if (!isAccessible) { //접근 권한 없음
            try {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "접근 권한이 없습니다.");
            } catch (IOException e) {}
        }
    }
    // 회원 전용 URL
    private String[] getMemberOnlyUrls() {
        return  new String[] {
          "/works"
        };
    }
    // 비회원 전용 URL
    private String[] getGuestOnlyUrls () {
      return  new String[] {
        "member/login",
        "/member/join"
      };
    }
}

package models.member;

import jakarta.servlet.http.HttpServletRequest;
import validators.RequiredValidator;
import validators.Validator;

public class LoginValidator implements Validator<HttpServletRequest>, RequiredValidator {

    private UsersDao usersDao;

    public LoginValidator(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
    @Override
    public void check(HttpServletRequest request) {
        /**
         * 1. 필수 항목 검증(userId, userPw)
         * 2. userId로 회원이 조회 되는지 체크
         * 3. 비밀번호 검증
         */
    }
}

package controllers.works;

import static commons.ScriptUtils.*;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.works.InfoService;
import models.works.SaveService;
import models.works.Work;
import models.works.WorkNotFoundException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SaveController implements Controller {
    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String URI = req.getRequestURI();
            String mode = URI.indexOf("edit") != -1 ? "edit" : "add";

            Work work = null;
            if (mode.equals("edit")) { // 수정
                InfoService infoService = WorkServiceManager.getInstance().infoService();
                work = infoService.get(getWorkNo(req));
                if (work == null) {
                    throw new WorkNotFoundException();
                }

            } else { // 추가
                work = new Work();
            }

            req.setAttribute("work", work);

            String[] addScript = {"ckeditor/ckeditor", "work/form"};
            req.setAttribute("addScript", addScript);

            ViewUtils.load(req, resp, "works", mode);
        }catch (Exception e) {
            alertError(resp, e, -1); // 에러 메세지 alert 로 출력, histroy.go(-1);
        }
    }
    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) {
        SaveService saveService = WorkServiceManager.getInstance().saveService();
        try {
            saveService.save(req);

            // 추가, 수정 성공시 목록으로 이동
            go(resp, req.getContextPath() + "/works", "parent");

        } catch (Exception e) {
            alertError(resp, e);
            e.printStackTrace();
        }
    }
    /**
     *  작업 번호 추출
     *
     *  @param  req
     *  @return
     */
    private long getWorkNo(HttpServletRequest req) {
        String URI = req.getRequestURI();


        String pattern = "edit/(\\d*)";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(URI);
        if (matcher.find()) {

            return Long.parseLong(matcher.group(1));
        }

        return 0L;
    }
}
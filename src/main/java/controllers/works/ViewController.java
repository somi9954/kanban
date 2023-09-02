package controllers.works;

import commons.MemberUtil;
import commons.UrlUtils;
import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.works.InfoService;
import models.works.Work;
import models.works.WorkNotFoundException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static commons.ScriptUtils.alertError;

public class ViewController implements Controller {
    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) {

        try {
            InfoService infoService = WorkServiceManager.getInstance().infoService();
            long workNo = UrlUtils.getPatternData(req, "works/(\\d*)");
            Work work = infoService.get(workNo);
            if (work == null) {
                throw new WorkNotFoundException();
            }

            MemberUtil.isMine(req, work.getUserNo()); // 본인이 작성한 작업 내용인지 체크

            req.setAttribute("work", work);

            ViewUtils.load(req, resp, "works", "view");

        } catch (Exception e) {
            alertError(resp, e, -1);
        }
    }


    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }
}

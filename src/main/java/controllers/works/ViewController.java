package controllers.works;

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
        try{
            InfoService infoService = WorkServiceManager.getInstance().infoService();
            Work work = infoService.get(getWorkNo(req));
            if (work == null) {
                throw new WorkNotFoundException();
            }

            req.setAttribute("work", work);

        }catch (Exception e) {
            alertError(resp, e, -1);
        }
        ViewUtils.load(req, resp, "works", "view");
    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }

    private long getWorkNo (HttpServletRequest req) {
        String pattern = "works/(]]d*)";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(req.getRequestURI());
        if(matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }

        return 0L;
    }
}

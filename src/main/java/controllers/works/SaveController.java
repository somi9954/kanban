package controllers.works;

import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveController implements Controller {
    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        String URI = req.getRequestURI();
        String mode = URI.indexOf("edit") != -1 ? "edit" : "add";

        String[] addScript = { "ckeditor/ckeditor", "work/form" };
        req.setAttribute("addScript", addScript);

        ViewUtils.load(req, resp, "works", mode);
    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }
}

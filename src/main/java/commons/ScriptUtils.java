package commons;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ScriptUtils {
    public static void alertError(HttpServletResponse resp, Exception e) {
        try{
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.printf("<script>alert('%s');</script>", e.getMessage());
    } catch (IOException e2) {

        }
    }
    }


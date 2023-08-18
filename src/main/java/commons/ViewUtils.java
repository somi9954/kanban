package commons;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ViewUtils {
    public static void load(HttpServletRequest req, HttpServletResponse resp, String dir, String fileName) {
        RequestDispatcher re = req.getRequestDispatcher("/WEB-INF/view/" + dir + "/" + fileName + ".jsp");
        try {
            re.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
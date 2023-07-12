package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {

    private final String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(viewPath)
                .forward(req, resp);
    }

    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        copyAttributes(model, req);
        req.getRequestDispatcher(viewPath)
                .forward(req, resp);
    }

    private void copyAttributes(Map<String, Object> model, HttpServletRequest req) {
        model.forEach(req::setAttribute);
    }
}

package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v5.adapter;

import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.ModelView;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v3.ControllerV3;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v4.ControllerV4;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4Adapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return handler instanceof ControllerV4;
    }

    @Override
    public ModelView handle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws ServletException, IOException {
        Map<String, String> paramMap = generateParamMap(req);
        Map<String, Object> model = new HashMap<>();

        String viewName = ((ControllerV4) handler).process(paramMap, model);

        return new ModelView(viewName, model);
    }
}

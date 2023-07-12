package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v3;

import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.ModelView;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.MyView;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.ViewResolver;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServiceV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private final Map<String, ControllerV3> controllerMap = new HashMap<>();
    private final ViewResolver viewResolver = ViewResolver.getInstance();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String reqUri = req.getRequestURI();
        System.out.println("reqUri = " + reqUri);

        ControllerV3 controller = controllerMap.get(reqUri);
        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = generateParamMap(req);
        ModelView modelView = controller.process(paramMap);

        MyView myView = viewResolver.run(modelView.getViewName());
        myView.render(modelView.getModel(), req, resp);
    }

    private static Map<String, String> generateParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        return paramMap;
    }
}

package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v2;

import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v1.ControllerV1;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServiceV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private final Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");

        String reqUri = req.getRequestURI();
        System.out.println("reqUri = " + reqUri);

        ControllerV2 controller = controllerMap.get(reqUri);
        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(req, resp)
                .render(req, resp);
    }
}

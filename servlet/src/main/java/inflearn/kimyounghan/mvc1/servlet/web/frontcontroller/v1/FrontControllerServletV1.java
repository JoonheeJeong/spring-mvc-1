package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v1;

import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v1.ControllerV1;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServiceV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private final Map<String, ControllerV1> controllerV1Map = new HashMap<>();

    public FrontControllerServletV1() {
        controllerV1Map.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerV1Map.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerV1Map.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        String reqUri = req.getRequestURI();
        System.out.println("reqUri = " + reqUri);

        ControllerV1 controllerV1 = controllerV1Map.get(reqUri);
        if (controllerV1 == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controllerV1.process(req, resp);
    }
}

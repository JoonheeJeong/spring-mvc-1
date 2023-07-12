package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v5;

import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.ModelView;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.MyView;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.ViewResolver;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v5.adapter.ControllerV3Adapter;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v5.adapter.ControllerV4Adapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServiceV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapterList = new ArrayList<>();
    private final ViewResolver viewResolver = ViewResolver.getInstance();

    public FrontControllerServletV5() {
        initHandlerMap();
        initHandlerAdapterList();
    }

    private void initHandlerMap() {
        handlerMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handlerMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapterList() {
        handlerAdapterList.add(new ControllerV3Adapter());
        handlerAdapterList.add(new ControllerV4Adapter());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV5.service");

        Object handler = findHandler(req);
        if (handler == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter handlerAdapter = findHandlerAdapter(handler);

        ModelView modelView = handlerAdapter.handle(req, resp, handler);

        MyView myView = viewResolver.run(modelView.getViewName());
        myView.render(modelView.getModel(), req, resp);
    }

    private Object findHandler(HttpServletRequest req) {
        String reqUri = req.getRequestURI();
        System.out.println("reqUri = " + reqUri);

        return handlerMap.get(reqUri);
    }

    private MyHandlerAdapter findHandlerAdapter(Object handler) {
        return handlerAdapterList.stream()
                .filter(adapter -> adapter.supports(handler))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no handler adapter for " + handler.getClass()));
    }
}

package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v1.controller;

import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String viewPath = "/WEB-INF/views/new-form.jsp";
        req.getRequestDispatcher(viewPath).forward(req, resp);
    }
}

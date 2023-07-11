package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v2.controller;

import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.MyView;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}

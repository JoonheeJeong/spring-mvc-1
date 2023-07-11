package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v1.controller;

import inflearn.kimyounghan.mvc1.servlet.domain.member.Member;
import inflearn.kimyounghan.mvc1.servlet.domain.member.MemberRepository;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = req.getParameter("username");
        final Integer age = Integer.valueOf(req.getParameter("age"));

        final Member member = memberRepository.save(new Member(username, age));
        req.setAttribute("member", member);

        final String viewPath = "/WEB-INF/views/save-result.jsp";
        req.getRequestDispatcher(viewPath)
                .forward(req, resp);
    }
}

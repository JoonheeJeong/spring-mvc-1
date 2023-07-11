package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v1.controller;

import inflearn.kimyounghan.mvc1.servlet.domain.member.Member;
import inflearn.kimyounghan.mvc1.servlet.domain.member.MemberRepository;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV1 implements ControllerV1 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Member> members = memberRepository.findAll();
        req.setAttribute("members", members);

        final String viewPath = "/WEB-INF/views/members.jsp";
        req.getRequestDispatcher(viewPath)
                .forward(req, resp);
    }
}

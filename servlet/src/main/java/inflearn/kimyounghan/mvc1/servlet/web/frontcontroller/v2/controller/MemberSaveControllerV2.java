package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v2.controller;

import inflearn.kimyounghan.mvc1.servlet.domain.member.Member;
import inflearn.kimyounghan.mvc1.servlet.domain.member.MemberRepository;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.MyView;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = req.getParameter("username");
        final Integer age = Integer.valueOf(req.getParameter("age"));

        final Member member = memberRepository.save(new Member(username, age));
        req.setAttribute("member", member);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}

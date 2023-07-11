package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v2.controller;

import inflearn.kimyounghan.mvc1.servlet.domain.member.Member;
import inflearn.kimyounghan.mvc1.servlet.domain.member.MemberRepository;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.MyView;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Member> members = memberRepository.findAll();
        req.setAttribute("members", members);

        return new MyView("/WEB-INF/views/members.jsp");
    }
}

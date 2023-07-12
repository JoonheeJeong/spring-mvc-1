package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v3.controller;

import inflearn.kimyounghan.mvc1.servlet.domain.member.Member;
import inflearn.kimyounghan.mvc1.servlet.domain.member.MemberRepository;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.ModelView;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        final String username = paramMap.get("username");
        final Integer age = Integer.valueOf(paramMap.get("age"));

        final Member member = memberRepository.save(new Member(username, age));
        ModelView modelView = new ModelView("save-result");
        modelView.setAttribute("member", member);
        return modelView;
    }
}

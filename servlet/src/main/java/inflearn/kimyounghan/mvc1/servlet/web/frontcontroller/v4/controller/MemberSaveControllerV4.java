package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v4.controller;

import inflearn.kimyounghan.mvc1.servlet.domain.member.Member;
import inflearn.kimyounghan.mvc1.servlet.domain.member.MemberRepository;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.ModelView;
import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        final String username = paramMap.get("username");
        final Integer age = Integer.valueOf(paramMap.get("age"));

        final Member member = memberRepository.save(new Member(username, age));
        model.put("member", member);
        return "save-result";
    }
}

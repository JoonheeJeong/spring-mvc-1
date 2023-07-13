package inflearn.kimyounghan.mvc1.servlet.web.springmvc.v2;

import inflearn.kimyounghan.mvc1.servlet.domain.member.Member;
import inflearn.kimyounghan.mvc1.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView getNewForm() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest req) {
        String username = req.getParameter("username");
        Integer age = Integer.valueOf(req.getParameter("age"));

        Member member = memberRepository.save(new Member(username, age));

        ModelAndView mav = new ModelAndView("save-result");
        mav.addObject("member", member);

        return mav;
    }

    @RequestMapping
    public ModelAndView getList() {
        List<Member> members = memberRepository.findAll();

        ModelAndView mav = new ModelAndView("members");
        mav.addObject("members", members);

        return mav;
    }
}
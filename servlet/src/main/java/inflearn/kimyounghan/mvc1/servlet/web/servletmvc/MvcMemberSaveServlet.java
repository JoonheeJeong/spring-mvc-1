package inflearn.kimyounghan.mvc1.servlet.web.servletmvc;

import inflearn.kimyounghan.mvc1.servlet.domain.member.Member;
import inflearn.kimyounghan.mvc1.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = req.getParameter("username");
        final Integer age = Integer.valueOf(req.getParameter("age"));

        final Member member = memberRepository.save(new Member(username, age));
        req.setAttribute("member", member);

        final String viewPath = "/WEB-INF/views/save-result.jsp";
        req.getRequestDispatcher(viewPath)
                .forward(req, resp);
    }
}

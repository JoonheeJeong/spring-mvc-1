package inflearn.kimyounghan.mvc1.servlet.web.servlet;

import inflearn.kimyounghan.mvc1.servlet.domain.member.Member;
import inflearn.kimyounghan.mvc1.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    protected MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> memberList = memberRepository.findAll();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>\n")
                   .append("<head>\n")
                   .append("  <meta charset=\"UTF-8\">\n")
                   .append("  <title>Title</title>\n")
                   .append("</head>\n")
                   .append("<body>\n")
                   .append("<a href=\"/index.html\">메인</a>\n")
                   .append("<table>\n")
                   .append("  <thead>\n")
                   .append("    <th>id</th>\n")
                   .append("    <th>username</th>\n")
                   .append("    <th>age</th>\n")
                   .append("  </thead>\n")
                   .append("  <tbody>\n");
        for (Member member : memberList) {
            htmlBuilder.append("    <tr>\n")
                       .append("      <td> ").append(member.getId()).append(" </td>\n")
                       .append("      <td> ").append(member.getUsername()).append(" </td>\n")
                       .append("      <td> ").append(member.getAge()).append(" </td>\n")
                       .append("    </tr>\n");
        }
        htmlBuilder.append("  </tbody>\n")
                   .append("</table>\n")
                   .append("</body>\n")
                   .append("</html>\n");

        resp.getWriter().write(htmlBuilder.toString());
    }
}

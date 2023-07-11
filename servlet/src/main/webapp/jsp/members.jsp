<%--
  Created by IntelliJ IDEA.
  User: joonheejeong
  Date: 2023/07/11
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="inflearn.kimyounghan.mvc1.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="inflearn.kimyounghan.mvc1.servlet.domain.member.MemberRepository" %>
<%
    List<Member> memberList = MemberRepository.getInstance().findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>age</th>
    </tr>
    </thead>
    <tbody>
<%
    for (Member member : memberList) {
        out.write("    <tr>\n");
        out.write("        <td>" + member.getId() + "</td>\n");
        out.write("        <td>" + member.getUsername() + "</td>\n");
        out.write("        <td>" + member.getAge() + "</td>\n");
        out.write("    </tr>\n");
    }
%>
    </tbody>
</table>
</body>
</html>

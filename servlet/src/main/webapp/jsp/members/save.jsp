<%--
  Created by IntelliJ IDEA.
  User: joonheejeong
  Date: 2023/07/11
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="inflearn.kimyounghan.mvc1.servlet.domain.member.Member" %>
<%@ page import="inflearn.kimyounghan.mvc1.servlet.domain.member.MemberRepository" %>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();

  System.out.println("MemberSaveServlet.service");

  String username = request.getParameter("username");
  Integer age = Integer.valueOf(request.getParameter("age"));
  Member member = memberRepository.save(new Member(username, age));
%>
<html>
<head>
    <title>JSP save</title>
</head>
<body>
성공
<ul>
  <li>id=<%=member.getId()%></li>
  <li>username=<%=member.getUsername()%></li>
  <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>

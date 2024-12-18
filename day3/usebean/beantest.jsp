<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <jsp:useBean id="dto" class="dto.MemberDTO"></jsp:useBean> --%>
<%
MemberDTO dto = new MemberDTO();
dto.setId(request.getParameter("id"));
dto.setName("김대한");
dto.setPw(11111);
dto.setPhone("010-9876-5432");
dto.setEmail("kim@jsp.net");
%>
<H1>회원정보를 생성했습니다. 확인해 볼까요?</H1>
<h3>아이디=<%=dto.getId() %></h3>
<h3>이름=<%=dto.getName() %></h3>
<h3>암호=<%=dto.getPw() %></h3>
<h3>이메일=<%=dto.getEmail() %></h3>
<h3>폰번호=<%=dto.getPhone() %></h3>

<jsp:useBean id="dto2" class="dto.MemberDTO"/>
<jsp:setProperty property="id" name="dto2" param="id2"/><%-- value="<%=request.getParameter(\"id\")%>" --%>
<jsp:setProperty property="name" name="dto2" value="최강산"/>
<jsp:setProperty property="pw" name="dto2" value="22222"/>
<jsp:setProperty property="email" name="dto2" value="choi@jsp.net"/>
<jsp:setProperty property="phone" name="dto2" value="010-9988-7766"/>
<H1>회원정보를 생성했습니다. 확인해 볼까요?(jsp:getProperty태그로)</H1>
<h3><jsp:getProperty name="dto2" property="id" /></h3>
<h3><jsp:getProperty name="dto2" property="name" /></h3>
<h3><jsp:getProperty name="dto2" property="pw" /></h3>
<h3><jsp:getProperty name="dto2" property="email" /></h3>
<h3><jsp:getProperty name="dto2" property="phone" /></h3>
</body>
</html>
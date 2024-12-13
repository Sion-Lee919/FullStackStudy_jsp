<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 화면입니다.</h1>
<%
MemberDAO dao = new MemberDAO();
MemberDTO dto = dao.getMember("q1", 1);
%>
<h3><%=dto.getId() %> 회원님 로그인되었습니다</h3>
<jsp:include page="footer.jsp">
	<jsp:param value="../images/iphone.png" name="imagename"/>
	<jsp:param value="<%=request.getServletPath() %>" name="jspname"/>
</jsp:include>
</body>
</html>
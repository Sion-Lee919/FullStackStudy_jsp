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
<%
if(session.getAttribute("sessionmember") != null){
	//로그인한적이 있다. 암호 다를 수도 있다.
	MemberDTO dto = (MemberDTO)session.getAttribute("sessionmember");
	out.println(dto.getId() + "회원님 로그아웃 하셨습니다.");
	session.removeAttribute("sessionmember");
}
%>
</body>
</html>
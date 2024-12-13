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
MemberDTO dto=(MemberDTO)session.getAttribute("sessionmember");
if(dto == null){
	out.println("<h3><a href='/servlettest/Loginform_DB.html'>로그인</a>한적이 없거나 <a href='insertform_DB.html'>회원이 아닙니다.</a></h3>");
}
else{
	if(dto.getPw()==0){
		out.println("<h3>암호 확인하세요 </h3>");
	}
	else{
		out.println(dto.getId()+"회원님 정보는 다음과 같습니다.");
		out.println("<h3>"+dto + "</h3>");
	}
}
%>
</body>
</html>
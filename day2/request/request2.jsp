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
<% MemberDTO dto = (MemberDTO)request.getAttribute("member"); 
	if(dto == null){
		out.println("<h3>존재하지 않는 회원입니다.</h3>");
	}
	else{
		if(dto.getPw()==0){
			out.println("<h3>회원의 암호와 다릅니다.</h3>");
		}
		else{
			out.println("<h3>회원정보는 다음과 같습니다.</h3>");
			out.println(dto);
		}
	}

%>
</body>
</html>
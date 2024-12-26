<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/servlettest/js/jquery-3.7.1.min.js" ></script>
<script>
		$(document).ready(function(){
			
		});
</script>	
</head>
<body>
<%
if(session.getAttribute("sessionid") !=null){
	out.println(session.getAttribute("sessionid")+"회원님 마이페이지 화면입니다.");
	out.println(session.getAttribute("sessionpw")+"암호 사용중입니다.");
}
else{
	out.println("로그인 먼저하세요");
}
%>
</body>
</html>
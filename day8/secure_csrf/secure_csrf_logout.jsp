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
	out.println(session.getAttribute("sessionid")+"회원님 로그아웃합니다.");
	session.removeAttribute("sessionid");
	session.removeAttribute("sessionpw");
}
else{
	out.println("처리불가");
}
%>
<a href="secure_csrf_mypage.jsp">내정보보기</a>
</body>
</html>
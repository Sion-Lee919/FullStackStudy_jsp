<%@page import="java.net.URLDecoder"%>
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
<h1>jsp응답시작</h1>
<%
 	for(Cookie cookie : request.getCookies()){
 		%>
 		<%=cookie.getName() %>:<br>
 		<%=URLDecoder.decode(cookie.getValue(),"utf-8") %>
 <%
 	}
%>

<h1>jsp응답종료</h1>
</body>	
</html>
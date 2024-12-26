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
<form action="secure_csrf_pw.jsp" method="post">
암호 <input type="password" name="pw"><br>
<input type="hidden" name="CSRF_TOKEN" value="${sessionScope.CSRF_TOKEN }">
<input type="submit" value="암호변경"><br>
</form>

</body>
</html>
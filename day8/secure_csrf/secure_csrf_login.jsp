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
<form action="<%=request.getRequestURI() %>" method="post">
아이디 <input type="text" name="id"><br>
암호 <input type="password" name="pw"><br>
<input type="submit" value="로그인"><br>
</form>

<%
if(request.getParameter("id") !=null){
	session.setAttribute("sessionid", request.getParameter("id"));
	session.setAttribute("sessionpw", request.getParameter("pw"));
}
%>

<h3><%=session.getAttribute("sessionid") %>님 환영합니다</h3>
<h4><a href='secure_csrf_inputpw.jsp'>암호변경하기</a></h4>
<h4><a href='secure_csrf_mypage.jsp'>내정보보기</a></h4>
<h4><a href='secure_csrf_logout.jsp'>로그아웃하기</a></h4>
</body>
</html>
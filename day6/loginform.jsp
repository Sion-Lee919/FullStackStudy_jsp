<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판 로그인폼</h1>
<form action="boardstart" method="post">
	<input type="hidden" name = "menu" value="login">
	<label for="id">아이디입력</label><input type="text" id="id" name="id"><br>
	<label for="pw">암호입력</label><input type="text" id="pw" name="pw"><br>
	<input type="submit" value="로그인">
</form>
</body>
</html>
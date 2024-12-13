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
    String userid = (String) session.getAttribute("userid");
%>
<form action="">
번호:<input type="text"><br>
제목:<input type="text" ><br>
내용:<textarea></textarea><br>
작성자:<input type="text" value="<%= userid %>" readonly><br>
<button type="submit">작성 완료</button>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p> 연락처 - 이메일로 문의하세요 </p>
<p> 오시는 길 - 서울시 강남구 역삼동 멀티</p>
<img src ="<%=request.getParameter("imagename") %>" width="150" height="150"> <br>
요청파일<%=request.getParameter("jspname") %>
</body>
</html>
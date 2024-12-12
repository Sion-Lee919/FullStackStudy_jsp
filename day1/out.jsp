<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>out내장객체 - html 출력</h3>
<%="out 내장객체 -표현문태그 출력" %>
<% out.println("<h3>out내장객체 -println출력</h3>"); %>
<%=request.getParameter("id").equals("java") %><br>
총버퍼 크기 = <%=out.getBufferSize() %><br>
남아있는 버퍼크기 <%=out.getRemaining() %><br>
<%out.flush(); %><br><!-- 버퍼출력하고 비우기-->
남아있는 버퍼크기 <%=out.getRemaining() %><br>
</body>
</html>
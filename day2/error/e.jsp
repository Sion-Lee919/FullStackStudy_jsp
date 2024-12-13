<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
    <!-- isErrorPage="true" 쓰면 예외처리가능 exception 내장객체 사용가능 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>오류발생jsp=<%=request.getAttribute("file") %></h3>
<h3>오류발생원인=<%=request.getAttribute("errormessage") %></h3>

<h3><%=exception %></h3>
<h3><%=exception.getMessage() %></h3>
<%exception.printStackTrace(); %>
</body>
</html>
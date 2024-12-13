<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="e.jsp"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setAttribute("file",request.getRequestURI());
request.setAttribute("errormessage","숫자를 전달하면 제곱을 계산합니다");
//foward, include(서블릿이나 jsp)공유 전달
%>
<%int num= Integer.parseInt( request.getParameter("num")); %>
<h3>결과 = <%=num*num %></h3>
</body>
</html>
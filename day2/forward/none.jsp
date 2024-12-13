<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=request.getParameter("role")%> 입니다. 사용가능한 메뉴는 없습다.</h1>
<%
String[] menu = (String[])request.getAttribute("menu");
for(String one : menu){
	out.println("<h3><a href=''>"+one+"</a></h3>");
}
%>
</body>
</html>
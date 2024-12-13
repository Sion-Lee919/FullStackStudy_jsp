<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=request.getParameter("role")%>용 메뉴는 다음과 같습니다.</h1>
<%
String[] menu = (String[])request.getAttribute("menu");
out.println("<ul>");
for(String one : menu){
	out.println("<li><a href=''>"+one+"</a></li>");
}
out.println("</ul>");
%>
</body>
</html>
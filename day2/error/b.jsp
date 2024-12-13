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
<% request.setAttribute("file",request.getRequestURI());
request.setAttribute("errormessage","0-3 값이어야 합니다");
String [] menus={"회원관리", "게시판관리", "쇼핑몰관리", "챗봇관리"};
int index= Integer.parseInt(request.getParameter("menus"));%>

<h3>선택한메뉴 =<%=menus[index]%></h3>
</body>
</html>
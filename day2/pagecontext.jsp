<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%="출력" %>
<%out.println("출력2"); %>
<%!public void test(int i,PageContext pc) throws IOException{
	pc.getOut().println(i+i);
}
%>
<%test(10,pageContext); %>
</body>
</html>
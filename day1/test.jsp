<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>테스트</h3>
<%!String name =null; %>
<%
name = request.getParameter("name");
String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
%>
<%=now %> 시각에 <%=name %> 님이 로그인하셨습니다.<br>
이름입력 : <input type="text" name="username" value="<%=request.getParameter("name") %>"><br>
<%=100+200 %><br>
<%!
public String test(String str){
	return str.toUpperCase()+name.toUpperCase();
}
%>
<%=test("java")%>
</body>
</html>
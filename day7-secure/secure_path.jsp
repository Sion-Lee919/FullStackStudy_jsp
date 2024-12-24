<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 경로에 대한 인젝션-->
<%
String path = request.getParameter("path");
	if(path !=null){
		path= path.replaceAll(".","");
		//path= path.replaceAll("\\","");
		path= path.replaceAll("/","");
		path= path.replaceAll("&","");
	} 
	File f = new File("C:\\ezwel\\eclipse-jee-2024-09-R-win32-x86_64\\eclipse\\"+path);
	long filelength = f.length();
	//long l = f.lastModified();
	String modifytime= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(f.lastModified())); 
%>
<h3>현재경로=<%=f.getCanonicalPath() %></h3>
<h3>파일 길이 = <%=filelength %></h3>
<h3>파일 수정시간 = <%=modifytime %></h3>
<h3>실행파일여부=<%=f.canExecute() %></h3>
</body>
</html>
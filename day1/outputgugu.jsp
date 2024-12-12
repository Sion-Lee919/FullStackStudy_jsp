<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
PrintWriter total = response.getWriter();
if(request.getMethod().equals("POST")){
int start= Integer.parseInt(request.getParameter("start"));
int end= Integer.parseInt(request.getParameter("end"));
int s=0;
String gg="<table border=1>";
for(int j=1; j<=9; j++){
	gg+="<tr>";
	for(int i=start; i<=end; i++){
		s= i*j;
		gg+="<th>"+i+" * "+j+" = "+s+"</th>";
	}
	gg+="</tr>";
}
gg+="</table>";
total.println(gg);
}
else{
	total.println("요청방식 오류");
}
%>
</body>
</html>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
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
String type = request.getParameter("type");

String osname = System.getProperty("os.name");
if(osname.toLowerCase().startsWith("window 10")){
	
}
else{
	
}

Runtime r = Runtime.getRuntime();
//Runtime.getRuntime().exec("nodepad.exe");
//Runtime.getRuntime().exec(new String[] {"notepad.exe","test.txt"});
//Runtime.getRuntime().exec("c:...\excel.exe","test.xls");

// 미리 명령어 목록 - 내부 포한된 명령어만 사용가능하게 필터링
String[] taskarray= {"&dir", "&type", "&echo"};
for(String task:taskarray ){
	if(type.contains(task)){
		Process p = Runtime.getRuntime().exec(new String[] {"cmd.exe","/c","type" +type});
		BufferedReader br= new BufferedReader(new InputStreamReader( p.getInputStream()));
		String line = null;

		while((line = br.readLine()) !=null){
			System.out.println(line);
			out.println(line+"<br>");
		}
	}	
}

%>
</body>
</html>
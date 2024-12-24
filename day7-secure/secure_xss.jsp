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
String id = request.getParameter("id");

//서버측 코드 검증 및 필터링
//html 태그 <	'&lt;'표현
//< > ( ) & " '
/* id = id.replaceAll("&", "&amp;");
id = id.replaceAll("\"", "&qout;");
id = id.replaceAll("'", "&#x27;");
id = id.replaceAll("<", "&lt;");
id = id.replaceAll(">", "&gt;");
id = id.replaceAll("<script>", ""); */
//id = id.replaceAll("(", "#x28;");
//id = id.replaceAll(")", "#x29;");

%>

<%=id %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:out value="${param.id }"/>


<%-- 글읽기 <%=contents %>
글읽기 <c:out value="<%=contents %>">
 --%>
 <!-- http:....?id= <script src='hacker.js></script>-->
<!-- 
secure_xss.jsp?id=<script>alert("테스트출력")</script>
secure_xss.jsp?id=<script>alert(document.cookie)</script>
 -->
<!-- <script>
 //Cookie(브라우저 저장-자바 생성. javaScript 접근) / HttpSession(서버측 저장정보 - 클라이언트 접근)
 //alert(document.cookie); //쿠키에 접근가능
 //Cookie,HttpSession - 클라이언트 공유 정보 저장/ 서버측 공유 정보 저장
 //						같은 서버의 같은 컨텍스트 내의 파일들 http://localhost:8070/jsptest
 location.href="/a.html?cookie=" +document.cookie; //다른 파일로 현재 파일 생성 쿠키 전달
 </script> -->
</body>
</html>
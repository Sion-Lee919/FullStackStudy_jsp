<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html beaninput을 통해서 요청파라미터를 받음 -->
<jsp:useBean id="dto2" class="dto.MemberDTO" scope="request"/>
<jsp:setProperty property="*" name="dto2"/>
<%-- <jsp:forward page="beanrequest2.jsp" /> --%>
<!--  
<jsp:setProperty property="id" name="dto2"/>
<jsp:setProperty property="name" name="dto2" />
<jsp:setProperty property="pw" name="dto2"/>
<jsp:setProperty property="email" name="dto2"/>
<jsp:setProperty property="phone" name="dto2"/>
-->
<h1>회원정보 출력 (엑션테그)</h1>
<h3><jsp:getProperty property="id" name="dto2"/></h3>
<h3><jsp:getProperty name="dto2" property="name" /></h3>
<h3><jsp:getProperty name="dto2" property="pw" /></h3>
<h3><jsp:getProperty name="dto2" property="email" /></h3>
<h3><jsp:getProperty name="dto2" property="phone" /></h3>

<h1>회원정보 출력 (el)</h1>
<h3>${requestScope.dto2.id}</h3>
<h3>${requestScope.dto2.name}</h3>
<h3>${requestScope.dto2.pw}</h3>
<h3>${requestScope.dto2.email}</h3>
<h3>${requestScope.dto2.phone}</h3>
</body>
</html>
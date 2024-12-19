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
<H1>회원정보를 생성했습니다. 확인해 볼까요?(jsp:getProperty태그로)</H1>
<jsp:useBean id="dto2" class="dto.MemberDTO" scope="request"/>
<h3><jsp:getProperty name="dto2" property="id" /></h3>
<h3><jsp:getProperty name="dto2" property="name" /></h3>
<h3><jsp:getProperty name="dto2" property="pw" /></h3>
<h3><jsp:getProperty name="dto2" property="email" /></h3>
<h3><jsp:getProperty name="dto2" property="phone" /></h3>
</body>
</html>
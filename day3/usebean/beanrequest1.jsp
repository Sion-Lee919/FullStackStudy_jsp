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
<%-- <%request.setAttribute("dto2", dto2); %> == scope="request" (같은말) --%>
<jsp:forward page="beanrequest2.jsp" />
<!--  
<jsp:setProperty property="id" name="dto2"/>
<jsp:setProperty property="name" name="dto2" />
<jsp:setProperty property="pw" name="dto2"/>
<jsp:setProperty property="email" name="dto2"/>
<jsp:setProperty property="phone" name="dto2"/>
-->

</body>
</html>
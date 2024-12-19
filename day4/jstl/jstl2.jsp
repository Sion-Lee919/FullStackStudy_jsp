<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- el,jstl만 사용 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 파라미터 요청 -->
<c:set var="sum" value="${param.num1+param.num2 }" />
${sum }
<c:choose>
<c:when test="${sum>=200 }">
파랑
</c:when>
<c:when test="${sum>=100 }">
녹색
</c:when>
<c:otherwise>
빨강
</c:otherwise>
</c:choose>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 3자리마다 콤마 -->
<fmt:formatNumber value="1234567.89" /><br>

<!-- 3자리마다 콤마 X -->
<fmt:formatNumber value="1234567.89" groupingUsed="false"/><br>

<!-- 퍼센트 통화표시 -->
<fmt:formatNumber value="0.5" type="percent"/><br>
<fmt:formatNumber value="10000" type="currency"/><br>
<fmt:formatNumber value="10000" type="currency" currencySymbol="$"/><br>


<!-- 자릿수 지정 . pattern #(출력x), 0(출력) --><!-- 반올림 -->
<fmt:formatNumber value="1234567.06912345" pattern="#,#00.0"/><br>
<fmt:formatNumber value="1234567" pattern=".#"/><br>


<!-- java.util.Date 객체를 문자열화(SimpleDateFormat - 포맷팅) -->
<c:set var ="now" value="<%=new java.util.Date() %>"/>
${now }<br>
<fmt:formatDate value="${now }" pattern="yyyy년도 MM월dd일 E요일 HH시 mm분 ss초" /><br>


<!-- 문자열을 Date객체로 변환 -->
<!--<input type="date" name="time"> ${param.time}==> "2024-12-20" ==> Date변환 -->
<fmt:parseDate value="2024/12/20" pattern="yyyy/MM/dd" var="time"></fmt:parseDate>
${time }
</body>
</html>
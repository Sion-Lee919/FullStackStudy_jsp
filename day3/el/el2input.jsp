<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="el2.jsp" method="get">
<%-- 	아이디<input type="text" name="id" value="<%=request.getParameter("id")%>"><br>
	암호<input type="password" name="pw" value="<%=request.getParameter("pw")%>"><br> --%>
	아이디<input type="text" name="id" value="${param.id }"><br>
	암호<input type="password" name="pw" value="${param.pw }"><br>
	간식메뉴<select name="snack" multiple="multiple">
			<option value="짜장면">짜장면</option>
			<option value="케잌">케잌</option>
			<option value="빵">빵</option>
			<option value="라면">라면</option>
			<option value="아이스크림">아이스크림</option>
		</select>
	<input type="submit" value="주문">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <h3>jsp출력(현재페이지에서만):<%=s1 %></h3> --%>

<h3>jsp출력(현재페이지에서만):<%=pageContext.getAttribute("s2") %></h3>
<h3 style="color: red;">EL출력(현재페이지에서만):${pageScope.s2 }</h3>

<h3>jsp출력(include/forward파일공유):<%=request.getAttribute("s2") %></h3>
<h3 style="color: red;">EL출력(include/forward파일공유):${requestScope.s2 }</h3>

<h3>jsp출력(브라우저공유):<%=session.getAttribute("s2") %></h3>
<h3 style="color: red;">EL출력(브라우저공유):${sessionScope.s2 }</h3>

<h3>jsp출력(동일컨텍스트공유):<%=application.getAttribute("s2") %></h3>
<h3 style="color: red;">EL출력(동일컨텍스트공유):${applicationScope.s2 }</h3>

<h3 style="color: red;">EL출력(어디 공유?):${s2 }</h3>
</body>
</html>
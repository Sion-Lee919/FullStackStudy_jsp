<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>세션생성시각<%=session.getCreationTime() %></h3>
<h3>세션id=<%=session.getId() %></h3>
<h3>세션생성여부=<%=session.isNew() %></h3>
</body>
</html>
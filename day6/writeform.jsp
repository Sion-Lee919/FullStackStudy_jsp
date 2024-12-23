<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="boardstart" method="post">
<input type=hidden name="menu" value="write" >
<label for="title">제목</label> <input type="text" id="title" name="title"><br>
<label for="contents">내용</label><textarea rows="3" cols="100" id="contents" name="contents"></textarea><br>
<label for="pw">글암호</label> <input type="number" id="pw" name="pw">
글작성자 <input type="text" id="writer" name="writer" value="${sessionScope.sessionid }" readonly="readonly">
<input type="submit" value="작성완료">
</form>
</body>
</html>
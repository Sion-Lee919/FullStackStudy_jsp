<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> ${param.id } 회원님의 암호는 ${param.pw } 입니다.</h1>
<h1>주문 목록입니다.</h1>
${paramValues.snack[0] },
${paramValues.snack[1] },
${paramValues.snack[2] },
${paramValues.snack[3] },
${!empty paramValues.snack[4]?paramValues.snack[4]:"선택없음" }
</body>
</html>
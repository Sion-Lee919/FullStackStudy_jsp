<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성자</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="board" items="${boardlist}">
                <tr>
                    <td>${board.seq}</td>
                    <td>${board.title}</td>
                    <td>${board.contents}</td>
                    <td>${board.writer}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2>카테고리 목록</h2>
    <table>
        <thead>
            <tr>
                <th>카테고리</th>
                <th>세부 항목</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="entry" items="${categorymap}">
                <tr>
                    <td>${entry.key}</td>
                    <td>
                        <ul>
                            <c:forEach var="subcategory" items="${entry.value}">
                                <li>${subcategory}</li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
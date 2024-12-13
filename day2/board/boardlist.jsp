<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판 목록</h1>
<ul>
<%
 ArrayList<BoardDTO> list =(ArrayList<BoardDTO>)request.getAttribute("boardlist");
	if(list != null){
		for(BoardDTO a : list){
			out.println("<li>"+list+"</li>");
			}
	}
	else{
		out.println("값이 없습니다");
	}
%>
</ul>
</body>
</html>
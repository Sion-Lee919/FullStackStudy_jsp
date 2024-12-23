<%@page import="mvc.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/servlettest/js/jquery-3.7.1.min.js" ></script>
<script>
		$(document).ready(function(){
			
			$("#update").click(function() {
				let input = prompt("비밀번호를 입력하세요");
				let dbpw =${ boarddetail.pw};
				if(input==dbpw){
	            $("input[name='menu']").val("boardupdate");
	            $("form").submit();
				}
				else{
					alert("암호를 확인하세요");
				}
	        });
			
			 $("#del").click(function() {
				 let input = prompt("비밀번호를 입력하세요");
					let dbpw =${ boarddetail.pw};
					if(input==dbpw){
		            $("input[name='menu']").val("boarddelete");
		            $("form").submit();
					}
					else{
						alert("암호를 확인하세요");
					}
		        });
		});

</script>
</head>
<body>
<h1>상세 게시글입니다</h1>
<form action="boardstart" method="post">
<input type="hidden" name="menu" value="">
<table border="2">
	<tr><td>번호</td><td><input type="text" name="seq" value='${boarddetail.number }' readonly="readonly"></td></tr>
	<tr><td>제목</td><td><input type="text" name="title" value='${boarddetail.title }'></td></tr>
	<tr><td>내용</td><td><textarea cols="50" rows="3" name="contents">${boarddetail.contents }</textarea></td></tr>
	<tr><td>작성자</td><td><input type="text" name="writer" value='${boarddetail.writer }' readonly="readonly"></td></tr>
	<tr><td>조회수</td><td><input type="text" name='viewcount' value='${boarddetail.viewcount }' readonly="readonly"></td></tr>
	<tr><td>작성시간</td><td>${boarddetail.writingtime }</td></tr>
	<tr ><td colspan="2"><input type="button" id='update' name="boardupdate"  value="수정버튼"><input type="button" id='del' name="boarddelete" value="삭제버튼"></td></tr>
</table>
</form>
</body>
</html>
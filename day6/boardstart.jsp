<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/servlettest/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#boardwritelink").on('click',function(e){
		//jsp변수 접근
		let sessionid = <%=session.getAttribute("sessionid") %>;
		if(sessionid ==null){
			e.preventDefault();
		}
	});
});
</script>
</head>
<body>
<%if(session.getAttribute("sessionid")!=null){ %>
	<h6><%=session.getAttribute("sessionid") %></h6>
	<h6>${sessionScope.sessionid }</h6>
<%}
else{
	%>
	<h6>로그인한적이 없습니다</h6>
	<%
	}
	%>
<h1>나의 게시판 프로젝트</h1>
<h3>메뉴틀</h3>
<ul>
<li><a href='boardstart?menu=loginform'>로그인</a></li>
<li><a href='boardstart?menu=logout'>로그아웃</a></li>
<li><a href='boardstart?menu=writingform' id="boardwritelink">글쓰기</a></li><!-- 로그인 이후 사용가능 -->
<li><a href='boardstart?menu=boardlist&page=1'>게시물 리스트보기</a></li><!-- 로그인 없이 관람가능 -->

</ul>
</body>
</html>
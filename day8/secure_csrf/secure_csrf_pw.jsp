<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/servlettest/js/jquery-3.7.1.min.js" ></script>
<script>
		$(document).ready(function(){
			
		});
</script>	
</head>
<body>
<% 
/* //다른서버 해킹 사이트에서 요청보낸건지 필터링
String referer = request.getHeader("Referer");//요청하는사이트
String host = request.getHeader("host");//현재 나의 사이트
if(referer==null || !referer.contains(host)){
	out.println("csrf 공격입니다. 변조된 사이트입니다.");
	out.println(referer+" : "+host);
	return;
} */

//토큰을 사용하기
String csrfTokenParam = request.getParameter("CSRF_TOKEN");//암호변경요청파일
String csrfTokenSession =(String) session.getAttribute("CSRF_TOKEN");//로그인시 생성 토큰
if(csrfTokenParam == null || !csrfTokenParam.equals(csrfTokenSession)){
	out.println("csrf 공격입니다. 토큰이 없습니다.");
	return;
}
%>
<%if(request.getParameter("pw") != null){
	session.setAttribute("sessionpw", request.getParameter("pw"));
	}
	%>
<h4><%= session.getAttribute("sessionid")%>님 암호가 변경되었습니다.</h4>
<a href="secure_csrf_mypage.jsp">내정보보기</a>
</body>
</html>
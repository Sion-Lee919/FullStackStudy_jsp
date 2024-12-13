<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
int pw = Integer.parseInt(request.getParameter("pw"));
	//id 회원정보 가져왔다 가정
	//MemberDAO - public MemberDTO getMember(String id,int pw)
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getMember(id,pw);
	
	session.setAttribute("sessionmember", dto);
%>
<h3> 로그인 완료했습니다. </h3>
<a href="/jsptest/session/mypage.jsp">내정보 보러가기</a><br>
<a href="logout.jsp">로그아웃하러 가기</a><br>
</body>
</html>
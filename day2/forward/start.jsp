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
String filename = "", role="";
String[] menu = null;
if(id != null){
	if(id.equals("admin") || id.equals("administration") || id.equals("administrator")){
		filename = "admin.jsp";
		role = "관리자";
		menu = new String[7];
		menu[0] = "모든 사용자 정보조회";
		menu[1] = "회원 강제 탈퇴";
		menu[2] = "게시판 관리";
		menu[3] = "정보조회";
		menu[4] = "상품구입";
		menu[5] = "게시물작성";
		menu[6] = "장바구니";
		}
	else{
		filename="user.jsp";
		role = "일반회원";
		menu = new String[4];
		menu[0] = "정보조회";
		menu[1] = "상품구입";
		menu[2] = "게시물작성";
		menu[3] = "장바구니";
	}
}
else{
	filename="none.jsp";
	role = "비회원";
	menu = new String[0];
}
request.setAttribute("menu", menu);

%>

<jsp:forward page="<%=filename %>">
	<jsp:param name="role" value="<%=role %>"/>
</jsp:forward>
</body>
</html>
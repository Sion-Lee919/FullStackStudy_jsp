<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String id = request.getParameter("id"); %>

<%-- <%=id %> --%>
<!-- <img id="test" src='a.png' onerror='alert(document.cookie)'> -->
<div id="here1"></div>
<div id="here2"></div>
<div id="here3"></div>

<script src="/jsptest/js/purify.js"></script>

<script>
let here1 = document.getElementById("here1");
let here2 = document.getElementById("here2");
let here3 = document.getElementById("here3");

let userinput="<%=id %>";
//here1.innerHTML = userinput;//태그 취급
//here2.textContent= userinput;//출력. 태그동작 취급 x
let sanitized = DOMPurify.sanitize(userinput); //유해 태그 필터링
here3.innerHTML = sanitized;
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 변수종류 -->
정수 : ${ 100 }<br>
실수 : ${ 2.55 }<br>
문자열 : ${ "java" }<br>
문자열 : ${ 'el' }<br>
논리값 : ${ true }<br>
논리값 : ${ 10 > 5 }<br> <!-- true -->
null : ${ null }<br><!-- 공백 -->
문자열 : ${ "java".length() }<br>
문자열 : ${ "java".replace('a','b') }<br>
static 메소드 사용 ${Math.random() }<br>

<!-- 연산자 종류 -->
덧셈 : ${100+100 }<br>
덧셈 : ${'100'+100 }<br>
덧셈 : ${'100'+'100' }<br>
<!-- += 연산은 문자열 결합 -->
덧셈 : ${ '백' += 100 +='같습니다' }<br>
나눗셈 : ${100/3 }<br>
나눗셈 : ${100 div 3 }<br>
나머지 : ${100%3 }<br>
나머지 : ${100 mod 3 }<br>

비교연산 = ${ 100>50 }<br>
비교연산 = ${ 100 gt 50 }<br>
비교연산 = ${ 100 <= 50 }<br>
비교연산 = ${ 100 le 50 }<br>
비교연산 = ${ 100 == 50 }<br>
비교연산 = ${ '별' == '별' }<br>
비교연산 = ${ '별'.equals('별') }<br>

논리연산 : ${10>5 && 10<100 }<br>
논리연산 : ${10>5 and 10<100 }<br>
논리연산 : ${10>5 or 10<100 }<br>

대입연산 : ${ i=100 }<br>
대입연산 : ${ i+i }<br>

<!-- null 판별 -->
null : ${null}<br>
null포함(산출연산시 0 자동변경) : ${100 + null}<br>

null판단 : ${empty i }<br>
null판단 : ${empty null }<br>

${name=null }<br>
name 변수 null 인지
조건삼항연산자 : ${empty name ?"없음" : name}<br>

${100+100 }<br>
\${100+100 }의결과는${100+100 }입니다.<br>
</body>
</html>
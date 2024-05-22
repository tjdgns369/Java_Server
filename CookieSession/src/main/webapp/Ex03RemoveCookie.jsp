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
	//삭제메서드는 따로 없음.
	//1. 삭제하고 싶은 쿠키의 name과 같은 name을 가진 쿠키를 생성.
	Cookie cookie= new Cookie("test","");
	//2.만료기간 0초
	cookie.setMaxAge(0);
	//3.서버에서 생성된 쿠키를 클라이언트로 전송
	response.addCookie(cookie);
%>
	<a href="Ex02GetCookies.jsp">쿠키확인</a>
</body>
</html>
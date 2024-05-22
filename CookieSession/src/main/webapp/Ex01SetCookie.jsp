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
		//쿠키 객체 생성하기 Cookie(name(String),value(String))
		Cookie cookie = new Cookie("test","테스트");
		//만료시간 설정(단위: 초)
		cookie.setMaxAge(60*60);
		//서버에서 생성된 쿠키를 클라이언트로 보내기response
		response.addCookie(cookie);
		
		//만료기간을 지정하면 session cookie로 생성 .(session 활용 시 사용됨 --> 브라우저를 끄면 전부 사라짐)
		response.addCookie(new Cookie("id","smart"));
		
	%>
		<a href="Ex02GetCookies.jsp">쿠키확인</a>
		<a href="Ex02GetCookie">쿠키확인(Servlet)</a>
		
</body>
</html>
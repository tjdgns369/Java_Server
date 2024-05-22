<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
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
		session.setAttribute("id", "쿠크쿠크369"); //문자열 넣기
		session.setAttribute("age", 24); // 숫자 넣기
		
		ArrayList<String> array= new ArrayList<>();
		array.add("삼겹살");
		array.add("김치찌개");
		session.setAttribute("food", array);  // ArrayList 넣기
		
	%>
	<a href="Ex05GetSession.jsp">세션확인</a>
	<a href="Ex05GetSession">세션확인(Servlet)</a>

</body>
</html>
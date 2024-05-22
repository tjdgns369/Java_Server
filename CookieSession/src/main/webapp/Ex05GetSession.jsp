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
		String id =(String)session.getAttribute("id");
		Integer age = (Integer)session.getAttribute("age");
		ArrayList<String> food = (ArrayList<String>)session.getAttribute("food");
%>
	id: <%=id%><br>
	age: <%=age%><br>
	<a href="Ex06RemoveSession.jsp">세션삭제</a>
	<a href="Ex07invalidate.jsp">세션삭모두제</a>
</body>
</html>
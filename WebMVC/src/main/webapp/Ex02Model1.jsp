<%@page import="java.util.ArrayList"%>
<%@page import="model_ver1.People_DTO"%>
<%@page import="java.util.List"%>
<%@page import="model_ver1.DAO_ver1"%>
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
	DAO_ver1 dao=new DAO_ver1();
	ArrayList<People_DTO> list= dao.connect();
	// 현재 인원의 수를 알아보는 기능넣기.
	int num = list.size();
	
%>
<table border=1>
	<tr>
		<th>이름</th>
		<th>전공</th>
		<th>번호</th>
	</tr>
	<%for(People_DTO x:list){ %>
	<tr>
		<td><%=x.getName()  %></td>
		<td><%=x.getMajor() %></td>
		<td><%=x.getPhone() %></td>
	</tr>
	<%} %>
	<tr>
		<td><%=num %></td>
	</tr>
	
</table>

</body>
</html>
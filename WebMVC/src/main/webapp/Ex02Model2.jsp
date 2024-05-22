<%@page import="model_ver1.People_DTO"%>
<%@page import="java.util.ArrayList"%>
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
	response.setContentType("text/html; charset=UTF-8");
	// object를 형변환  forward
	//ArrayList<People_DTO> list =(ArrayList<People_DTO>) request.getAttribute("list");
	//int num=(Integer)request.getAttribute("num");
	
	
	// session
	ArrayList<People_DTO> list =(ArrayList<People_DTO>) session.getAttribute("list");
	int num=(Integer)session.getAttribute("num");
	
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
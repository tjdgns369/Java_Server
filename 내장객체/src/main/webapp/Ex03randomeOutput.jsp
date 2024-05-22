<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	fieldset{
		display: inline;
		width: 350px;
	}	
</style>
</head>
<body align="center">
<%	String topic = request.getParameter("topic");
	String[] ran_items = request.getParameterValues("item");
	
	Random rd = new Random();
	String ran_item = ran_items[rd.nextInt(ran_items.length)];
%>
	<h1>랜덤 당첨 게임</h1>
		<fieldset>
			<legend>랜덤뽑기</legend>
			<table align="center">
				<tr>
					<td><%=topic %></td>
				</tr>
				<tr>
					<td><%=ran_item %></td>
				</tr>
			</table>
		</fieldset>
</body>
</html>
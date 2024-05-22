<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
fieldset {
	display: inline;
	width: 350px;
}
</style>
</head>
<body align="center">
	<%
	int num = Integer.parseInt(request.getParameter("num"));	
	%>
	<h1>랜덤 당첨 게임</h1>
	<form action="Ex03randomeOutput.jsp">
		<fieldset>
			<legend>랜덤뽑기</legend>
			<table align="center">
				<tr>
					<td>주제:</td>
					<td><input type="text" name="topic"></td>
				</tr>
				<% for(int i=1; i<=num; i++){%>
				<tr>
					<td>아이템 :</td>
					<td><input type="text" name="item"></td>
				</tr>
				<%}%>
				<tr>
					<td colspan="2"><input type="submit" value="랜덤뽑기"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>
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
	//post 방식으로 요청할 땐, 인코딩 방식이 필요하다.
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");		
	%>
	입력한 이름: <%=name%>
	
</body>
</html>
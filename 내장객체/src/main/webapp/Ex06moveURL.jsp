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
	String url= request.getParameter("url");
	String moveURL;
	if(url.equals("네이버")){
		moveURL="https://www.naver.com/";		
	}else if(url.equals("다음")){
		moveURL="https://www.naver.com/";	
	}else{
		moveURL="https://www.google.com/";
	}
	response.sendRedirect(moveURL);
	%>

</body>
</html>
<%@page import="com.smhrd.model.Member_DTO"%>
<%@page import="org.apache.ibatis.javassist.compiler.ast.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요</h1>
	
	<a href="join.html"><button>회원가입</button></a>
	<a href="login.html"><button>로그인</button></a>
	<%
	try{
		Member_DTO logMember=(Member_DTO)session.getAttribute("member");		
	if(logMember != null){
		out.print(logMember.getId());
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	%>
	<!-- <form action="login.html" align="center">
	<input type="submit" value="로그인">
	</form>	
	<form action="join.html" align="center">
	<input type="submit" value="회원가입">
	</form> 
	-->

</body>
</html>
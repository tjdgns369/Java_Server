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
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("name");
	int java = Integer.parseInt(request.getParameter("java"));
	int web = Integer.parseInt(request.getParameter("web"));
	int iot = Integer.parseInt(request.getParameter("iot"));
	int android = Integer.parseInt(request.getParameter("android"));
	double avg = (java+web+iot+android)/4.0;
	
	String grade;
	if(avg>=95){
		grade="A+";
	}else if(90<=avg){
		grade="A";
	}else if(85<=avg){
		grade="B+";
	}else if(80<=avg){
		grade="B";
	}else{
		grade="F";
	}
%>
<fieldset>
	<legend>학점확인프로그램</legend>
		<table align="center">
			<tr><td>이름</td>
				<td><%=name%></td>
			</tr>
			<tr><td>Java점수</td>
				<td><%=java%></td>
			</tr>
			<tr><td>Web점수</td>
				<td><%=web%></td>
			</tr>
			<tr><td>Iot점수</td>
				<td><%=iot%></td>
			</tr>
			<tr><td>Adroid점수</td>
				<td><%=android%></td>
			</tr>
			<tr><td>평균</td>
				<td><%=avg%></td>
			</tr>			
			<tr><td>학점</td>
				<td><b><%=grade%></td>
			</tr>		
		</table>
</fieldset>
</body>
</html>
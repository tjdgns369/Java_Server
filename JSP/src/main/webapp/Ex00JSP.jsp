<!-- 지시자(Directive) : JSP 설정 정보 및 다른 문서에 포함한다 등의 내용 작성할 때 -->
<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- contentType : 응답데이터의 형식과 인코딩방식을 "브라우저"에게 알려주기 위해서사용!! -->
<!-- pageEncoding : JSP 페이지에 대한 인코딩 지정. -->
<!-- 1.지시자의 종류 : page, taglib(JSTL), include
	 2.내장객체 : 대표 out, request, response -->    
    
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 주석은 html주석을 스크립트릿에서는 자바 주석을 사용할 수 있다. -->
	<%
		//스크립트릿(Scriptlet): JSP페이지 내부에 자바코드를 삽입하는데 사용한다.
		//.java 클래스내에 작성하는 코드 그대로 작성 (세미콜론 필수)
		int num1 =20;  // 스크립트릿에 작성한 변수/상수 선언 코드는 service메서드 아래에 작성된다.(지역변수)
		int num2=30;
		int sum=num1+num2;
		
		Random rd = new Random();
		out.print(rd.nextInt());
		
	%>
	<%= 				sum%> <!-- 표현식(Expression): 화면에 출력하기 위해서 사용!(세미콜론은 작성x)  -->

	<%!
		public void hi(){
		System.out.print("hi");
		}	
	%>
	<% hi(); %>

</body>
</html>
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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("smart")&&pw.equals("123")){
			//성공페이지 이동
			
			request.setAttribute("id", id); // request 영역에 데이터를 저장하는 방법
			
			//RequestDispatcher : 클라이언트로 부터 최초로 들어온 요청을 원하는 자원으로 넘기는 등의 메서드를 가짐
			RequestDispatcher rd=request.getRequestDispatcher("Ex07LoginSuccess.jsp");
			//forward : 다음페이지로 request, response를 넘기는 역할
			rd.forward(request, response);
			//response.sendRedirect("Ex07LoginSuccess.jsp");
		}else{
			//실패페이지
			response.sendRedirect("Ex07LoginFail.jsp");
		}	
	%>

</body>
</html>
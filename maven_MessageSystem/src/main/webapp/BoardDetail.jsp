<%@page import="com.smhrd.model.BoardDTO"%>
<%@page import="com.smhrd.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Message System Example</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assetsBoard/css/main.css" />
		<link rel="stylesheet" href="assetsBoard/css/board.css" />
</head>
<body>
			<!-- Q19. 게시글 세부내용 조회 기능 -->
			
			<% 
				int num =  Integer.parseInt(request.getParameter("num"));
				BoardDAO dao = new BoardDAO();
				BoardDTO result = dao.showDetail(num);
				
			%>
			<div id = "board">
				<table id="list">
					<tr>
						<td>제목</td>
						<td><%=result.getTitle() %></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><%=result.getWriter()%></td>
					</tr>
					<tr>
						<td>다운로드</td>
						<td><a href ="<%=result.getFilename()%>" download>다운로드</a></td>
					</tr>
					<tr>
						<td colspan="2">내용</td>
					</tr>
					<tr>
						<td colspan="2">
							<img src = "file/<%=result.getFilename()%>" /> <br>
							<%=result.getContent()%>
							
						</td>
					</tr>
					<tr>
						<td colspan="2"><a href="BoardMain.jsp"><button>뒤로가기</button></a></td>
					</tr>
				</table>
			</div>
			<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
</body>
</html>
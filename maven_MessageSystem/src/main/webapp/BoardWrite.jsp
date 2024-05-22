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
			<!-- Q16. 게시글 작성 기능(작성된 게시글은 DB에 저장) -->
			
			<!-- 파일 전송을 위한 조건들! 
				1. cos.jar 파일이 꼭! 필요하다 ->  pom.xml에 라이브러리 추가!
				2. form 사용! -> enctype 속성 사용!
				 : enctype="multipart/form-data"
				 : 전송되는 데이터의 형식을 지정하는 속성으로 파일을 form 태그를 사용하여 전달시 꼭 필요한 속성이다!
				 (method 방식이 post 방식일 때에만 사용 가능!)
				 해당 속성을 사용하지 않으면 전송시 파일의 경로만 텍스트로 넘어가고 실제 파일 자체는
				 넘어가지 않는다.
				 
				3. sevlet 에 MultipartRequest 객체 사용!
			
			
			-->
			<div id = "board">
				<form action = "WriterService.do" method= "post" enctype="multipart/form-data">
				<table id="list">
					<tr>
						<td>제목</td>
						<td><input type="text" name="title"> </td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name ="writer" > </td>
					</tr>
					<tr>
						<td colspan="2">내용</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="file" name="filename" style="float: right;">
							<textarea name = "content" rows="10" style="resize: none;"></textarea>			
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="reset" value="초기화">
							<input type="submit" value="작성하기">
						</td>
					</tr>
				</table>
				</form>
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
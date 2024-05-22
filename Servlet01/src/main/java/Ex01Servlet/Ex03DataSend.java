package Ex01Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DataSend")
public class Ex03DataSend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1. 한글 인코딩
		response.setContentType("text/html;charset=UTF-8");
		// 2. 요청받은 데이터 꺼내기
		String name = request.getParameter("name");
		// 3. 출력도구 꺼내기
		PrintWriter out= response.getWriter();
		// 4. 화면에 출력하기
		out.print("<h3>"+name+"</h3>");
		
		
		
		
		
	}

}

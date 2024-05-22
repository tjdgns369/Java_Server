

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

@WebServlet("/Ex08LoginCheck")
public class Ex08LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");	
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out= response.getWriter();
		if(id.equals("test")&&pw.equals("12345")){
			//1. 세션에 id값 넣어주기
			// 1-1 세션객체만들기
			HttpSession session= request.getSession();
			// 1-2 세션에 id값 넣기
			session.setAttribute("id", id);
			//2. 메인페이지로 이동하기
			// sendRedirect / forward
			// DB에 변화있을 때 / DB에 변화 없을 때  ==> 사용해야 안전하다
			// 기본이 Get방식
			// ->method를 post
			// 2-1. sendRedirect
			// response.sendRedirect("Ex08Main.jsp");
			// 2-2. forward
			RequestDispatcher rd = request.getRequestDispatcher("Ex08Main.jsp");
			rd.forward(request, response);		
		}else{
			//로그인 페이지로 이동
			response.sendRedirect("Ex08Login.html");
		}
		
	}

}

package Ex01Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MakeTable")
public class Ex02MakeTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//1행 6열 짜리 테이블 출력
		out.print("<table border='1' bordercolor='red'>");
		out.print("<tr>");
		
		for(int i=1;i<7;i++) {
			out.print("<td>" +i +"</td>");
		}
		out.print("</tr>");
				
		out.print("</table>");

	}

}

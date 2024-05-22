package Ex01Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Operation")
public class Ex07Operation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String num1 = request.getParameter("num1");
		int n1 = Integer.parseInt(num1);
		String num2 = request.getParameter("num2");
		int n2 = Integer.parseInt(num2);
		String op = request.getParameter("operation");
		
		int result = 0;
		if (op.equals("+")) {
			result = n1 + n2;
		} else if (op.equals("-")) {
			result = n1 - n2;
		} else if (op.equals("*")) {
			result = n1 * n2;
		} else if (op.equals("/")) {
			result = n1 / n2;
		}
		
		out.print("<h1>");
		out.print(n1 + op + n2 + "=" + result);
		out.print("</h1>");
	}

}

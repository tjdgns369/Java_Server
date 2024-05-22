package Ex01Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MakeTable1")
public class Ex06MakeTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 인코딩 잡아주기
		response.setContentType("text.html;charset=UTF-8");
		// 프린트 기능 꺼내오기
		PrintWriter out = response.getWriter();
		
		// 요청데이터 꺼내오기
		String name = request.getParameter("number");
		
		// *****문자열을 숫자로 형변환*****
		// 문자열(객체형체)을 기본자료형(정수, 실수)으로 변환 할 때는
		// Wrapper Class를 사용해서 변환할 수 있다.
		// Wrapper Class란??
		//  : 기본 자료형들을 마치 레퍼런스 자료형(객체형태)로 만들어 놓은 것
		int num = Integer.parseInt(name);
		out.print("<table border='1'>");
		out.print("<tr>");

		for (int i = 1; i <= num; i++) {
			out.print("<td>" + i + "</td>");
		}

		out.print("</tr>");
		out.print("</table>");

	}

}

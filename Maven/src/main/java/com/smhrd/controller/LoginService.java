package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;

import org.apache.ibatis.javassist.compiler.ast.Member;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.Member_DTO;


public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member_DTO member= new Member_DTO(id, pw);
		
		MemberDAO dao=new MemberDAO();
		Member_DTO logMember= dao.login(member);
		
		if(logMember !=null) {
			HttpSession session=request.getSession();
			session.setAttribute("member", logMember);
			response.sendRedirect("main.jsp");
		}else {
			response.sendRedirect("Login.html");
		}
	}

}

package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;

import frontcontroller.command;

public class DeleteService implements command {
		
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {

	
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String email = request.getParameter("email");
		HttpSession session = request.getSession();

		MemberDAO dao = new MemberDAO();

		int cnt = dao.deleteMember(email);
		
		
		
		if (cnt > 0) {
			System.out.println("삭제 성공");
			session.setAttribute("delete", email);

		} else {
			System.out.println("삭제 실패..");
		}
		return "ShowMember.jsp";

	}

}

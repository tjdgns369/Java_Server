package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MessageDAO;

import frontcontroller.command;

public class DelMessageAllService implements command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");
		int cnt = new MessageDAO().deleteMessageAll(email);

		if (cnt > 0) {
			System.out.println("전체삭제 성공");
		} else {
			System.out.println("전체삭제 실패");
		}

		return "Main.jsp";
	}
}

package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MessageDAO;

import frontcontroller.command;

public class DelMessageService2 implements command {
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {


		int num = Integer.parseInt(request.getParameter("num"));

		int cnt = new MessageDAO().deleteMessage(num);

		if (cnt > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}

		return "Main.jsp";
	}

}

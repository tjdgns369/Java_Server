package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontcontroller.command;

public class LogoutService implements command{
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
//		session.invalidate();//모든 세션 지우기
		
		return "Main.jsp";
	}
		
		
	}



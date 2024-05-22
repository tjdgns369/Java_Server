package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;

import frontcontroller.command;

public class EmailCheckService implements command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("EmailCheckService 도착");
		String inputE = request.getParameter("inputE");
		
		response.setContentType("text/plain; charset=UTF-8"); // Content-Type 설정
        response.setCharacterEncoding("UTF-8"); // 응답 인코딩 설정
		Boolean checkE = new MemberDAO().emailCheck(inputE);

		PrintWriter out;

		try {
			out = response.getWriter();
			out.print(checkE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}

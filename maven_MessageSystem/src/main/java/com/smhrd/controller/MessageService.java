package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MessageDAO;
import com.smhrd.model.MessageDTO;

import frontcontroller.command;

public class MessageService implements command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// 1. 인코딩 작업
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2. 데이터 꺼내오기
		String sendName = request.getParameter("sendName");
		String receiveEmail = request.getParameter("receiveEmail");
		String message = request.getParameter("message");

		// 3. 데이터베이스에 해당 내용 전달하기!! -> MemssageDAO 클래스
		MessageDAO dao = new MessageDAO();
		MessageDTO dto = new MessageDTO();

		dto.setSendName(sendName);
		dto.setReceiveEmail(receiveEmail);
		dto.setMessage(message);

		int result = dao.sendMessage(dto);

		if (result > 0) {
			System.out.println("메세지 전송 성공!");

		} else {
			System.out.println("메세지 전송 실패!");
		}

		return "Main.jsp";

		// DAO의 sendMessage() 생성
		// MessageDTO() 생성

	}

}

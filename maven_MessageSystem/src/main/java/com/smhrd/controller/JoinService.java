package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

import frontcontroller.command;

public class JoinService implements command {

	public String execute(HttpServletRequest request,HttpServletResponse response) {

	
	
		// 회원가입을 위한 서비스!
		// 1. 요청값 인코딩하여 받아오기!
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html; charset=utf-8");

		// 2. 요청값에서 필요한 데이터 꺼내오기!
		// -> email. pw, tel, address 변수에 꺼내온 데이터 저장
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		// 3. 처리해야 하는 로직 구현 -> 회원가입!
		
		MemberDTO dto = new MemberDTO(email, pw, tel, address);
		MemberDAO dao = new MemberDAO();
		
		int result = dao.join(dto);

		// 4. 결과처리
			if(result >0) {
				//회원가입 성공시
				//회원의 이메일 값을 JoinSuccess.jsp 페이지로 공유하기!
//				response.sendRedirect("JoinSuccess.jsp");
				
				// -> 페이지 이동 방식 -> forward 방식
				request.setAttribute("email", email);
				
//				RequestDispatcher rd = request.getRequestDispatcher("JoinSuccess.jsp");
//				try {
//					rd.forward(request, response);
//				} catch (ServletException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				return "JoinSuccess.jsp";
			}
			else {
				return "Main.jsp";
			}

	}

}

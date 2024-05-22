package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

import frontcontroller.command;

public class UpdateService implements command {
	public String execute(HttpServletRequest request,HttpServletResponse response) {

		//요청데이터 가져오기
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		
		HttpSession session = request.getSession();
		
		MemberDTO info = (MemberDTO)session.getAttribute("member");
		// MemberDTO 객체 생성하기
		MemberDTO updateMember  = new MemberDTO(info.getEmail(),pw,tel,address);
		
		//DAO에 기능 update기능 호출하기
		int cnt = new MemberDAO().updateMember(updateMember);
		
		//콘솔창에서 성공 실패 확인하기
		if(cnt>0) {
			
			System.out.println("수정 성공");
			session.setAttribute("info", updateMember);
			return "Main.jsp";
			
		}else {
			System.out.println("수정 실패..");
			return "UpdateMember.jsp";
		}
		
	
	}
}

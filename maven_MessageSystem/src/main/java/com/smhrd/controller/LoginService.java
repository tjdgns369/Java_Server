package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

import frontcontroller.command;

public class LoginService implements command{

	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
	
		 
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String email =  request.getParameter("email");
		String pw = request.getParameter("pw");
		
		
		
		
		MemberDAO dao = new MemberDAO();
		MemberDTO member  = new MemberDTO(email, pw);
		
		
		MemberDTO loginMember = dao.login(member);
		System.out.println(loginMember);
		
		System.out.println(member.getEmail());
		System.out.println(member.getPw());
		
		
		
		
		
		if(loginMember!=null) {
			//회원의 정보를 저장하여 이용할 수 있또록 수정! -> Session 영역
			// session 영역 불러오기!
			HttpSession session = request.getSession();
			session.setAttribute("member", loginMember);
			
		}
//			response.sendRedirect("Main.jsp");
		
		
		//1.인코딩 작업
		
		//2. 데이터 꺼내오기!
		
		//3. 로그인이 가능한지 판단! -> DAO 전달 -> login() 메소드 생성!
		
		//4. 로그인 결과에 따른 페이지 이동! -> ㅡMain.jsp    sendredirect 사용
		
		return "Main.jsp";
	}
		
		
	}



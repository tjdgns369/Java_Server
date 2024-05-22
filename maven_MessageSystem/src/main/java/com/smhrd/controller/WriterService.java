package com.smhrd.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.model.BoardDAO;
import com.smhrd.model.BoardDTO;

import frontcontroller.command;

public class WriterService implements command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// MultipartRequest : 파일 업로드를 위한 요청객체
		// 1. request : MultipartRequest 연결하기 위한 요청(request)!
		// 2. path : 서버측에 파일을 저장할 경로 -> 상대경로
		// 3. maxSize : 파일의 최대 크기 지정! (1024*1024 = 1MB) (1024*1024*2) = 2MB
		// 4. encoding : 파일명에 대한 인코딩 작업!
		// 5. DefaultFileRenamePolicy : 파일의 이름이 중복되는 경우 덮어쓰기를 방지할 수 있는 객체

		String path = request.getServletContext().getRealPath("file");
		// 서버에 파일을 저장할 디렉토리 경로
		int maxSize = 3 * 1024 * 1024; // 최대 3MB지정
		String encoding = "UTF-8"; // 인코딩 설정
		DefaultFileRenamePolicy rename = new DefaultFileRenamePolicy();

		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, path, maxSize, encoding, rename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String filename = null;
		try {
			filename = URLEncoder.encode(multi.getFilesystemName("filename"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String content = multi.getParameter("content");

		System.out.println("title : " + title);
		System.out.println("writer : " + writer);
		System.out.println("filename : " + filename);
		System.out.println("content : " + content);

		// 데이터베이스 전달을 위한 작업!

		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();

		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setFilename(filename);
		dto.setContent(content);

		int result = dao.upload(dto);

		if (result > 0) {
			System.out.println("게시글 등록 성공!");
		} else {
			System.out.println("등록 실패!");
		}
		return "BoardMain.jsp";

	}

}

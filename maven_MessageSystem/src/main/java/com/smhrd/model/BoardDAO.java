package com.smhrd.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class BoardDAO {

	SqlSessionFactory sqlSessionFactory  = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession(true);

	//게시글 작성에 대한 메소드
	
	public int upload(BoardDTO dto) {
		int result = sqlSession.insert("upload", dto);
		
		if (result > 0 ) {
			System.out.println("업로드 성공!");
		}
		sqlSession.close();
		
		return result;
	}
	
	
	public ArrayList<BoardDTO> showBoard(){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		
		try {
			list = (ArrayList)sqlSession.selectList("showBoard");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return list;
	}
	
	
	public BoardDTO showDetail(int num) {
		BoardDTO list = null;
		try {
			list = (BoardDTO)sqlSession.selectOne("showDetail",num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return list;
		
	}
}

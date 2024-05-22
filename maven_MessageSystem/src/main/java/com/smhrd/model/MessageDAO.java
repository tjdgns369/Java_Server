package com.smhrd.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MessageDAO {

	SqlSessionFactory sqlSessionFactory  = SqlSessionManager.getSqlSession();

	
	public int sendMessage(MessageDTO dto){
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		int result = sqlSession.insert("sendMessage", dto);
		
		sqlSession.close();

		return result;
		
	}
	
	public ArrayList<MessageDTO> showMessage(String email){
		//사용할 aarayList 생성
		ArrayList<MessageDTO> m_list  = new ArrayList<MessageDTO>();
		//1. sql 대여
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//2. sql 실행
		m_list = (ArrayList)sqlSession.selectList("showMessage",email);
		//3. 결과 처리;
		sqlSession.close();
		//4. sql 반납
		return m_list;
	}
	
	
	public int deleteMessage(int num) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = sqlSession.delete("deleteMessage", num);
		sqlSession.close();
		return cnt; 
		
	}
	
	public int deleteMessageAll(String email) {
		 SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = sqlSession.delete("deleteMessageAll",email);
		sqlSession.close();
		
		return cnt;
		
	}
}

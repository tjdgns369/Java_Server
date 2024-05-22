package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDAO {
	
	// SqlSessionFactory 불러오기 : DB관련 기능을 사용할 수 있는 세션을 만들어주는 공장.
	/*sqlSessionManager -> SqlSessionFactory를 만드는 클래스
						-> DB연결과 SQL실행에 대한 모든것을 가진 객체			
						*/
	SqlSessionFactory sqlSessionFactory = sqlSessionManager.getSqlSession();
	
	// 각 기능을 수행하는 세션을 저장하는 변수.
	SqlSession sqlSession;
	
	// 기존 DAO처럼 각 SQL문을 실행할 메서드 만들기
	//로그인 기능
	public Member_DTO login(Member_DTO member) {
		// openSession(autocommit)
		sqlSession = sqlSessionFactory.openSession(true);
		Member_DTO loginMember=null;		
		
		//sqlSession.  --> sql문의 쿼리키워드들이 들어있다.
		//mapper에 있는 것들을 가져온다.
		try { //쿼리를 실행했을 때 결과가 없을 수 있음으로
		loginMember = sqlSession.selectOne("MemberDAO.select", member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return loginMember;
	}
	
	//회원가입 기능
	public int join(Member_DTO member) {
		sqlSession=sqlSessionFactory.openSession(true);
		
		int res = sqlSession.insert("MemberDAO.JoinInsert", member);
		sqlSession.close();
		return res;
	}
}
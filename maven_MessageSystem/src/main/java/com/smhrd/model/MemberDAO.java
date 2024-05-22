package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MemberDAO {

	//데이터베이스에 연결하여 쓸 수 있는 기능 작업!
	
	SqlSessionFactory sqlSessionFactory  = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession(true);
	
	public int join(MemberDTO dto){
		//1. sqlSession 빌려오기
		
		//2. sql문장 전달!
		int result = sqlSession.insert("join", dto);
		
		
		//3. 결과 처리
		if (result > 0 ) {
			System.out.println("회원 가입 성공!");
		}
		sqlSession.close();
		
		return result;
		
		//4. sqlSession 반납!
		
	}
	
	public MemberDTO login(MemberDTO dto) {
		//openSession -> (오토커밋)
		
		MemberDTO member = null;
		
		try {//쿼리를 실행했을때 결과가 없을 수도 있으므로.
			member = sqlSession.selectOne("com.smhrd.db.MemberMapper.select",dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return member;
	}
	
	
	
	public int updateMember(MemberDTO updateMember){
		int cnt = 0;
		
		
		try {
	        // MyBatis 매퍼 파일에 정의된 update 문의 id와, 업데이트할 데이터를 담고 있는 객체를 전달
	        cnt = sqlSession.update("com.smhrd.db.MemberMapper.updateMember", updateMember);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (sqlSession != null) {
	            sqlSession.close();
	        }
	    }
		
		return cnt;
	}
	
	//전체 회원 조회
	
	public List<MemberDTO> allMember(){
		
		List<MemberDTO> members = null;
		
		try {
			members = sqlSession.selectList("allMember");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return members;
		
	}
	
	public int deleteMember(String email) {
		//openSession -> (오토커미)
		int cnt = 0;
		
		try {//쿼리를 실행했을때 결과가 없을 수도 있으므로.
			cnt = sqlSession.delete("deleteMember",email);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	
//중복 확인
	
	public boolean emailCheck(String inputE){
		boolean checkE = false;
		
		try {
			checkE = sqlSession.selectOne("emailCheck", inputE);
		}catch (Exception e) {
	        e.printStackTrace(); // 오류가 발생한 경우, 오류 출력
	    }finally {
	    	sqlSession.close();
	    }
		
		
		return checkE;
	}
	
	
	
	
}

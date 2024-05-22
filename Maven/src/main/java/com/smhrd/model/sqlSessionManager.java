package com.smhrd.model;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class sqlSessionManager {
	
	// 데이터베이스 연결 + SQL실행에 대한 모든 것을 가진 객체 만들기.
	public static SqlSessionFactory sqlSessionFactory;
	
	// 클래스 초기화 블럭 :  클래스가 처음 로딩될 때 딱 한번만 수행
	static {
		//설정 정보 가져오기.
		String resource = "com/smhrd/model/myBatis-config.xml";
		Reader reader;
		
		try {
			//문자열 경로로 파일 읽기
			reader = Resources.getResourceAsReader(resource);
			//읽은 정보 토대로 SqlSessionFactory 생성.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
}

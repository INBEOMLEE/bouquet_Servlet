package com.bouquet.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bouquet.mybatis.SqlMapConfig;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	private MemberDAO() {}
	
	// 외부에서 빌려서 사용할 객체 생성(instance)
	private static MemberDAO instance = new MemberDAO();
	//외부에서 getInstance()를 호출하면 객체를 빌려줌
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// 회원가입 ID중복체크(Ajax)
	public String idCheck(String id) {
		sqlSession = sqlSessionFactory.openSession();
		String result = "";
		try {
			result = sqlSession.selectOne("idCheck", id);
			
			if(result != null) { // ID가 있다 = 중복
				result="-1";
			} else { // 사용 가능한 ID
				result="1"; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
}

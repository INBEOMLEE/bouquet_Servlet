package com.bouquet.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bouquet.dto.MemberDTO;
import com.bouquet.mybatis.SqlMapConfig;

public class LoginDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	
	private LoginDAO() {}
	
	// 외부에서 빌려서 사용할 객체 생성(instance)
	private static LoginDAO instance = new LoginDAO();
	//외부에서 getInstance()를 호출하면 객체를 빌려줌
	public static LoginDAO getInstance() {
		return instance;
	}
	
	// Login시 회원가입 유무 Check
	public MemberDTO loginCheck(String bid, String bpw) {
		sqlSession = sqlSessionFactory.openSession();
		
		MemberDTO mDto = new MemberDTO();
		mDto.setBid(bid);
		mDto.setBpw(bpw);
		
		try {
			mDto = sqlSession.selectOne("loginCheck", mDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return mDto;
	}
}

package com.bouquet.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bouquet.dto.MemberDTO;
import com.bouquet.mybatis.SqlMapConfig;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result = 0;
	
	private MemberDAO() {}
	
	// 외부에서 빌려서 사용할 객체 생성(instance)
	private static MemberDAO instance = new MemberDAO();
	//외부에서 getInstance()를 호출하면 객체를 빌려줌
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// 회원가입 ID중복체크(Ajax)
	public String idCheck(String id) {
		// 19. myBatis를 사용하기 위해 sqlSession을 활성화 시킴
		sqlSession = sqlSessionFactory.openSession();
		String result = "";
		try {
			// 20. sqlSession을 활용하여 mapper.xml의 idCheck 이름의 sql문을 실행 (매개변수로 id 데이터 전송)
			// 22. DB에서 sql문을 실행하고 나온 결과를 result 변수에 담음
			result = sqlSession.selectOne("idCheck", id);
			// 23. result가 null이면 사용 가능한 ID
			//     result가 null이 아니면 중복된 ID
			//     - 사용 가능한 ID = "1"을 result에 담음
			//     - 중복된 ID = "-1"을 result에 담음
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
		// 24. IdCheckAction 클래스로 "1" or "-1" 값을 return으로 보냄
		return result;
	}
	
	public int mem_insert(MemberDTO mDto) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		try {
			result = sqlSession.insert("mem_insert", mDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
}

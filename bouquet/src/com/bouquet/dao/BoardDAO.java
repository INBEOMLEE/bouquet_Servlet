package com.bouquet.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bouquet.dto.BoardDTO;
import com.bouquet.dto.CriteriaDTO;
import com.bouquet.mybatis.SqlMapConfig;

public class BoardDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result = 0;
	BoardDTO bDto = new BoardDTO();
	List<BoardDTO> list = null;
	boolean flag = false;
	
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardDTO> listAll(CriteriaDTO criDto){
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("listAll", criDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	};
	
	// 페이지네이션에 필요한 게시글 Total 수 구하기
	public int totalCount(CriteriaDTO criDto) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.selectOne("totalCount", criDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	
}

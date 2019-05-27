package com.bouquet.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bouquet.dto.BoardDTO;
import com.bouquet.dto.GoodCntDTO;
import com.bouquet.mybatis.SqlMapConfig;

public class GoodCntDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result = 0;
	int plug = 0;
	String bid = "";
	GoodCntDTO gDto = new GoodCntDTO();
	List<BoardDTO> list = null;
	boolean flag = false;
	
	private GoodCntDAO() {}
	private static GoodCntDAO instance = new GoodCntDAO();
	public static GoodCntDAO getInstance() {
		return instance;
	}
	
	// 좋아요 +1 증가 시키면서 좋아요테이블에 등록 
	public int goodCntPlus(String bno, String bid) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, String> hMap = new HashMap<>();
			hMap.put("bno", bno);
			hMap.put("bid", bid);
			
			bid = sqlSession.selectOne("sel_goodCnt", hMap);
			
			if(bid == null) {
				result = sqlSession.update("goodCnt", bno);
				plug = sqlSession.insert("boardGoodCnt", hMap);
			} else {
				return 0;
			}
			
			if(plug > 0) {
				System.out.println("좋아요 테이블 등록 성공");
			} else {
				System.out.println("좋아요 테이블 등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	public int goodCntMinus(String bno, String bid) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, String> hMap = new HashMap<>();
			hMap.put("bno", bno);
			hMap.put("bid", bid);
			bid = sqlSession.selectOne("sel_goodCnt", hMap);
			
			if(bid != null) {
				result = sqlSession.update("goodCnt_Minus", bno);
				plug = sqlSession.delete("boardGoodCnt_del", hMap);
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	public GoodCntDTO select_goodCnt(String bno, String bid) {
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, String> hMap = new HashMap<>();
		hMap.put("bno", bno);
		hMap.put("bid", bid);
		
		System.out.println("HashMap >>>>>" + hMap.toString());
		try {
			gDto = sqlSession.selectOne("goodCheck", hMap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return gDto;
	}

	public int delete_goodCnt(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.delete("delete_goodCnt", bno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	
	
}

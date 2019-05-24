package com.bouquet.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bouquet.dto.BoardDTO;
import com.bouquet.dto.CriteriaDTO;
import com.bouquet.dto.GoodCntDTO;
import com.bouquet.mybatis.SqlMapConfig;

public class BoardDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result = 0;
	int plug = 0;
	String bid = "";
	BoardDTO bDto = new BoardDTO();
	GoodCntDTO gDto = new GoodCntDTO();
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
	
	// 게시글 1건 (상세조회)
	public BoardDTO view(String bno) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			bDto = sqlSession.selectOne("view", bno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return bDto;
	}
	
	public void viewCnt(String bno, HttpSession session) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			long update_time = 0;
			
			// null 이면 최초 방문이므로 조회수 1 증가
			// null 이 아니면 최초 방문이 아니므로 시간 비교
			if(session.getAttribute("read_time_"+bno) != null) {
				// 이전에 게시글을 조회한 시간
				update_time = (long) session.getAttribute("read_time_"+bno);
			}
			
			// 현재 시간 구하기
			long current_time = System.currentTimeMillis();
			
			// 현재 시간과 이전에 게시글 조회 시간을 비교
			// 24시간(1일)이 지났으면 조회수를 1 증가
			//            지나지 않았으면 조회수 증가 X
			if(current_time - update_time > 24 * 60 * 60 * 1000) {
				// 조회수 1 증가
				sqlSession.update("viewCnt", bno);
				
				// 조회수 1 증가한 최신 시간을 session 담음
				session.setAttribute("read_time_"+bno, current_time);
				
				// ex) 30번 게시글인 경우 read_time_30 변수를 하나 만들고 현재 시간을 담음
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 댓글 등록 또는 삭제 시 해당 게시글 replycnt +1 or -1
	public void replyCntUpdate(String bno, String flag) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		try {
			HashMap<String, String> map = new HashMap<>();
			map.put("bno", bno);
			map.put("flag", flag);
			sqlSession.update("replyCntUpdate", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public int replyCntMinus(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.update("replyCntMinus", bno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	public int boardRegister(BoardDTO bDto) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("boardRegister", bDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	
	
	
}

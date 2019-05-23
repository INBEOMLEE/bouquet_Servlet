package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bouquet.dao.BoardDAO;
import com.bouquet.dao.GoodCntDAO;
import com.bouquet.dto.BoardDTO;
import com.bouquet.dto.GoodCntDTO;
import com.bouquet.dto.MemberDTO;

public class BoardViewAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "board/view.jsp";
		String bno = request.getParameter("bno");
		String bid = "";
		
		
		MemberDTO mDto = (MemberDTO) session.getAttribute("loginUser");
		if((mDto = (MemberDTO) session.getAttribute("loginUser")) != null) {
			 bid = mDto.getBid();
		}
		
		System.out.println("bid >>>>>>> : " + bid);
		// 조회수 증가(+1)
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.viewCnt(bno, session);
		
		// 게시글 1건 (상세 조회)
		BoardDTO bDto = bDao.view(bno);
		request.setAttribute("bDto", bDto);
		
		// 좋아요 체크 여부 결정하기 위한 좋아요테이블 조회
		GoodCntDAO gDao = GoodCntDAO.getInstance();
		GoodCntDTO gDto = gDao.select_goodCnt(bno, bid);
		request.setAttribute("gDto", gDto);
		
		if(gDto != null) {
			System.out.println(gDto.toString());
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}

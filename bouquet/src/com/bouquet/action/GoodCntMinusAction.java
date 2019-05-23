package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.bouquet.dao.BoardDAO;
import com.bouquet.dao.GoodCntDAO;
import com.bouquet.dto.BoardDTO;
import com.bouquet.dto.MemberDTO;

public class GoodCntMinusAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDTO mDto;
		String bid = "";
		
	
		String bno = request.getParameter("bno");
		HttpSession session = request.getSession();
		if((mDto = (MemberDTO) session.getAttribute("loginUser")) != null) {
			 bid = mDto.getBid();
		}
		
		System.out.println("bno >>>>>" + bno);
		System.out.println("bid >>>>>" + bid);
		
		GoodCntDAO gDao = GoodCntDAO.getInstance();
		int result = gDao.goodCntMinus(bno, bid);
		if(result > 0) {
			System.out.println("좋아요 -1 성공");
		} else {
			System.out.println("좋아요 -1 실패");
		}
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardDTO bDto = bDao.view(bno);
		int goodcnt = bDto.getGoodcnt();
		
		JSONObject jObj = new JSONObject();
		
		System.out.println("현재 좋아요 수 : " + goodcnt);
		jObj.put("goodcnt", goodcnt);
		jObj.put("result", result);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		return null;
	}

}

package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bouquet.dao.MemberDAO;
import com.bouquet.dto.MemberDTO;

public class DropMemberPlayAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "index.bouquet";
		HttpSession session = request.getSession();
		
		MemberDTO mDto = (MemberDTO) session.getAttribute("loginUser");
		String bid = mDto.getBid();
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.mem_delete(bid);
		
		if(result > 0) {
			System.out.println("성공");
			session.invalidate();
		} else {
			System.out.println("실패");
		}
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		
		return forward;
	}

}

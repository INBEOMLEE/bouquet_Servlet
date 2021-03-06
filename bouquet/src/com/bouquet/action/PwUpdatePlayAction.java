package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bouquet.dao.MemberDAO;
import com.bouquet.dto.MemberDTO;

public class PwUpdatePlayAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.bouquet";
		
		String bid = request.getParameter("id");
		String bpw = request.getParameter("new_pw");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto = new MemberDTO();
		int result = mDao.pwUpdate(bid, bpw);
		
		if(result > 0) {
			System.out.println("성공");
			mDto = mDao.mem_one(bid);
			HttpSession session = request.getSession();
			session.removeAttribute("loginUser");
			session.setAttribute("loginUser", mDto);
		} else {
			System.out.println("실패");
		}
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		
		return forward;
	}

}

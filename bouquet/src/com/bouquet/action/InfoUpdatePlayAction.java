package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bouquet.dao.MemberDAO;
import com.bouquet.dto.MemberDTO;

public class InfoUpdatePlayAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.bouquet";
		
		String bid = request.getParameter("id");
		String bname = request.getParameter("name");
		String bphone = request.getParameter("phone");
		String email_id = request.getParameter("email_id");
		String email_url = request.getParameter("email_url");
		String bemail = email_id + "@" + email_url;
		String bzipcode = request.getParameter("zipcode");
		String baddr1 = request.getParameter("addr1");
		String baddr2 = request.getParameter("addr2");
		
		MemberDTO mDto = new MemberDTO(bid, bname, bphone, bemail, bzipcode, baddr1, baddr2);
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.mem_update(mDto);
		
		if(result > 0) {
			System.out.println("수정 성공");
			mDto = mDao.mem_one(bid);
			HttpSession session = request.getSession();
			session.removeAttribute("loginUser");
			session.setAttribute("loginUser", mDto);
		} else {
			System.out.println("수정 실패");
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
	
		return forward;
	}

}

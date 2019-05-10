package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bouquet.dao.MemberDAO;
import com.bouquet.dto.MemberDTO;

public class MemberPlayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.bouquet";
		
		String bid = request.getParameter("id");
		String bpw = request.getParameter("pw");
		String bname = request.getParameter("name");
		String bphone = request.getParameter("phone");
		String email_id = request.getParameter("email_id");
		String email_url = request.getParameter("email_url");
		String bemail = email_id + "@" + email_url;
		String bzipcode = request.getParameter("zipcode");
		String baddr1 = request.getParameter("addr1");
		String baddr2 = request.getParameter("addr2");
		
		MemberDTO mDto = new MemberDTO(bid, bpw, bname, bphone, bemail, bzipcode, baddr1, baddr2);
		System.out.println(mDto.toString());
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.mem_insert(mDto);
		
		if (result >0) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true); // DB에 실제 값이 변하는 작업은 true (sendRedirect 방식) : insert, delete, update
		
		return forward;
	}
}

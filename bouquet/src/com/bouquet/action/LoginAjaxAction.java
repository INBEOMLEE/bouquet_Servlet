package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.bouquet.dao.LoginDAO;
import com.bouquet.dto.MemberDTO;

public class LoginAjaxAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Session(웹 저장소)을 사용하기 위해 session 객체 생성
		HttpSession session = request.getSession();
		
		String bid = request.getParameter("id");
		String bpw = request.getParameter("pw");
		
		LoginDAO lDao = LoginDAO.getInstance();
		MemberDTO mDto = lDao.loginCheck(bid, bpw);
		
		String message = "";
		
		if(mDto != null) { //로그인 성공
			// Session에 Login된 회원 정보를 담음
			// Session에서 loginUser 정보를 삭제 (혹시 모를 기존에 남아있는 값을 제거)
			session.removeAttribute("loginUser");
			// Session에 loginUser 정보를 저장
			session.setAttribute("loginUser", mDto);
			message = "1";
		} else {
			message = "-1";
		}
		
		JSONObject jObj = new JSONObject();
		jObj.put("message", message);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		return null;
	}
}

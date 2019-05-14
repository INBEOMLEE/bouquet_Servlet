package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.bouquet.dao.MemberDAO;

public class PwCheckAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = request.getParameter("id");
		String bpw = request.getParameter("pw");
		System.out.println(bid + ", " + bpw );
		
		MemberDAO mDao = MemberDAO.getInstance();
		boolean flag = mDao.pwCheck(bid, bpw);
		
		JSONObject jObj = new JSONObject();
		jObj.put("flag", flag);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		return null;
	}

}

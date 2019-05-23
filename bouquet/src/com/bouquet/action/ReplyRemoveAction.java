package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.bouquet.dao.BoardDAO;
import com.bouquet.dao.ReplyDAO;

public class ReplyRemoveAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		System.out.println(rno + ", " + bno);
		
		ReplyDAO rDao = ReplyDAO.getInstance();
		int result = rDao.replyRemove(rno, bno);
		
		if(result > 0) {
			System.out.println("댓글 삭제 성공");
			BoardDAO bDao = BoardDAO.getInstance();
			int success = bDao.replyCntMinus(bno);
			if(success > 0) { 
				System.out.println("댓글 숫자 수정(-1) 성공");
			} else {
				System.out.println("댓글 숫자 수정(-1) 실패");
			}
		} else {
			System.out.println("댓글 삭제 실패");
		}
		
		JSONObject jObj = new JSONObject();
		jObj.put("result", result);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		return null;
	}

}

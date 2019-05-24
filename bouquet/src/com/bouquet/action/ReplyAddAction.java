package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.bouquet.dao.BoardDAO;
import com.bouquet.dao.ReplyDAO;
import com.bouquet.dto.ReplyDTO;

public class ReplyAddAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String strBno = request.getParameter("re_bno");
		String content = request.getParameter("re_textarea");
		String writer = request.getParameter("re_writer");
		int bno = Integer.parseInt(strBno);
		
		ReplyDTO rDto = new ReplyDTO(content, writer, bno);
		
		System.out.println(rDto.toString());
		
		ReplyDAO rDao = ReplyDAO.getInstance();
		int result = rDao.replyAdd(rDto);
		
		if(result > 0) {
			System.out.println("댓글 등록 성공");
			BoardDAO bDao = BoardDAO.getInstance();
			String flag = "plus";
			bDao.replyCntUpdate(strBno, flag);
		} else {
			System.out.println("댓글 등록 실패");
		}
		
		JSONObject jObj = new JSONObject();
		jObj.put("result", result);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		
		return null;
	}

}

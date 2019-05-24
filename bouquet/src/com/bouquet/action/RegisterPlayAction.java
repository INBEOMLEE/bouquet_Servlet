package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bouquet.dao.BoardDAO;
import com.bouquet.dto.BoardDTO;
import com.bouquet.dto.MemberDTO;

public class RegisterPlayAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "boardList.bouquet";
		
		String title = request.getParameter("input_title");
		String content = request.getParameter("input_content");
		String writer = request.getParameter("input_writer");
		
		BoardDTO bDto = new BoardDTO(title, content, writer);
		BoardDAO bDao = BoardDAO.getInstance();
		int result = bDao.boardRegister(bDto);
		
		if(result > 0) {
			System.out.println("게시글 등록 성공");
		} else {
			System.out.println("게시글 등록 실패");
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		
		return forward;
		
		
	}

}

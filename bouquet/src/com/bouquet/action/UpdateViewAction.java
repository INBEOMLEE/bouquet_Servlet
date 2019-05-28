package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bouquet.dao.BoardDAO;
import com.bouquet.dto.BoardDTO;

public class UpdateViewAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board/modify.jsp";
		
		String bno = request.getParameter("bno");
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardDTO bDto = bDao.view(bno);
		
		request.setAttribute("bDto", bDto);
		request.setAttribute("bno", bno);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}

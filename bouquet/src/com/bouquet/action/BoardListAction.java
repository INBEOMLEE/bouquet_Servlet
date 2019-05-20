package com.bouquet.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bouquet.dao.BoardDAO;
import com.bouquet.dto.BoardDTO;
import com.bouquet.dto.CriteriaDTO;
import com.bouquet.dto.PageMakerDTO;

public class BoardListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "board/list.jsp";
		
		CriteriaDTO criDto = new CriteriaDTO();
		int page = 1;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("페이지번호 : " + page);
		criDto.setPage(page); 
		
		String sort_type = "new";
		if(request.getParameter("sort_type") != null) {
			sort_type = request.getParameter("sort_type");
		}
		System.out.println("정렬타입 : " + sort_type);
		
		// DB에서 게시글 목록 호출
		BoardDAO bDao = BoardDAO.getInstance();
		List<BoardDTO> list = bDao.listAll(criDto);
		
		// 페이지네이션 생성
		PageMakerDTO pageMaker = new PageMakerDTO();
		pageMaker.setCriDto(criDto);
		int totalCount = bDao.totalCount(criDto);
		pageMaker.setTotalCount(totalCount);
		
		// view 단으로 게시글 목록 전송
		request.setAttribute("list", list);
		request.setAttribute("pageMaker", pageMaker);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("sort_type", sort_type);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}

package com.bouquet.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bouquet.common.Constants;
import com.bouquet.dao.BoardDAO;
import com.bouquet.dao.GoodCntDAO;

public class RemovePlayAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 첨부파일 삭제
		int bno = Integer.parseInt(request.getParameter("bno"));
		String filename = request.getParameter("filename");
		
		if(!filename.equals("-")) {
			File file = new File(Constants.UPLOAD_PATH + filename);
			file.delete();
		}
		
		// 게시글 삭제
		BoardDAO bDao = BoardDAO.getInstance();
		int result = bDao.removeBoard(bno);
		
		if(result > 0) {
			System.out.println("게시글 삭제 성공");
			GoodCntDAO gDao = GoodCntDAO.getInstance();
			int code = gDao.delete_goodCnt(bno);
			if(code > 0) {
				System.out.println("좋아요 테이블에서 게시글 삭제 성공");
			} else {
				System.out.println("좋아요 테이블에서 게시글 삭제 실패");
			}
		} else {
			System.out.println("게시글 삭제 실패");
		}
		
		String url = "boardList.bouquet";
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		
		return forward;
	}
}

package com.bouquet.action;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bouquet.common.Constants;
import com.bouquet.dao.BoardDAO;
import com.bouquet.dto.BoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ModifyPlayAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		File uploadDir = new File(Constants.UPLOAD_PATH); 
		
		if(!uploadDir.exists()) { 
			uploadDir.mkdir();    
		}
		
		// 기존파일 유무와 상관없이 새로운 파일이 등록되었다면 새로운 파일을 저장함
		// ex) 만약에 기존파일 aaa.txt가 있고 새로 등록하는 첨부파일 bbb.txt가 있다면
		//     현재 upload 디렉토리에는 aaa.txt와 bbb.txt가 있음
		MultipartRequest multi = new MultipartRequest(request,
				Constants.UPLOAD_PATH,                  
				Constants.MAX_UPLOAD,                   
				"UTF-8",                                
				new DefaultFileRenamePolicy()); 
		
		int bno = Integer.parseInt(multi.getParameter("input_bno"));
		String title = multi.getParameter("input_title");
		String content = multi.getParameter("input_content");
		String writer = multi.getParameter("input_writer");
		int bFileSize = Integer.parseInt(multi.getParameter("input_basic_filesize"));
		String bFileName = multi.getParameter("input_basic_filename");
		String bCheck = multi.getParameter("input_check_yn");
		String filename = " ";
		int filesize = 0;
		
		// 새로 등록한 첨부파일이 있다면 새로 등록한 첨부파일의 filename과 filesize를 구함
		// 새로 등록한 첨부파일이 없다면 while()을 타지 않아 filename = " ", filesize = 0 으로 고정
		try {
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()) {               
				String file1 = (String) files.nextElement(); 
				filename = multi.getFilesystemName(file1);
				File f1 = multi.getFile(file1);           
				
				if(f1 != null) {
			
					filesize = (int) f1.length();          
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		if(filename == null || filename.trim().equals("")) {
			// 새로 등록한 첨부파일 없는 경우
			filename = "-";
			if(bCheck.equals("no")) { // 기존 첨부파일을 삭제 하였을 경우
				File file = new File(Constants.UPLOAD_PATH + bFileName);
				file.delete();
			} else { // 현 상태 유지
				     // 위에서 기존 첨부 파일 값을 초기화했기 때문에 다시 입력
				filename = bFileName;
				filesize = bFileSize;
			}
		} else {
			// 새로 등록한 첨부파일이 있는 경우
			// 기존 파일 있는지 체크
			if(bFileSize > 0) {
				File file = new File(Constants.UPLOAD_PATH + bFileName);
				file.delete();
			}
		}
		
		BoardDTO bDto = new BoardDTO(bno, title, content, writer, filename, filesize);
		System.out.println(bDto.toString());
		BoardDAO bDao = BoardDAO.getInstance();
		int result = bDao.modify(bDto);
		
		if(result > 0) {
			System.out.println("게시글 수정 성공");
		} else {
			System.out.println("게시글 수정 실패");
		}
		
		String url = "boardView.bouquet?bno="+bno;
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		
		return forward;
	}

}

package com.bouquet.action;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bouquet.common.Constants;
import com.bouquet.dao.BoardDAO;
import com.bouquet.dto.BoardDTO;
import com.bouquet.dto.MemberDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RegisterPlayAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파일업로드 1) 파일을 저장할 디렉토리 생성 (가장 상단에 위치)
		File uploadDir = new File(Constants.UPLOAD_PATH); // D드라이브
		
		if(!uploadDir.exists()) { // 저장할 경로가 없다면 (있으면 true, 없으면 false를 반환 → 앞에 느낌표를 붙여서 없으면 false, 있으면 true)
			uploadDir.mkdir();    // 디렉토리를 생성하세요.
		}
		
		// request를 확장시킨 MultipartReqeust 생성
		// request는 모두 String 타입
		// 파일 <- request로 전송 불가
		// 파일 <- request를 향상시킨 MultipartRequest를 사용
		// 그래서 파일뿐만 아니라 기존에 String타입도 전부 Multipart타입으로 변경해야함.
		
		// 파일업로드 2) "D:\\upload\\"로 첨부파일 저장 (가장 상단에 위치)
		MultipartRequest multi = new MultipartRequest(request,
				Constants.UPLOAD_PATH,                  // 파일업로드 디렉토리
				Constants.MAX_UPLOAD,                   // 업로드 최대 용량
				"UTF-8",                                // 인코딩
				new DefaultFileRenamePolicy());         // 파일이름 중복 정리
				
		String title = multi.getParameter("input_title");
		String content = multi.getParameter("input_content");
		String writer = multi.getParameter("input_writer");
		String filename = " ";
		int filesize = 0;
		
		// // 파일업로드 3) DB에 저장할 첨부파일의 이름과 사이즈를 구함
		try {
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()) {               // files에 값이 있는지 없는지를 판단 (파일이 있으면 true) 3개의 파일이 있으면 3번 반복
				String file1 = (String) files.nextElement(); // 첫번째로 올린 첨부파일이 file1 변수에 담음
				filename = multi.getFilesystemName(file1); // 첨부 파일의 파일이름
				File f1 = multi.getFile(file1);            // 첨부 파일의 파일
				
				if(f1 != null) {
					// filesize Long 타입으로 가져옴
					// int로 형변환             
					filesize = (int) f1.length();          // 첨부 파일의 파일 사이즈
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		// 사용자가 첨부파일을 등록하지 않았을 때 파일이름이 null 이나 ""으로 들어오는 것을 방지
		// "-"으로 저장되게 변경 
		if(filename == null || filename.trim().equals("")) {
			filename = "-";
		}
		
		
		String url = "boardList.bouquet";
		
		BoardDTO bDto = new BoardDTO(title, content, writer, filename, filesize);
		
		
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

package com.bouquet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bouquet.action.Action;
import com.bouquet.action.ActionForward;
import com.bouquet.action.ConstractAction;
import com.bouquet.action.IdCheckAction;
import com.bouquet.action.IndexAction;
import com.bouquet.action.LoginAjaxAction;
import com.bouquet.action.LoginOutAction;
import com.bouquet.action.LoginOutAjaxAction;
import com.bouquet.action.MemberAction;
import com.bouquet.action.MemberPlayAction;



@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Action action = null;
		ActionForward forward = null;
		
		// 13. uri에서 ctx를 빼고 남은 url 주소를 command 변수에 담음
		//     실행: /bouquet/idCheck.bouquet
		//        - /bouquet
		// ----------------------------------------------
		//        = /idCheck.bouquet (결과 값을 command에 담음)
		String uri = request.getRequestURI(); 
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		
		System.out.println("페이지 이동 ===>" + command);
		
		// 14. 생성된 command 조건에 맞는 if문 실행
		//     command = /idCheck.bouquet
		if(command.equals("/index.bouquet")) {
			action = new IndexAction();
			forward = action.excute(request, response);
		} else if(command.equals("/constract.bouquet")) {
			action = new ConstractAction();
			forward = action.excute(request, response);
		} else if(command.equals("/member.bouquet")) {
			action = new MemberAction();
			forward = action.excute(request, response);
		} else if(command.equals("/idCheck.bouquet")) {
			// 15. IdCheckAction 클래스 객체 생성
			//     결과물 : action 인스턴스
			//     action 인스턴스를 활용하여 excute() 메서드 실행
			//     매개변수로 Controller의 request와 response를 전송
			//     이동 : IdCheckAction 클래스의 excute() 메서드로 이동
			action = new IdCheckAction();
			forward = action.excute(request, response);
		} else if(command.equals("/memberPlay.bouquet")) {
			action = new MemberPlayAction();
			forward = action.excute(request, response);
		} else if(command.equals("/login.bouquet")) {
			action = new LoginAjaxAction();
			forward = action.excute(request, response);
		} else if(command.equals("/loginOut.bouquet")) {
			action = new LoginOutAjaxAction();
			forward = action.excute(request, response);
		}
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				// page 전환 시 redirect 방식
				response.sendRedirect(forward.getPath());
			} else {
				// page 전환 시 forward 방식
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}

}

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
import com.bouquet.action.MemberAction;



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
		
		String uri = request.getRequestURI(); 
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		
		System.out.println("페이지 이동 ===>" + command);
		
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
			action = new IdCheckAction();
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

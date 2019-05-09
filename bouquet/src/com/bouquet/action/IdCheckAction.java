package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.bouquet.dao.ProductDAO;

public class IdCheckAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("id >>>>" + id);
		
		// Ajax => JSON 방식 => return 할 때 보내는 값도 JSON 방식
		JSONObject jObj = new JSONObject();
		int message = 1;
		jObj.put("message", message);
		jObj.put("id", id);
		
		// JSON 객체에 담은 데이터를 호출한 페이지로 전송하는 기능
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		
		
		// AJAX방식은 목적지가 자기 자신임으로 forward(목적지, 이동수단)을 return 할 필요 없음
		return null;
	}

}

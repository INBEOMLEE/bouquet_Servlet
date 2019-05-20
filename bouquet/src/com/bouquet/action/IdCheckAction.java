package com.bouquet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.bouquet.dao.MemberDAO;

public class IdCheckAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 16. Controller에서 전송한 request를 활용하여 ajax에서 보낸 id: memId를 가져와 id 변수에 담음
		String id = request.getParameter("id");
		
		// 17. MemberDAO의 객체를 빌려와 mDao에 담음
		MemberDAO mDao = MemberDAO.getInstance();
		
		// 18. MemberDAO 클래스의 idCheck() 메서드 실행, 매개변수로 id 전송
		// 25. "-1" or "1" 값을 result 변수에 담음
		String result = mDao.idCheck(id);

		// 26. Ajax 페이지로 결과값을 JSON 방식으로 전달하기 위해 Googld Json-Simple 라이브러리를 사용하여 JSONObject 생성
		JSONObject jObj = new JSONObject();
		
		// 27. Ajax로 전달할 데이터를 담음
		//     - message 변수에 result 담음
		//     - id 변수에 id 담음
		jObj.put("message", result);
		jObj.put("id", id);
		
		// 28. JSON 객체에 담은 데이터를 호출한 페이지로 전송하는 기능
		//     결론: message와 id를 가지고 Ajax로 이동!
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		
		
		// ※ Ajax 방식은 목적지가 자기 자신이므로 forward(목적지, 이동수단)을 return 할 필요 없음
		return null;
	}

}

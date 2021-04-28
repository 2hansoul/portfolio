package com.company.signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.Mdao;
import com.company.dto.MDto;

public class delete implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession();
		Mdao dao=new Mdao();
		MDto dto=new MDto();
		
		dto.setMid((String)session.getAttribute("mid"));
		dto.setMpass(request.getParameter("mpass"));
		
		int result=dao.delete(dto);
		if(result>0){
			session.invalidate();  //탈퇴되면 세션 자체를 삭제해줌 로그인과 똑같음
			out.println("<script>alert('탈퇴성공'); location.href='"+request.getContextPath()+"/login.signup';</script>");
		 
		    }else{
		    	out.println("<script>alert('탈퇴실패 비번확인'); location.href='"+request.getContextPath()+"/login_page.signup';</script>");
			}
		System.out.println("유저삭제"+result);
		
		

	}

}

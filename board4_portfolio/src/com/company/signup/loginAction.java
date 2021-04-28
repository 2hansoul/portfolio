package com.company.signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.Mdao;
import com.company.dto.MDto;

public class loginAction implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession();
		MDto dto=new MDto();
		Mdao dao=new Mdao();
		
		
		dto.setMid(request.getParameter("mid"));
		dto.setMpass(request.getParameter("mpass"));
		
//			System.out.println("데이터 확인하기"+request.getParameter("mid"));
//			System.out.println("데이터 확인하기"+request.getParameter("mpass"));
		boolean result=dao.login(dto);
		
		 if(result==false){
			 out.println("<script>alert('로그인실패 확안하세요'); location.href='"+request.getContextPath()+"/login.signup';</script>");
		    }else{
		        session.setMaxInactiveInterval(60*10);
		        session.setAttribute("mid", dto.getMid());
		        out.println("<script>alert('로그인성공'); location.href='"+request.getContextPath()+"/login_page.signup';</script>");
		    }
		  
		  
		System.out.println("로그인 체크 값 불러와지냐?:"+result);
	
		//request.setAttribute("dto", result);  //1. 디스패치는 유지가 된다 
		// dispatcher.forward는 request가 유지가 된다
		// location , sendRedirect는 request가 유지가 안되요!!
		
	

	}

}

package com.company.signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.Mdao;
import com.company.dto.MDto;


public class passeditAction implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession();
		Mdao dao=new Mdao();
		MDto dto=new MDto();
		
		
		
		
		
		//dto.setMpass(request.getParameter("newpass"));//받아온 비번에 새로운 비번을 입력해준다
		//dto.setMpass((String)session.getAttribute("mpass"));; 
		String newpass=request.getParameter("newpass");//새로운 비번을 받아온다
		dto.setMpass(request.getParameter("mpass"));
		dto.setMid((String)session.getAttribute("mid"));
		System.out.println("새로운 비빌번호"+newpass);
		
		int result=dao.passedit(dto,newpass);
		System.out.println("비번수정"+result);
		System.out.println("비번수정"+dto);
		
		if(result>0) {
			out.print("<script> alert ('수정 성공!'); location.href='"+request.getContextPath()+"/login_page.signup'; </script>");
		}else{
            out.print("<script> alert ('수정 실패! 비번확인하세요! '); history.go(-1); </script>");
         }
		
		
		
		
	}

}

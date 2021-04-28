package com.company.signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.Mdao;
import com.company.dto.MDto;

public class idcheck implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession();
		//String result ="사용가능";
		MDto dto=new MDto();
		Mdao dao=new Mdao();
		//Syste m.out.println("1아이디 중복체크");
		
		dto.setMid(request.getParameter("mid"));
		//dto.setMid("456");
		int cnt=dao.idcheck(dto);
		//System.out.println("2.아이디 중복체크 컨트롤러:"+cnt);
		
		//request.setAttribute("mid", cnt);
	    
		out.println(cnt);
	}

}

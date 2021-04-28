package com.company.controller2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.Bdao_list;
import com.company.dto.BDto;

public class Breply implements BAciton {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		Bdao_list dao=new Bdao_list();
		BDto dto=new BDto();
		

		int bgroup=Integer.parseInt(request.getParameter("bgroup"));
		int bstep=Integer.parseInt(request.getParameter("bstep"));
		int bindent=Integer.parseInt(request.getParameter("bindent"));
		//////////////////////////////// 999-1=998\
		dto.setBstep(bstep);
		dao.update_re1(dto);
		
		dto.setBname(request.getParameter("bname"));
		dto.setBpass(request.getParameter("bpass"));
		dto.setBtitle(request.getParameter("btitle"));
		dto.setBcontent(request.getParameter("bcontent"));
		dto.setBip(InetAddress.getLocalHost().getHostName());
		dto.setImg(request.getParameter("img"));
		dto.setBgroup(bgroup);
		dto.setBstep(bstep-1);
		dto.setBindent(bindent+1);
		int result=dao.create(dto);
		
		if(result > 0) {
			out.println("<script>alert('답변달기성공'); location.href='"+request.getContextPath()+"/list.do';</script>");
		}else {
			out.println("<script>alert('관리자 문의'); history.go(-1);</script>");
		}
		
		
		
		System.out.println("답글달기"+dto);

	}

}

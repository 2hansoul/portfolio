package com.company.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.Bdao_list;
import com.company.dto.BDto;

public class BDeleteAction implements BAciton {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		Bdao_list dao =new Bdao_list();
		BDto dto =new BDto();
		
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setBpass(request.getParameter("bpass"));
		
		int result=dao.delete(dto);
	System.out.println("삭제");
	
	if(result>0) {
		out.println("<script>alert('삭제성공'); location.href='"+request.getContextPath()+"/list.do';</script>");
   }else {
	   out.println("<script>alert('비빌번호 확긴'); history.go(-1);</script>");
   }
		

	}

}

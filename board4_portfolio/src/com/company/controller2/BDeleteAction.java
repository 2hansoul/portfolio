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
	System.out.println("����");
	
	if(result>0) {
		out.println("<script>alert('��������'); location.href='"+request.getContextPath()+"/list.do';</script>");
   }else {
	   out.println("<script>alert('�����ȣ Ȯ��'); history.go(-1);</script>");
   }
		

	}

}

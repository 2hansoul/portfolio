package com.company.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.Bdao_list;
import com.company.dto.BDto;

public class BreplyView implements BAciton {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bdao_list dao=new Bdao_list();
		BDto dto=new BDto();
		
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto=dao.read(dto);
		dto.setBtitle("ㄴre:"+dto.getBtitle());
		dto.setBcontent("\n>"+dto.getBcontent().replaceAll("\n", "\n>"));
		request.setAttribute("dto", dto);
		System.out.println("답글달기 view ");

	}

}

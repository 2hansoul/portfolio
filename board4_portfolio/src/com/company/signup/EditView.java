package com.company.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.Mdao;
import com.company.dto.MDto;

public class EditView implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session=request.getSession();
		Mdao dao=new Mdao();
		MDto dto=new MDto();
		
		dto.setMid((String)session.getAttribute("mid"));
		
		System.out.println(dao.page(dto));
		
		request.setAttribute("dto", dao.page(dto));

	}

}

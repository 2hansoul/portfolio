package com.company.controller2;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.Bdao_list;

import com.company.dto.BDto;

public class BEditView implements BAciton {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");  
	      
	     
	      
	      Bdao_list dao = new Bdao_list();
	      BDto dto = new BDto();
	      
	    
	      dto.setBno(Integer.parseInt(request.getParameter("bno"))); 
	      request.setAttribute("dto", dao.read(dto));
		 

	}
	

}

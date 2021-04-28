package com.company.signup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.Mdao;
import com.company.dbmanager.DBManager;
import com.company.dto.MDto;

public class signup_list implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Mdao dao=new Mdao();
		MDto dto=new MDto();
		
		dto.setMid(request.getParameter("mid"));//mid값을 파라미터로 넘겨주기
		
		System.out.println("데이터 확인하기"+request.getParameter("mid"));
		MDto result= dao.list(dto);
		System.out.println("데이터 뿌려주기"+result);
		
		request.setAttribute("dto", result);

	}

	
	
}

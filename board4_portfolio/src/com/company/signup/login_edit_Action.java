package com.company.signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.Mdao;
import com.company.dto.MDto;

public class login_edit_Action implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		Mdao dao=new Mdao();
		MDto dto=new MDto();
		
		dto.setMname(request.getParameter("mname"));
        dto.setMemail(request.getParameter("memail"));
        dto.setMid(request.getParameter("mid"));
        
        int result=dao.signupedit(dto);
        System.out.println("ȸ������ �����"+result);
        if(result>0) {
			out.print("<script> alert ('���� ����!'); location.href='"+request.getContextPath()+"/login_page.signup'; </script>");
		}else{
            out.print("<script> alert ('���� ����! �����ڿ��� �������ּ���! '); history.go(-1); </script>");
         }
        
        
        //request.setAttribute("dto", result);
	}

}

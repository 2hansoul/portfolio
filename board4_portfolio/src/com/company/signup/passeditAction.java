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
		
		
		
		
		
		//dto.setMpass(request.getParameter("newpass"));//�޾ƿ� ����� ���ο� ����� �Է����ش�
		//dto.setMpass((String)session.getAttribute("mpass"));; 
		String newpass=request.getParameter("newpass");//���ο� ����� �޾ƿ´�
		dto.setMpass(request.getParameter("mpass"));
		dto.setMid((String)session.getAttribute("mid"));
		System.out.println("���ο� �����ȣ"+newpass);
		
		int result=dao.passedit(dto,newpass);
		System.out.println("�������"+result);
		System.out.println("�������"+dto);
		
		if(result>0) {
			out.print("<script> alert ('���� ����!'); location.href='"+request.getContextPath()+"/login_page.signup'; </script>");
		}else{
            out.print("<script> alert ('���� ����! ���Ȯ���ϼ���! '); history.go(-1); </script>");
         }
		
		
		
		
	}

}

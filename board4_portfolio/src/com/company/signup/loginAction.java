package com.company.signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.Mdao;
import com.company.dto.MDto;

public class loginAction implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession();
		MDto dto=new MDto();
		Mdao dao=new Mdao();
		
		
		dto.setMid(request.getParameter("mid"));
		dto.setMpass(request.getParameter("mpass"));
		
//			System.out.println("������ Ȯ���ϱ�"+request.getParameter("mid"));
//			System.out.println("������ Ȯ���ϱ�"+request.getParameter("mpass"));
		boolean result=dao.login(dto);
		
		 if(result==false){
			 out.println("<script>alert('�α��ν��� Ȯ���ϼ���'); location.href='"+request.getContextPath()+"/login.signup';</script>");
		    }else{
		        session.setMaxInactiveInterval(60*10);
		        session.setAttribute("mid", dto.getMid());
		        out.println("<script>alert('�α��μ���'); location.href='"+request.getContextPath()+"/login_page.signup';</script>");
		    }
		  
		  
		System.out.println("�α��� üũ �� �ҷ�������?:"+result);
	
		//request.setAttribute("dto", result);  //1. ����ġ�� ������ �ȴ� 
		// dispatcher.forward�� request�� ������ �ȴ�
		// location , sendRedirect�� request�� ������ �ȵǿ�!!
		
	

	}

}

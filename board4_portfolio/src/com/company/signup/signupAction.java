package com.company.signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.Mdao;
import com.company.dto.MDto;

public class signupAction implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		
		MDto dto=new MDto();
		Mdao dao=new Mdao();
		
		try {
			dto.setMid(request.getParameter("mid"));
			dto.setMname(request.getParameter("mname"));
			dto.setMpass(request.getParameter("mpass"));
			dto.setMemail(request.getParameter("memail"));
			dto.setMip(request.getParameter("mip"));
			dto.setZonecode(request.getParameter("zonecode"));
			dto.setAddress(request.getParameter("address"));
			dto.setAddress2(request.getParameter("address2"));
			
			
			int result=dao.signup(dto);
			System.out.println("result"+result);
			
			if (result > 0) {
				//out.print("<script>alert('���Կ� �����߽��ϴ�.'); history.go(-1);</script>");
				out.println("<script>alert('ȸ������ ����');location.href='"+request.getContextPath()+"/signup_list.signup?mid="+request.getParameter("mid")+"';</script>");
			} else {
				out.println("alert('ȸ�����Խ��� �����߽��ϴ�\n�����ڿ��� �����ϼ���!'); histroy.go(-1);");
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

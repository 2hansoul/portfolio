package com.company.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.ImgDao;
import com.company.dto.ImgDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class create implements ViewAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out =response.getWriter();
	    //1.��μ���
	    String path="/upload/";
	    
	    path=request.getServletContext().getRealPath(path);//������ ���������
	    ImgDto dto=new ImgDto();
	    ImgDao dao=new ImgDao();
	    
	    //2.���ε� ����
	    try {
	    	MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy()); 
	    	dto.setName(multi.getParameter("name"));
	    	dto.setInfo(multi.getParameter("info"));
	    	dto.setPrice(Integer.parseInt(multi.getParameter("price")));
	    	dto.setImg(multi.getFilesystemName("img"));  //����������getFilesystemName
	    	dto.setCpu(multi.getParameter("cpu"));
	    	dto.setGpu(multi.getParameter("gpu"));
	    	
	    	int result=dao.create(dto);
	    	request.setAttribute("create", result);
	    	System.out.println("create �����"+result);
	    	
	    	if(result>0) {
	    		out.println("<script>alert('���ε强��'); location.href='"+request.getContextPath()+"/uploadList.vi';</script>");
	    	}else {
	 			out.println("<script>alert('������ ���� ���ּ���');history.go(-1);</script>");
	 		}
	    }catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

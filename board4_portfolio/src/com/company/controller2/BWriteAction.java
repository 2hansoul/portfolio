package com.company.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.Bdao_list;
import com.company.dto.BDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BWriteAction implements BAciton {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		
		Bdao_list dao2=new Bdao_list();
		BDto dto2=new BDto();
		//1.경로설정
	    String path="/upload";
	    		
	    path=request.getServletContext().getRealPath(path);//서버에 담긴정보들
	    //댓글달기
	    int bgroup = -1, bstep = -1, bindent = -1, max=-1;
	    max = dao2.create_max();
	    bgroup = (int)(Math.ceil(max/(float)1000)) + 1;
	    bstep = bgroup * 1000;
	    bindent = 0;
	    
	    
	    
	    
	    
	    ////
		
		
		
			MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy()); 
			dto2.setBname(multi.getParameter("bname")); 
			dto2.setBpass(multi.getParameter("bpass")); 
			dto2.setBtitle(multi.getParameter("btitle"));
			dto2.setBcontent(multi.getParameter("bcontent"));
			
			dto2.setImg(multi.getFilesystemName("img"));
			dto2.setBgroup(bgroup);
			dto2.setBstep(bstep);
		    dto2.setBindent(bindent);
			int result=dao2.create(dto2);
			request.setAttribute("create", result);
			System.out.println("글 쓰기"+result);
			
			
			if(result>0) {
				out.println("<script>alert('글쓰기성공'); location.href='"+request.getContextPath()+"/list.do';</script>");
			}else {
				out.println("<script>alert('관리자 문의 해주세요');history.go(-1);</script>");
			}
		
		
		
		

	}

}

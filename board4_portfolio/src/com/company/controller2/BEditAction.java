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

public class BEditAction implements BAciton {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");  
	       PrintWriter out =response.getWriter();  
	      Bdao_list dao = new Bdao_list(); 
	      BDto dto = new BDto();
	    //1.경로설정
		    String path="/upload";
		    path=request.getServletContext().getRealPath(path);//서버에 담긴정보들
		    ////
		try {    
			MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy()); 
	    
		  String file=multi.getFilesystemName("img");
		  if(file ==null) {
			  file=multi.getParameter("prev_img");
		  }System.out.println("파일업로드 안됌");
		  //이미지 업로드를 안하면 그냥 원래 이미지로 나옴
		  
		  dto.setBtitle (multi.getParameter("btitle"));
	      dto.setBcontent(multi.getParameter("bcontent"));
	      dto.setBno(Integer.parseInt(multi.getParameter("bno")));
	      dto.setImg(file);
	      dto.setBpass(multi.getParameter("bpass"));
	      
	      int result=dao.update(dto);
	      System.out.println("수정기능");
	       if(result>0) {
	    	   out.println("<script>alert('글수정 완료');location.href='"+request.getContextPath()+"/detail.do?bno="+request.getParameter("bno")+"';</script>");
	       }else {
	    	   out.println("<script>alert('비번체크'); history.go(-1);</script>");
	       }
	      
	      
	      
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

package com.company.controller2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.company.dao.Bdao_list;
import com.company.dto.BDto;

public class BListAction implements BAciton {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Bdao_list dao=new Bdao_list();
		
		request.setAttribute("list", dao.list());
		////////////////////////
		
	     //����������
	     int pageTotal=dao.listcnt(); System.out.println("1.��ü�Խ��� ����:"+pageTotal);
	      int onepagelimit=10;  System.out.println("2.���������� �����ִ� ����"+onepagelimit);
	      int pageAll=(int)Math.ceil(pageTotal/(float)onepagelimit); System.out.println("3.��ü������"+pageAll);
	      
	      int pstartno=0;
	      if(request.getParameter("pstartno")!=null) {
	    	  pstartno=Integer.parseInt(request.getParameter("pstartno"));
	      }
	      System.out.println("4-1. db ���� ������ ��ȣ" +pstartno);
	      
	       ArrayList<BDto> list=dao.list10(pstartno);//��ü ������  
	       System.out.println("4-2 db���� ������ ����Ʈ"+list);
	      
	      int bottomlist=10;   System.out.println("5. �ϴ������� �׺� :"+bottomlist);
//	    
	       int current=(int)Math.ceil((pstartno+1)/(float)onepagelimit);  System.out.println("6.����������:"+current); 
	  
       int start= (int)Math.floor((current-1)/(float)bottomlist)*bottomlist+1;
       System.out.println("7.�ϴܳ׺� ����������:"+start);
       int end =start+bottomlist-1;
       if(pageAll<end) {
       	end=pageAll;
       }
       System.out.println("8.�ϴ�������"+end);
       
       request.setAttribute("pageTotal", pageTotal);
       request.setAttribute("onepagelimit", onepagelimit);
       request.setAttribute("pageAll", pageAll);
       request.setAttribute("pstartno", pstartno);
       request.setAttribute("bottomlist", bottomlist);
       request.setAttribute("current", current);
       request.setAttribute("start", start);
       request.setAttribute("end", end);
       request.setAttribute("list", list);
	      
       //  request.setAttribute("list", dao.listcnt());
	    // request.setAttribute("list", dao.list10(0));
       
	 
		
	}

}

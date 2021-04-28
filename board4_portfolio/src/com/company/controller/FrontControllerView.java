package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.company.view.ViewAction;
import com.company.view.create;
import com.company.view.list;
import com.company.view.list1;

/**
 * Servlet implementation class FrontControllerView
 */
@WebServlet("*.vi")
public class FrontControllerView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionView(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionView(request, response);
	}
	
	protected void actionView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	     response.setContentType("text/html; charset=UTF-8");
	     PrintWriter out=response.getWriter();
	     String path=request.getRequestURI().substring(request.getContextPath().length());
	     String view="";
	     ViewAction comm=null;
	     if(path.equals("/create.vi")) {
	    	 comm=new create();
	    	 comm.execute(request, response);
	    	 view="/viewpage/uploadfrom.jsp";
	    	 return;
	     }else if(path.equals("/uploadList.vi")) {
	    	 System.out.println("업로드 결과폼");
	    	 comm=new list();
	    	 comm.execute(request, response);
	    	 view="/viewpage/uploadresult.jsp";
	    	 
	     }else if(path.equals("/uploadList1.vi")) {
	    	 System.out.println("업로드 결과폼");
	    	 comm=new list1();
	    	 comm.execute(request, response);
	    	 view="/main/mainpage.jsp"; 
	     }
	     //정보를 view경로로 보내줘야한다
	     request.getRequestDispatcher(view).forward(request, response);
	}
	
}

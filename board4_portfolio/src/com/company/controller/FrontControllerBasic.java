package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontContrlloerBasic
 */
@WebServlet("*.test")
public class FrontControllerBasic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerBasic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request,response);
	}
	
	
    protected void actionTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		////////////////////////////
		out.println(request.getRequestURI()+"<br/>");  //board4/write.test 
		out.println(request.getRequestURL()+"<br/>");
		out.println(request.getServletPath()+"<br/>");
		out.println(request.getContextPath()+"<br/>");  // board4
		out.println(request.getServletContext()+"<br/>");
		/////////////////////////
		//q1)
		String path=request.getRequestURI().substring(request.getContextPath().length());
		if( path.equals("/write.test")) {
		      out.println("글쓰기 페이지로 이동");	
		}else if(path.equals("/list.test")) {
			out.println("리스트 페이지로 이동");
		}
		
		
	}

}

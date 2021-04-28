package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.controller2.BAciton;
import com.company.controller2.BDeleteAction;
import com.company.controller2.BDetailAction;
import com.company.controller2.BEditAction;
import com.company.controller2.BEditView;
import com.company.controller2.BListAction;
import com.company.controller2.BWriteAction;
import com.company.controller2.Breply;
import com.company.controller2.BreplyView;
import com.company.dao.Bdao_list;
import com.company.dto.BDto;

/**
 * Servlet implementation class FrontContrlloerTest
 */
@WebServlet("*.do")
public class FrontControllerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
       actionDo(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		String path=request.getRequestURI().substring(request.getContextPath().length());
		BAciton comm=null;
		String view="/board/list.jsp";
		
		if( path.equals("/list.do")) {
			System.out.println("get-list");
			//1.전체 데이터 가져오기
			comm=new BListAction(); comm.execute(request, response);
			//2./board/list.jsp로 이동
			view="/board/list.jsp";
			
		}else if(path.equals("/write_view.do")) {
			System.out.println("get-write폼");
			//2./board/write.jsp로 이동
			view="/board/write.jsp";
			
		}else if(path.equals("/write.do")) {
			System.out.println("post-write기능");
			//1./board/list.jsp로 이동
			comm=new BWriteAction(); 
			comm.execute(request,response);
			//2./board/list.do로 이동
			view="/list.do";
			return;
			
		}else if(path.equals("/detail.do")) {
			System.out.println("get-상세페이지기능");
			//1.글 상세 가져오기,조회수올리기
			comm=new BDetailAction(); comm.execute(request,response);
			//2./board/detail.jsp로 이동
			view="/board/detail.jsp";
			
		}else if(path.equals("/edit_view.do")) {
			System.out.println("edit_view폼");
			//1.글 상세 가져오기
			comm=new BEditView(); comm.execute(request,response);
			//./board/edit.jsp로 이동
			view="/board/edit.jsp";
			
		}else if(path.equals("/edit.do")) {
			System.out.println("post-edit기능");
			//1.글 상세 가져오기
			comm=new BEditAction(); comm.execute(request,response);
			//2./board/edit.jsp로 이동
			view="/detail.do";
			return;
		}else if(path.equals("/reply_view.do")) {
			System.out.println("댓글폼");
			comm=new BreplyView();
			comm.execute(request, response);
			view="/board/reply.jsp";
			
		}else if(path.equals("/reply.do")) {
			System.out.println("댓글기능");
			comm=new Breply();
			comm.execute(request, response);
			view="/list.do";
			return;
		}else if(path.equals("/delete_view.do")) {
			System.out.println("삭제폼");
			//1.글 상세 가져오기
			//2./board/delete.jsp로 이동
			view="/board/delete.jsp";
			
		}else if(path.equals("/delete.do")) {
			System.out.println("삭제기능");
			//1.글 상세 가져오기
			comm=new BDeleteAction(); comm.execute(request,response);
			//2./board/list.jsp로 이동
			view="/list.do";
			return;
			
		}
		
		
		
		
		request.getRequestDispatcher(view).forward(request, response);
	}

}

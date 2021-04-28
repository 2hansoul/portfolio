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
			//1.��ü ������ ��������
			comm=new BListAction(); comm.execute(request, response);
			//2./board/list.jsp�� �̵�
			view="/board/list.jsp";
			
		}else if(path.equals("/write_view.do")) {
			System.out.println("get-write��");
			//2./board/write.jsp�� �̵�
			view="/board/write.jsp";
			
		}else if(path.equals("/write.do")) {
			System.out.println("post-write���");
			//1./board/list.jsp�� �̵�
			comm=new BWriteAction(); 
			comm.execute(request,response);
			//2./board/list.do�� �̵�
			view="/list.do";
			return;
			
		}else if(path.equals("/detail.do")) {
			System.out.println("get-�����������");
			//1.�� �� ��������,��ȸ���ø���
			comm=new BDetailAction(); comm.execute(request,response);
			//2./board/detail.jsp�� �̵�
			view="/board/detail.jsp";
			
		}else if(path.equals("/edit_view.do")) {
			System.out.println("edit_view��");
			//1.�� �� ��������
			comm=new BEditView(); comm.execute(request,response);
			//./board/edit.jsp�� �̵�
			view="/board/edit.jsp";
			
		}else if(path.equals("/edit.do")) {
			System.out.println("post-edit���");
			//1.�� �� ��������
			comm=new BEditAction(); comm.execute(request,response);
			//2./board/edit.jsp�� �̵�
			view="/detail.do";
			return;
		}else if(path.equals("/reply_view.do")) {
			System.out.println("�����");
			comm=new BreplyView();
			comm.execute(request, response);
			view="/board/reply.jsp";
			
		}else if(path.equals("/reply.do")) {
			System.out.println("��۱��");
			comm=new Breply();
			comm.execute(request, response);
			view="/list.do";
			return;
		}else if(path.equals("/delete_view.do")) {
			System.out.println("������");
			//1.�� �� ��������
			//2./board/delete.jsp�� �̵�
			view="/board/delete.jsp";
			
		}else if(path.equals("/delete.do")) {
			System.out.println("�������");
			//1.�� �� ��������
			comm=new BDeleteAction(); comm.execute(request,response);
			//2./board/list.jsp�� �̵�
			view="/list.do";
			return;
			
		}
		
		
		
		
		request.getRequestDispatcher(view).forward(request, response);
	}

}

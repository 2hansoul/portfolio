package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.signup.EditView;
import com.company.signup.MAction;
import com.company.signup.MsignupAgree;
import com.company.signup.delete;
import com.company.signup.idcheck;
import com.company.signup.loginAction;
import com.company.signup.loginPage;
import com.company.signup.login_edit_Action;
import com.company.signup.passeditAction;
import com.company.signup.signupAction;
import com.company.signup.signup_list;

/**
 * Servlet implementation class FrontControlloerSignup
 */
@WebServlet("*.signup")
public class FrontControllerSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontControllerSignup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//���� ����
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// �̵��� ��ġ ����
		String path = request.getRequestURI().substring(request.getContextPath().length());
		MAction comm = null;
		String view = "/signup/signu_agree.jsp";

		if (path.equals("/signu_agree.signup")) {
			comm = new MsignupAgree();
			comm.execute(request, response);
			view = "/signup/signu_agree.jsp";
			System.out.println("0.ȸ������ ���� ������");

		} else if (path.equals("/signup_list.signup")) {
			comm = new signup_list();
			comm.execute(request, response);
			view = "/signup/signup_list.jsp";
			System.out.println("3.list�� ȸ�������� ���� �����ֱ�");

		} else if (path.equals("/signup_form_view.signup")) {
			view = "/signup/signup_form.jsp";
			System.out.println("1.get-ȸ������ view");

		} else if (path.equals("/signup_action.signup")) {
			comm = new signupAction();
			comm.execute(request, response);
			view = "/signup_list.signup";
			System.out.println("2.post-ȸ������ action");
			return; 
			
		} else if (path.equals("/login.signup")) {
			view = "/signup/login_form.jsp";
			System.out.println("4.get-�α�����");
			
			
		} else if (path.equals("/loginaction.signup")) {
			comm = new loginAction();
			comm.execute(request, response);
			view = "/login_page.signup";
			System.out.println("5.post-�α��ξ׼� �� �������� �̵�");
			return;  //������ ������ page���� �ȳ����� ���� ���´� ����?
			
		}else if(path.equals("/login_page.signup")) {
			comm=new loginPage();
			comm.execute(request, response);
			view="/signup/page.jsp";
			System.out.println("6/9.�α��� �� �α������� �����ִ� page");
			
		} else if (path.equals("/login_edit.signup")) {
			comm=new EditView();
			comm.execute(request, response);
			view = "/signup/login_edit.jsp";
			System.out.println("7.�α��� ���� view������");
			
			
		} else if (path.equals("/login_edit_action.signup")) {
			comm = new login_edit_Action();
			comm.execute(request, response);
			view = "/login_page.signup";
			System.out.println("8.�α����������� ó���� page�� �̵��ϰ� ���⼭ �˸�â ����");
           return;
            
		} else if (path.equals("/passedit.signup")) {
			view = "/signup/PassEdit.jsp";
			System.out.println("������� view");

		} else if (path.equals("/passeditAction.signup")) {
			comm = new passeditAction();
			comm.execute(request, response);
			view = "/login_page.signup";
			System.out.println("������� ó���� page�� �̵��ϰ� ���⼭ �˸�â ����");
			return;
			
		} else if(path.equals("/delete.signup")) {
			comm=new delete();
			comm.execute(request, response);
			view="/login.signup";
			System.out.println("Ż��׼� Ż���� �α��������� ���ư���");
			return;
			
		} else if(path.equals("/deleteview.signup")) {
			view="/signup/userdelete.jsp";
			
		} else if(path.equals("/idcheck.signup")) {
			comm=new idcheck();
			comm.execute(request, response);
			//view="/signup/signup_form.jsp";
			return;
		}

		request.getRequestDispatcher(view).forward(request, response);

	}

}

package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dbmanager.DBManager;

/**
 * Servlet implementation class Ajax_DB002
 */
@WebServlet("/Ajax_view")
public class Ajax_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajax_view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		String result="";
		try {
		DBManager db=new DBManager();
		conn=db.connection();
			if(conn !=null) {
				System.out.println("db연동성공");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		/////////////
		try {
			pstmt=conn.prepareStatement("select * from computerinfo");
			rset=pstmt.executeQuery();
			while(rset.next()) {
				result +="<tr><td>"+rset.getInt("no")+"</td><td>"
			              +rset.getString("name")+"</td><td>"
			              +rset.getString("info")+"</td><td>"
						  +rset.getInt("price")+"</td><td>"
						  +rset.getString("cpu")+"</td><td>"
						  +rset.getString("gpu")+"</td><td>"
						  +rset.getString("memory")+"</td></tr>";
			}
			out.println(result);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			 if(rset!=null){ try{rset.close(); }catch(Exception e){ e.printStackTrace(); }}
			 if(pstmt!=null){ try{pstmt.close(); }catch(Exception e){ e.printStackTrace(); }}
             if(conn!=null){ try{conn.close(); }catch(Exception e){ e.printStackTrace(); }}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dbmanager.DBManager;
import com.company.dto.ImgDto;



/**
 * Servlet implementation class Ajax_DB003
 */
@WebServlet("/Ajax_view1")
public class Ajax_view1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajax_view1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		ArrayList<ImgDto> list=new ArrayList<ImgDto>();
		try{
			DBManager db=new DBManager();
			conn=db.connection();
		
		}catch(Exception e) {e.printStackTrace();
		}
		
		try {
			pstmt = conn.prepareStatement("select * from imgboard where name =?");
			pstmt.setString(1, request.getParameter("name"));
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new ImgDto(rset.getString("name"), rset.getString("info"),
						 rset.getInt("price"),rset.getString("img"),
						 rset.getString("cpu"),rset.getString("gpu")));
			}
			out.println(list);
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {e.printStackTrace();}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {e.printStackTrace();}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {e.printStackTrace();}}
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

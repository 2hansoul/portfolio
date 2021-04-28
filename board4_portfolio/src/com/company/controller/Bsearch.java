package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dbmanager.DBManager;
import com.company.dto.BDto;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;




/**
 * Servlet implementation class Bsearch
 */
@WebServlet("/Bsearch")
public class Bsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bsearch() {
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
		//리스트
		//ArrayList<BDto> search=new ArrayList<>();
		JsonArray search=new JsonArray();
		
		String sql = "select * from mvcboard3 where btitle like ?";
		PreparedStatement pstmt = null; Connection conn = null; ResultSet rset =null;
		
		String word=request.getParameter("btitle");
		//String word="test";
		//디비연결
		try {
			DBManager db= new DBManager();
			conn = db.connection();
		}catch(Exception e) {e.printStackTrace();}
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+word+"%");
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
//				search.add(new BDto(rset.getInt("bno"), rset.getString("bname"), rset.getString("bpass"),
//						rset.getString("btitle"), rset.getString("bcontent"),
//						rset.getString("bdate"),rset.getString("bhit"), rset.getString("bip"),rset.getString("img")));
//			
			JsonObject job=new JsonObject();
			job.addProperty("bno", rset.getInt("bno"));
			job.addProperty("bname", rset.getString("bname"));
			job.addProperty("bpass", rset.getString("bpass"));
			job.addProperty("btitle", rset.getString("btitle"));
			job.addProperty("bcontent", rset.getString("bcontent"));
			job.addProperty("bdate", rset.getString("bdate"));
			job.addProperty("bhit", rset.getString("bhit"));
			job.addProperty("bip", rset.getString("bip"));
			job.addProperty("img", rset.getString("img"));
			//json array 에  json오브젝트 집어넣어주고 출력
			search.add(job);
			}
			out.println(search);
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
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

package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.dbmanager.DBManager;
import com.company.dto.ImgDto;

public class ImgDao {
	public int create(ImgDto dto) {
		int result=-1;
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		//db
		try {
			DBManager db=new DBManager();
			conn=db.connection();
			if(conn !=null) {
				System.out.println("db연동성공");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		////////
		
		
		try {
			pstmt=conn.prepareStatement("insert into imgboard (name,info,price,img,cpu,gpu) values( ?,?,?,?,?,?)");
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getInfo());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getImg());
			pstmt.setString(5, dto.getCpu());
			pstmt.setString(6, dto.getGpu());
			
			result=pstmt.executeUpdate();
			
			System.out.println("insert"+result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			 if(rset!=null){ try{rset.close(); }catch(SQLException e){ e.printStackTrace(); }}
			 if(pstmt!=null){ try{pstmt.close(); }catch(SQLException e){ e.printStackTrace(); }}
           if(conn!=null){ try{conn.close(); }catch(SQLException e){ e.printStackTrace(); }}
		}
		return result;
		
	}
	
	public ArrayList<ImgDto> list(){
		ArrayList<ImgDto> list=new ArrayList<ImgDto>();
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		//db
		try {
			DBManager db=new DBManager();
			conn=db.connection();
			if(conn !=null) {
				System.out.println("db연동성공");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		////////
		
		try {
			pstmt=conn.prepareStatement("select*from imgboard");
			rset=pstmt.executeQuery();
			while(rset.next()) {
				list.add(new ImgDto(rset.getString("name"), rset.getString("info"),
						  rset.getInt("price"),rset.getString("img"),
						  rset.getString("cpu"),rset.getString("gpu")));
			}
			System.out.println("imgboard list"+list);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			 if(rset!=null){ try{rset.close(); }catch(SQLException e){ e.printStackTrace(); }}
			 if(pstmt!=null){ try{pstmt.close(); }catch(SQLException e){ e.printStackTrace(); }}
           if(conn!=null){ try{conn.close(); }catch(SQLException e){ e.printStackTrace(); }}
		}
		
		return list;
	}
}

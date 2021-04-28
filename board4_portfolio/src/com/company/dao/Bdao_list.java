package com.company.dao;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.company.dbmanager.DBManager;

import com.company.dto.BDto;

public class Bdao_list {

	public ArrayList<BDto>list(){
	ArrayList<BDto>list =new ArrayList<BDto>();
	Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
    //디비연결
	
	try {
		DBManager db=new DBManager();
		conn=db.connection();
	}catch(Exception e) {
		e.printStackTrace();
	}
	///
	try {
		pstmt=conn.prepareStatement("select*from mvcboard3 order by bno desc");
		rset=pstmt.executeQuery();
		while(rset.next()) {
			list.add(new BDto(rset.getInt("bno"),rset.getString("bname"),
					rset.getString("bpass"),rset.getString("btitle"),rset.getString("bcontent")
					,rset.getString("bdate"),rset.getInt("bhit"),rset.getString("bip")
					,rset.getString("img"),rset.getString("bcategory"),rset.getInt("bgroup"),rset.getInt("bstep"),rset.getInt("bindent")));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		 if(rset!=null){ try{rset.close(); }catch(Exception e){ e.printStackTrace(); }}
		 if(pstmt!=null){ try{pstmt.close(); }catch(Exception e){ e.printStackTrace(); }}
       if(conn!=null){ try{conn.close(); }catch(Exception e){ e.printStackTrace(); }}
	}
	
	return list;
	
	
	}
	////
	public int create (BDto dto) {
		int result=-1;
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
	    //디비연결
		
		try {
			DBManager db=new DBManager();
			conn=db.connection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			pstmt=conn.prepareStatement("insert into mvcboard3 ( bname,bpass,btitle,bcontent,bip,img,bgroup,bstep,bindent) values ( ?,?,?,?,?,?,?,?,?)");
		    pstmt.setString(1, dto.getBname());
		    pstmt.setString(2, dto.getBpass());
		    pstmt.setString(3, dto.getBtitle());
		    pstmt.setString(4, dto.getBcontent());
		    pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
		    pstmt.setString(6, dto.getImg());
		    pstmt.setInt(7, dto.getBgroup());
			pstmt.setInt(8, dto.getBstep());
			pstmt.setInt(9, dto.getBindent());
		    result=pstmt.executeUpdate();
		    
		    System.out.println("글쓰기 dao 카테고리 포함"+result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			   //if(rset!=null){try{rset.close();}catch(Exception e ){e.printStackTrace(); } }
			   if(pstmt!=null){try{pstmt.close();}catch(Exception e ){e.printStackTrace(); } }
			   if(conn!=null){try{conn.close();}catch(Exception e ){e.printStackTrace(); } } 
			}
		
		
		return result;
	}
	//////////////
	public int create_max() {
  	  int result=-1;
  	  Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
  	//디비연결
		
		try {
			DBManager db=new DBManager();
			conn=db.connection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//////////
		try {
			pstmt=conn.prepareStatement("select max(bstep) max from mvcboard3");
			rset=pstmt.executeQuery();
			if(rset.next()) {
				result=rset.getInt(1);
			}
		       System.out.println("create_max:"+result);
			}catch(Exception e) {
  			e.printStackTrace();
  		}finally {
  			 if(rset!=null){ try{rset.close(); }catch(Exception e){ e.printStackTrace(); }}
  			 if(pstmt!=null){ try{pstmt.close(); }catch(Exception e){ e.printStackTrace(); }}
  	       if(conn!=null){ try{conn.close(); }catch(Exception e){ e.printStackTrace(); }}
  		}
		return result;
    }
	
	//////
	public int update_hit(BDto dto) {
		int result=-1;
		Connection conn=null; PreparedStatement pstmt=null; //ResultSet rset=null;
	    //디비연결
		
		try {
			DBManager db=new DBManager();
			conn=db.connection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt=conn.prepareStatement("update mvcboard3 set bhit = bhit+1 where bno=?");
			pstmt.setInt(1, dto.getBno());
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			   //if(rset!=null){try{rset.close();}catch(Exception e ){e.printStackTrace(); } }
			   if(pstmt!=null){try{pstmt.close();}catch(Exception e ){e.printStackTrace(); } }
			   if(conn!=null){try{conn.close();}catch(Exception e ){e.printStackTrace(); } } 
			}
		return result;
		
	}
	///////
	public BDto read(BDto dto) {
		BDto result=new BDto();
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
	    //디비연결
		
		try {
			DBManager db=new DBManager();
			conn=db.connection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		////
		try {
			pstmt=conn.prepareStatement(" select*from mvcboard3 where bno=?");
			pstmt.setInt(1, dto.getBno());
			rset=pstmt.executeQuery();
			while(rset.next()) {
				result=(new BDto(rset.getInt("bno"),rset.getString("bname"),
						rset.getString("bpass"),rset.getString("btitle"),rset.getString("bcontent")
						,rset.getString("bdate"),rset.getInt("bhit"),rset.getString("bip")
						,rset.getString("img"),rset.getString("bcategory"),rset.getInt("bgroup"),rset.getInt("bstep"),rset.getInt("bindent")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			 //if(rset!=null){ try{rset.close(); }catch(Exception e){ e.printStackTrace(); }}
			 if(pstmt!=null){ try{pstmt.close(); }catch(Exception e){ e.printStackTrace(); }}
	       if(conn!=null){ try{conn.close(); }catch(Exception e){ e.printStackTrace(); }}
		}
		return result;
		
		
	}
	/////////
	public int update(BDto dto) {
		int result=-1;
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		
		
		//디비연결
		
		try {
			DBManager db=new DBManager();
			conn=db.connection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//////
		try {
			pstmt=conn.prepareStatement("update mvcboard3 set btitle=? , bcontent=?,img=? where bno=? and bpass=?");
		    pstmt.setString(1, dto.getBtitle());
		    pstmt.setString(2, dto.getBcontent());
		    pstmt.setString(3, dto.getImg());
		    pstmt.setInt(4, dto.getBno());
		    pstmt.setString(5, dto.getBpass());
		    result=pstmt.executeUpdate();
		    
		    
		    	
		    
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			   //if(rset!=null){try{rset.close();}catch(Exception e ){e.printStackTrace(); } }
			   if(pstmt!=null){try{pstmt.close();}catch(Exception e ){e.printStackTrace(); } }
			   if(conn!=null){try{conn.close();}catch(Exception e ){e.printStackTrace(); } } 
			}
		return result;
	}
	//////////
	public int delete(BDto dto) {
		int result=-1;
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
	    //디비연결
		
		try {
			DBManager db=new DBManager();
			conn=db.connection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		///////
		try {
			pstmt=conn.prepareStatement("delete from mvcboard3 where bno=? and bpass=?");
		    pstmt.setInt(1, dto.getBno());
		    pstmt.setString(2, dto.getBpass());
		 
		    
		    result=pstmt.executeUpdate();
		    
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			   //if(rset!=null){try{rset.close();}catch(Exception e ){e.printStackTrace(); } }
			   if(pstmt!=null){try{pstmt.close();}catch(Exception e ){e.printStackTrace(); } }
			   if(conn!=null){try{conn.close();}catch(Exception e ){e.printStackTrace(); } } 
			}
		return result;
		
	}
	//페이지 10개씩 보여주기
	public ArrayList<BDto> list10(int pstartno){
		ArrayList<BDto> list=new ArrayList<BDto>();
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		String sql="select *from mvcboard3 order by bstep  desc ,bindent asc limit ?,10";
		try {
			DBManager db=new DBManager();
			conn=db.connection();
			if(conn !=null) {
				System.out.println("연동성공");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		/////////////
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pstartno);
			System.out.println("pstartno"+pstartno);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				list.add(new BDto(rset.getInt("bno"),rset.getString("bname"),
						rset.getString("bpass"),rset.getString("btitle"),rset.getString("bcontent")
						,rset.getString("bdate"),rset.getInt("bhit"),rset.getString("bip")
						,rset.getString("img"),rset.getString("bcategory"),rset.getInt("bgroup"),rset.getInt("bstep"),rset.getInt("bindent")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			 if(rset!=null){ try{rset.close(); }catch(Exception e){ e.printStackTrace(); }}
			 if(pstmt!=null){ try{pstmt.close(); }catch(Exception e){ e.printStackTrace(); }}
            if(conn!=null){ try{conn.close(); }catch(Exception e){ e.printStackTrace(); }}
		}
		return list;
	}
	///////////페이지 총 개수 구하기
	public int listcnt(){//넘겨받는 숫자 0,10,20
	     ArrayList<BDto> list=new ArrayList<BDto>();
	     Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		int result=-1;
			try {
				DBManager db=new DBManager();
				conn=db.connection();
				if(conn !=null) {
					//System.out.println("연동성공");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				pstmt=conn.prepareStatement("select count(*) cnt from mvcboard3");
				
				rset=pstmt.executeQuery();
				if(rset.next()) {
					result=rset.getInt("cnt");
				}
				System.out.println(list);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				 if(rset!=null){ try{rset.close(); }catch(Exception e){ e.printStackTrace(); }}
				 if(pstmt!=null){ try{pstmt.close(); }catch(Exception e){ e.printStackTrace(); }}
	            if(conn!=null){ try{conn.close(); }catch(Exception e){ e.printStackTrace(); }}
			}
			return result;
			
	}

	//////게시판에서 검색
	public ArrayList<BDto> search (String word) {
		ArrayList<BDto> boardsearch = new ArrayList<>();
		
		String sql = "select * from mvcboard3 where btitle like ?";
		PreparedStatement pstmt = null; Connection conn = null; ResultSet rset =null;
		try {
			DBManager db= new DBManager();
			conn = db.connection();
		}catch(Exception e) {e.printStackTrace();}
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+word+"%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				boardsearch.add(new BDto(rset.getInt("bno"),rset.getString("bname"),
						rset.getString("bpass"),rset.getString("btitle"),rset.getString("bcontent")
						,rset.getString("bdate"),rset.getInt("bhit"),rset.getString("bip")
						,rset.getString("img"),rset.getString("bcategory"),rset.getInt("bgroup"),rset.getInt("bstep"),rset.getInt("bindent")));
			}
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}	
		return boardsearch;
	}
	
	 /////////////// 댓글달기
    public int update_re1(BDto dto) {
    	int result=-1;
  	  Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
  	  String sql="update mvcboard3 set bstep=bstep-1 where bstep> ? and bstep < ? ";
  	  //디비연결
   		try {
   			DBManager db=new DBManager();
   			conn=db.connection();
   		}catch(Exception e) {
   			e.printStackTrace();
   		}
   		/////
   		try {
   			int curr=dto.getBstep();
   			int prev=(int)(Math.ceil(dto.getBstep()/(float)10000)*1000-999);
   			pstmt=conn.prepareStatement(sql);
   			pstmt.setInt(1, prev);
   			pstmt.setInt(2, curr);
   			result=pstmt.executeUpdate();
   		}catch(Exception e) {
  			e.printStackTrace();
  		}finally {
  			 //if(rset!=null){ try{rset.close(); }catch(Exception e){ e.printStackTrace(); }}
  			 if(pstmt!=null){ try{pstmt.close(); }catch(Exception e){ e.printStackTrace(); }}
  	       if(conn!=null){ try{conn.close(); }catch(Exception e){ e.printStackTrace(); }}
  		}
			return result;
    }
    
    
	
}

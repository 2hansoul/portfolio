package com.company.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.company.dbmanager.DBManager;
import com.company.dto.BDto;
import com.company.dto.MDto;






public class Mdao {
	
	
       //회원가입 
	public int signup(MDto dto) {
		int result=-1;
		Connection conn=null; PreparedStatement pstmt=null;
		String sql = "insert into mvcmember3(mid,mname,mpass,memail,mip,zonecode,address,address2) values ( ?,?,?,?,?,?,?,?)";
		
		//디비
		try {
			DBManager db=new DBManager();
			conn=db.connection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		///
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getMname());
			pstmt.setString(3, dto.getMpass());
			pstmt.setString(4, dto.getMemail());
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			pstmt.setString(6, dto.getZonecode());
			pstmt.setString(7, dto.getAddress());
			pstmt.setString(8, dto.getAddress2());
			
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	         if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); } }
	         if (conn != null) { try { conn.close(); } catch (Exception e) { e.printStackTrace(); } }
	      }
		return result;
		
	}
	
	//회원가입하고 목록 보여줌 mid를 클릭시 그거에 맞는 정보 도출
	public MDto list(MDto dto) {
		MDto result=new MDto();
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		String sql="select*from mvcmember3 where mid=?";
				
		//디비
		try {
			DBManager db=new DBManager();
			conn=db.connection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		////
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				
				result=(new MDto(rset.getInt("mno"),rset.getString("mid")
						, rset.getString("mname"), rset.getString("mpass")
						, rset.getString("memail"), rset.getString("mdate")
						, rset.getString("mip")
						,rset.getString("zonecode")
						,rset.getString("address")
						,rset.getString("address2")
						));
				//값은 result 넣고 리턴으로 반환해준다
			}
			System.out.println("회원가입"+result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) {try {rset.close();}catch(Exception e) {e.printStackTrace();}}
			if(pstmt !=null) {try {pstmt.close();}catch(Exception e) {e.printStackTrace();}}
			if(conn !=null) {try {conn.close();}catch(Exception e) {e.printStackTrace();}}
		}
		return result;
	}
	//로그인  
	public boolean login(MDto dto) {
		//id,pass값이 두개 맞으면  true로 도출
		boolean result=false;
		PreparedStatement pstmt=null; ResultSet rset=null; Connection conn=null;
		//String sql="select mid,mpass from mvcmember3 where mid=? and mpass=?";
		
		//디비
				try {
					DBManager db=new DBManager();
					conn=db.connection();
				}catch(Exception e) {
					e.printStackTrace();
				}
        ////////////////
				try {
					pstmt=conn.prepareStatement("select  mid , mpass from mvcmember3 where mid=? and mpass=?");
					pstmt.setString(1, dto.getMid());
					pstmt.setString(2, dto.getMpass());
					rset=pstmt.executeQuery();
					
					//결과값을 true 로 반환하여 컨트롤러에서 값 비교한다 
					if(rset.next()) {
						result=true;
				    }
					System.out.println("로그인:"+result);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					if(rset !=null) {try {rset.close();}catch(Exception e) {e.printStackTrace();}}
					if(pstmt !=null) {try {pstmt.close();}catch(Exception e) {e.printStackTrace();}}
					if(conn !=null) {try {conn.close();}catch(Exception e) {e.printStackTrace();}}
				}
				
				return result;
				
	}
	/////////////////////////
	public MDto page(MDto dto) {
		
		PreparedStatement pstmt=null; ResultSet rset=null;Connection conn=null;
		
	    String sql="select mid,mpass,mname,memail,mdate from mvcmember3 where mid=?";
	   
	    //디비
	  		try {
	  			DBManager db=new DBManager();
	  			conn=db.connection();
	  		}catch(Exception e) {
	  			e.printStackTrace();
	  		}
	  		///////
	  		try {
	  			pstmt=conn.prepareStatement(sql);
	  			pstmt.setString(1, dto.getMid());
	  			rset=pstmt.executeQuery();
	  			
	  			if(rset.next()) {
	  				dto.setMid(rset.getString("mid"));
	  				dto.setMpass(rset.getString("mpass"));
	  				dto.setMname(rset.getString("mname"));
	  				dto.setMemail(rset.getString("memail"));
	  				dto.setMdate(rset.getString("mdate"));
			    }
	  			 
	  			System.out.println("페이지"+dto);
	  			
	  		}catch(Exception e){e.printStackTrace();
			}finally{
				if(rset !=null) {try {rset.close();}catch(Exception e) {e.printStackTrace();}}
				if(pstmt !=null) {try {pstmt.close();}catch(Exception e) {e.printStackTrace();}}
				if(conn !=null) {try {conn.close();}catch(Exception e) {e.printStackTrace();}}
				}
	  		
			return dto;
	  		
			
	}
	
	//////로그인 정보 수정기능
	public int signupedit(MDto dto) {
		PreparedStatement pstmt=null;  Connection conn=null;
		String sql="update mvcmember3 set mname=?, memail=? where mid=?"; 
		int result=-1;
		//디비
		try {
			DBManager db=new DBManager();
			conn=db.connection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//////
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMname());
			pstmt.setString(2, dto.getMemail());
			pstmt.setString(3, dto.getMid());
			
			 result=pstmt.executeUpdate();
			 System.out.println("회원정보수정 dao"+result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			   if(pstmt!=null){try{pstmt.close();}catch(Exception e ){e.printStackTrace(); } }
			   if(conn!=null){try{conn.close();}catch(Exception e ){e.printStackTrace(); } } 
			}
		return result;
	}
	
	////로그인 비번 수정 기능
	public int passedit(MDto dto,String newpass) { //파리미터에 newpass를 추가시켜준다
		PreparedStatement pstmt=null; ResultSet rset=null; Connection conn=null;
		
		int result=-1;
		String sql="update mvcmember3 set mpass=? where mid=? and mpass=?";
		
		//디비
		try {
			DBManager db=new DBManager();
			conn=db.connection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//////////
	      try {
	    	
	    	  pstmt=conn.prepareStatement(sql);
	    	  
	    	  pstmt.setString(1, newpass);//비번수정을 처음에 새로운 비번 입력
	    	  pstmt.setString(2, dto.getMid());
	    	  pstmt.setString(3, dto.getMpass());
	    	  
	    	  
	    	  result=pstmt.executeUpdate();
	    	  System.out.println("비번수정 dao"+result);
	    	  
	      }catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rset !=null) {try {rset.close();}catch(Exception e) {e.printStackTrace();}}
				if(pstmt !=null) {try {pstmt.close();}catch(Exception e) {e.printStackTrace();}}
				if(conn !=null) {try {conn.close();}catch(Exception e) {e.printStackTrace();}}
			}
			
		
		return result;
	}
	//////////탈퇴 기능
	public int delete(MDto dto) {
		Connection conn=null;PreparedStatement pstmt=null; ResultSet rset=null;
		String sql="delete from mvcmember3 where mid=? and mpass=?";
		int result=-1;
		//디비
				try {
					DBManager db=new DBManager();
					conn=db.connection();
				}catch(Exception e) {
					e.printStackTrace();
				}
	//////////////////
				try {
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, dto.getMid());
					pstmt.setString(2, dto.getMpass());
					result=pstmt.executeUpdate();
					
					System.out.println("삭제기능"+result);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
			       	
			          if(pstmt!=null){ try{pstmt.close(); }catch(Exception e){ e.printStackTrace(); }}
			          if(conn!=null){ try{conn.close(); }catch(Exception e){ e.printStackTrace(); }}
			      }
				return result;
	}
	//아이디 중복 체크
	public int idcheck(MDto dto) {
		int cnt=-1;
		Connection conn=null;PreparedStatement pstmt=null; ResultSet rset=null;
		String sql="select count(*) cnt from mvcmember3 where mid=?";
		
		
		
		try{
			DBManager db=new DBManager();
			conn=db.connection();
		    if(conn !=null) {
		    	System.out.println("db연동성공! :");
		    }
		}catch(Exception e) {e.printStackTrace();
		}
		/////
		try {
			pstmt = conn.prepareStatement("select count(*) cnt from mvcmember3 where mid=?");
			//카운트로 값이있으면 1 없으면 0 나오게 만듬 1이면 중복
			pstmt.setString(1, dto.getMid() );
			//pstmt.setString(1, "aaa");
			rset = pstmt.executeQuery();
			 if(rset.next()) {
				 cnt=rset.getInt("cnt");
				 }
			 
			 
			 
			 System.out.println("로그인 중복체크cnt:"+cnt);
			 
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {e.printStackTrace();}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {e.printStackTrace();}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {e.printStackTrace();}}
		}
		return cnt;
	}
	


}

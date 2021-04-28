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
	
	
       //ȸ������ 
	public int signup(MDto dto) {
		int result=-1;
		Connection conn=null; PreparedStatement pstmt=null;
		String sql = "insert into mvcmember3(mid,mname,mpass,memail,mip,zonecode,address,address2) values ( ?,?,?,?,?,?,?,?)";
		
		//���
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
	
	//ȸ�������ϰ� ��� ������ mid�� Ŭ���� �װſ� �´� ���� ����
	public MDto list(MDto dto) {
		MDto result=new MDto();
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		String sql="select*from mvcmember3 where mid=?";
				
		//���
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
				//���� result �ְ� �������� ��ȯ���ش�
			}
			System.out.println("ȸ������"+result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) {try {rset.close();}catch(Exception e) {e.printStackTrace();}}
			if(pstmt !=null) {try {pstmt.close();}catch(Exception e) {e.printStackTrace();}}
			if(conn !=null) {try {conn.close();}catch(Exception e) {e.printStackTrace();}}
		}
		return result;
	}
	//�α���  
	public boolean login(MDto dto) {
		//id,pass���� �ΰ� ������  true�� ����
		boolean result=false;
		PreparedStatement pstmt=null; ResultSet rset=null; Connection conn=null;
		//String sql="select mid,mpass from mvcmember3 where mid=? and mpass=?";
		
		//���
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
					
					//������� true �� ��ȯ�Ͽ� ��Ʈ�ѷ����� �� ���Ѵ� 
					if(rset.next()) {
						result=true;
				    }
					System.out.println("�α���:"+result);
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
	   
	    //���
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
	  			 
	  			System.out.println("������"+dto);
	  			
	  		}catch(Exception e){e.printStackTrace();
			}finally{
				if(rset !=null) {try {rset.close();}catch(Exception e) {e.printStackTrace();}}
				if(pstmt !=null) {try {pstmt.close();}catch(Exception e) {e.printStackTrace();}}
				if(conn !=null) {try {conn.close();}catch(Exception e) {e.printStackTrace();}}
				}
	  		
			return dto;
	  		
			
	}
	
	//////�α��� ���� �������
	public int signupedit(MDto dto) {
		PreparedStatement pstmt=null;  Connection conn=null;
		String sql="update mvcmember3 set mname=?, memail=? where mid=?"; 
		int result=-1;
		//���
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
			 System.out.println("ȸ���������� dao"+result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			   if(pstmt!=null){try{pstmt.close();}catch(Exception e ){e.printStackTrace(); } }
			   if(conn!=null){try{conn.close();}catch(Exception e ){e.printStackTrace(); } } 
			}
		return result;
	}
	
	////�α��� ��� ���� ���
	public int passedit(MDto dto,String newpass) { //�ĸ����Ϳ� newpass�� �߰������ش�
		PreparedStatement pstmt=null; ResultSet rset=null; Connection conn=null;
		
		int result=-1;
		String sql="update mvcmember3 set mpass=? where mid=? and mpass=?";
		
		//���
		try {
			DBManager db=new DBManager();
			conn=db.connection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//////////
	      try {
	    	
	    	  pstmt=conn.prepareStatement(sql);
	    	  
	    	  pstmt.setString(1, newpass);//��������� ó���� ���ο� ��� �Է�
	    	  pstmt.setString(2, dto.getMid());
	    	  pstmt.setString(3, dto.getMpass());
	    	  
	    	  
	    	  result=pstmt.executeUpdate();
	    	  System.out.println("������� dao"+result);
	    	  
	      }catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rset !=null) {try {rset.close();}catch(Exception e) {e.printStackTrace();}}
				if(pstmt !=null) {try {pstmt.close();}catch(Exception e) {e.printStackTrace();}}
				if(conn !=null) {try {conn.close();}catch(Exception e) {e.printStackTrace();}}
			}
			
		
		return result;
	}
	//////////Ż�� ���
	public int delete(MDto dto) {
		Connection conn=null;PreparedStatement pstmt=null; ResultSet rset=null;
		String sql="delete from mvcmember3 where mid=? and mpass=?";
		int result=-1;
		//���
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
					
					System.out.println("�������"+result);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
			       	
			          if(pstmt!=null){ try{pstmt.close(); }catch(Exception e){ e.printStackTrace(); }}
			          if(conn!=null){ try{conn.close(); }catch(Exception e){ e.printStackTrace(); }}
			      }
				return result;
	}
	//���̵� �ߺ� üũ
	public int idcheck(MDto dto) {
		int cnt=-1;
		Connection conn=null;PreparedStatement pstmt=null; ResultSet rset=null;
		String sql="select count(*) cnt from mvcmember3 where mid=?";
		
		
		
		try{
			DBManager db=new DBManager();
			conn=db.connection();
		    if(conn !=null) {
		    	System.out.println("db��������! :");
		    }
		}catch(Exception e) {e.printStackTrace();
		}
		/////
		try {
			pstmt = conn.prepareStatement("select count(*) cnt from mvcmember3 where mid=?");
			//ī��Ʈ�� ���������� 1 ������ 0 ������ ���� 1�̸� �ߺ�
			pstmt.setString(1, dto.getMid() );
			//pstmt.setString(1, "aaa");
			rset = pstmt.executeQuery();
			 if(rset.next()) {
				 cnt=rset.getInt("cnt");
				 }
			 
			 
			 
			 System.out.println("�α��� �ߺ�üũcnt:"+cnt);
			 
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {e.printStackTrace();}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {e.printStackTrace();}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {e.printStackTrace();}}
		}
		return cnt;
	}
	


}

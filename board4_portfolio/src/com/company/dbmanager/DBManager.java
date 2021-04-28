package com.company.dbmanager;

import javax.sql.*; 
import javax.naming.*;
import java.sql.Connection;

import java.sql.SQLException;

public class DBManager {
   private static Connection conn;

public DBManager() {
	conn=null;
}
public Connection connection() throws Exception{

	try {
		//1.servaer.xml context 리소스찾기
		Context initContext=new InitialContext();
		//2.환경설정
		Context envContext=(Context) initContext.lookup("java:/comp/env");
		//3.datasource 설정
		//DataSource db=(DataSource)envContext.lookup("jdbc/myoracle");
	DataSource db=(DataSource)envContext.lookup("jdbc/TestDB");
//	DataSource db=(DataSource)envContext.lookup("jdbc/leed2205");
		//4.connection
		conn=db.getConnection();
		if(conn !=null){
			System.out.println("dbcp연동성공");
			
		}
		}catch(NamingException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return conn;
		
		
}   

   
}

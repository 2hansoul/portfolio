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
		//1.servaer.xml context ���ҽ�ã��
		Context initContext=new InitialContext();
		//2.ȯ�漳��
		Context envContext=(Context) initContext.lookup("java:/comp/env");
		//3.datasource ����
		//DataSource db=(DataSource)envContext.lookup("jdbc/myoracle");
	DataSource db=(DataSource)envContext.lookup("jdbc/TestDB");
//	DataSource db=(DataSource)envContext.lookup("jdbc/leed2205");
		//4.connection
		conn=db.getConnection();
		if(conn !=null){
			System.out.println("dbcp��������");
			
		}
		}catch(NamingException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return conn;
		
		
}   

   
}

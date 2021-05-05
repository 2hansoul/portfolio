<%@page import="com.company.dto.BDto"%>
<%@page import="com.company.dao.Bdao_list"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.company.dbmanager.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


<!-- jQuery library -->
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container panel panel-info">
<h3 class="panel-heading">DBCP-TEST-board</h3>

<%
DBManager db=new DBManager();
Connection conn=db.connection();
if(conn !=null){
	out.println("dbcp연동성공");
}
%>
<h3 class="panel-heading">2.dao</h3>
<%-- <%
Bdao_list dao =new Bdao_list();
out.println("2-1:"+dao.list()+"<br/>");
////////
/*
BDto dto=new BDto();
dto.setBname("first"); dto.setBpass("1111"); dto.setBtitle("title"); dto.setBcontent("content");
out.println("2-2 create(dto):" + dao.create(dto));
*/

//3. public int update_hit(BDto dto) 
BDto dto_no = new BDto();
dto_no.setBno(2);
out.println("2-3. update_hit(dto) : " + dao.update_hit(dto_no) + "<br/>" );

//4. read
BDto dto_no2=new BDto();
dto_no2.setBno(2);
out.println("2-4 read:" + dao.read(dto_no2)+"<br/>");


//5.update
BDto dto_no3 =new BDto();
dto_no3.setBtitle("title_new"); dto_no3.setBcontent("content_new"); dto_no3.setBno(2); dto_no3.setBpass("1111");
out.println("2-5 update:"+dao.update(dto_no3)+"<br/>");

//6 delete
BDto dto_no4 =new BDto();
dto_no4.setBno(2); dto_no4.setBpass("1111");
out.println("2-6 delete:"+dao.delete(dto_no4) +"<br/>");
%> --%>
<%-- <%
//7 search
BDto dto=new BDto();
Bdao_list dao =new Bdao_list();

out.println("검색:"+dao.search("ff"));

%> --%>





<h3 class="panel-heading">3.frontcontroller</h3>
<% response.sendRedirect(request.getContextPath()+"/uploadList1.vi"); %> 
<%-- <% response.sendRedirect(request.getContextPath()+"/list.do"); %> --%>

<!-- http://leed2205.cafe24.com/board4_page/main/mainpage.jsp -->
</div>






</body>

</html>
   
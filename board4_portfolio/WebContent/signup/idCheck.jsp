<%@page import="com.company.dto.MDto"%>
<%@page import="com.company.dao.Mdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>중복체크</title>
<script src="signup_form.jsp"></script>
<body>
<%

String mid=request.getParameter("mid");
MDto dto=new MDto();
Mdao dao=new Mdao();

if(dao.idcheck(dto)==1){
	out.println("사용중입니다");

%>
<input type="button" value="확인" onclick="window.close()">
<%
}else{
	out.println("사용가능");

%>
<input type="button" value="사용" onclick="mid()">
<input type="button" value="취소" onclick="window.close()">
<%
  }
%>

</body>

</html>
   
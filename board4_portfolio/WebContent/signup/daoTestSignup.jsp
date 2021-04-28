<%@page import="com.company.dto.MDto"%>
<%@page import="com.company.dao.Mdao"%>
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
<%
 Mdao dao=new Mdao();

 MDto dto=new MDto();
 dto.setMid("ccc"); dto.setMname("hansol"); dto.setMpass("123456");
dto.setMemail("2hansoul@naver.com"); dto.setMip("172.123"); dto.setAddress("Ggg"); dto.setAddress2("ggg"); dto.setZonecode("aaa");
out.println("dao 회원가입 테스트"+dao.signup(dto)+"</br>");  

MDto dto2=new MDto();
dto2.setMid("aaa");
out.println("dao 회원가입 id입력하면 그거에 맞는 값 도출"+dao.list(dto2));

MDto dto3=new MDto();
dto3.setMid("1"); dto3.setMpass("1");
out.println("로그인 아이디,비번 입력하면 그 값 뜨는지?"+dao.login(dto3)+"</br>");

MDto dto4=new MDto();
dto4.setMname("han");dto4.setMemail("@naver,com");dto4.setMid("bbb");
out.println("회원정보수정"+dao.signupedit(dto4));

MDto dto5=new MDto();
String newpass="";
dto5.setMpass("newpass"); dto5.setMid("han"); dto5.setMpass("74947494");
out.println("비번수정"+dao.passedit(dto5, newpass));

MDto dto6=new MDto();
dto6.setMpass("123456"); dto6.setMid("ccc");
out.println("회원탈퇴"+dao.delete(dto6));

MDto dto7=new MDto();
dto7.setMid("ccc");
out.println("아이디중복체크"+dao.idcheck(dto7));

%>

</body>

</html>
   
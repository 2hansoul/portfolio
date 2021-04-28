<%@page import="com.company.dto.MDto"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>

<!--      HEADER        -->
<!--      HEADER        -->
<!--      HEADER        -->
<!--      HEADER        -->
<!--      HEADER        -->



<div class="container panel panel-info mymain">
	<h3 class="panel-heading">FORM BASIC-JOIN</h3>
	<table class="table table-striped">
		<caption>회원가입을 축하합니다.</caption>
		<tbody>
			<tr>
				<th scope="row">아이디</th>
				<td>${dto.mid}</td>
			</tr>
			<tr>
				<th scope="row">이름</th>
				<td>${dto.mname}</td>
			</tr>
			<tr>
				<th scope="row">이메일</th>
				<td>${dto.memail}</td>
			</tr>
			<tr>
				<th scope="row">가입날짜</th>
				<td>${dto.mdate}</td>
			</tr>
			<tr>
			<th scope="row">주소</th>
				<td>${dto.zonecode}-${dto.address}-${dto.address2}</td>
		   </tr>
		</tbody>
	</table>
	<p>
		
		<a href="<%=request.getContextPath()%>/login.signup" class="btn btn-danger">login</a>
		
	</p>
</div>


<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<%@ include file="../inc/footer.jsp"%>
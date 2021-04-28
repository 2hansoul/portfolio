
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>

<%@page import="com.company.dto.MDto"%>
<!--      HEADER        -->




   <div class="container mymain">
      <h3>PAGE</h3>
      <table class="table table-striped">
         <caption>회원정보</caption>    
         
            <tr><th scope="row">아이디      <%=midsession %></th></tr>
            <tr><th scope="row">이름       ${dto.mname}  </th></tr>                                            
            <tr><th scope="row">이메일     ${dto.memail}</th></tr>
            <tr><th scope="row">가입날짜  ${dto.mdate }</th>  </tr> 
          
      </table>
      
      <p><a href="<%=request.getContextPath() %>/login_edit.signup" class= "btn btn-info">회원정보수정</a>
      
      <a href="<%=request.getContextPath() %>/passedit.signup" class= "btn btn-info">비밀번호수정</a>
      <a href="<%=request.getContextPath() %>/deleteview.signup" class= "btn btn-info">탈퇴</a></p>
      
      
   </div>
  


<!-- Footer -->
<!-- Footer -->
<!-- Footer -->

<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<%@ include file="../inc/footer.jsp"%>
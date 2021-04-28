<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<%

   session.invalidate();//저장되어있는 세션 자체를 아웃 
   out.println("<script>alert('로그아웃 되었습니다.'); location.href='"+request.getContextPath()+"/login.signup'; </script> ");
   

%>
<%@ include file="../inc/footer.jsp"%>
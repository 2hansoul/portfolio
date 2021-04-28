<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<%@page import="com.company.dto.MDto"%>
<%
MDto md=(MDto)request.getAttribute("md");
%>  
   
   <div class="container panel panel-info mymain">
      <h3>수정하기</h3>
      <form action="<%=request.getContextPath() %>/login_edit_action.signup?mno=${dto.mno}" method="post" id="form_edit">
         <fieldset>
          
            
            <div class="form-group">
               <label for="mid">아이디</label> 
               <input type="text" id="mid" name="mid" class="form-control" value="<%=session.getAttribute("mid")%>" readonly/>
            </div>
            <div class="form-group">
               <label for="mname">이름</label> 
               <input type="text" id="mname"
                  name="mname" class="form-control" value="${dto.mname}"/>
            </div>
            <div class="form-group">
               <label for="memail">메일</label>
               <input type="text" id="memail" name="memail" size=10 
                  class="form-control" value="${dto.memail}"/>
            </div>
                     
         <div class="form-group">
               <label for="mdate">가입날짜</label> 
               <input type="text"  class="form-control" value="${dto.mdate}" readonly/>
            </div>
            
            <div class="form-group text-right">
               <input type="submit" value="수정" title="글쓰기 수정" class="btn btn-danger"readonly />
               <input type="reset"   onclick="history.go(-1);"  value="취소"    class="btn btn-info"  > 
               
               
            </div>
         </fieldset>
      </form>
      <script>
         $(document).ready(function() {
            $("#form_edit").submit(function() {
               if ($("#mname").val() == "") {
                  alert("빈칸입니다\n이름");
                  return false;
                  $("#manme").foucs();
                  return false;
               }

               if ($("#memail").val() == "") {
                  alert("빈칸입니다\n메일");
                  return false;
                  $("#memail").foucs();
                  return false;
               }
            });
         });
      </script> 
   </div> 

   
   
 <%@ include file="../inc/footer.jsp"%>  
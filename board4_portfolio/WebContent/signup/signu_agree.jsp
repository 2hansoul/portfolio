<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<!-- header end -->

<div class="container panel panel-info mymain">
	<h3 class="panel-heading">약관동의</h3>
	<p>(*)은 필수입력사항</p>
	
	<form action="<%=request.getContextPath()%>/signup_form_view.signup" method="get" id="form_check">
	<fieldset class="form-group">
	
	<legend>COMPANY약관동의</legend>
	<p class="text-right">
	<input type="checkbox" id="agree1" name="agree1" title="서비스 약관동의 체크"/></p>
	 
	<textarea rows="10" class="form-control" title="서비스 약관내용입니다">
	
	<%@ include file="../inc/agree1.txt" %>
	</textarea>
	</fieldset>
	
	<fieldset class="form-group">
	<legend>COMPANY약관동의</legend>
	<p class="text-right">
	<input type="checkbox" id="agree2" name="agree2" title="개인정보 동의??"/></p>
	<textarea rows="10" class="form-control" title="개인정보 수집 내용">
	<%@ include file="../inc/agree2.txt" %>
	</textarea>
	</fieldset>
	
	
	<fieldset class="form-group text-center">
  <input type="submit" value="동의하기 " class="btn" title="동의하기 버튼"/>
	    
	</fieldset>
	
	</form>
	<script>
    $(document).ready(function(){
        $("#form_check").submit(function(){
        	console.log( $("#agree1"));
        	console.log( $("#agree1:checked").length);
        	console.log( $("#agree1").is(":checked"));//true,false
        	console.log( $("#agree2"));
        	console.log( $("#agree2:checked").length);
        	console.log( $("#agree2").is(":checked"));//true,false
        	if( !$("#agree1").is(":checked")){alert("약관 동의해야함");return false;}
        	if( !$("#agree2").is(":checked")){alert("약관 동의해야함");return false;}
        });	 
 });
	
	
	</script>
	
	
</div>

<!-- footer end -->
<%@ include file="../inc/footer.jsp"%>

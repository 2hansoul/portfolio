<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include  file="/inc/header.jsp" %>


<div class="container main"  >
<h3 >고객센터</h3>
<script src="//cdn.ckeditor.com/4.16.0/standard/ckeditor.js"></script>
<script>
$(function(){
	CKEDITOR.replace('content');
});
</script>
<form action="${pageContext.request.contextPath}/Mail1" method="post" id="mail_form">
<fieldset>
<legend>문의 메일 보내기</legend>
<table class="table table-striped">
<caption>평일:AM 9:30~PM 18:30 </caption>
<caption>점심:PM 12:30~ 13:30  </caption>
<tbody>
<tr>
<th scope="row"><label for="subject">제목</label></th>
<td><input type="text" id="subject" name="subject" placeholder="제목 적으세요" class="form-control"/></td>
</tr>
<tr>
<th scope="row"><label for="content">내용</label></th>
<td><textarea id="content"  name="content" placeholder="내용 입력" class="form-control">
</textarea></td>
</tr>
<tr>


<td colspan="10"><input type="submit" value="전송" class="btn btn-warning"/></td>
<td colspan="2"><a href="<%=request.getContextPath() %>/list.do"  class="btn btn-warning" >목록보기</a> 
 
</tr>

</tbody>

</table>
</fieldset>

</form>
<script>
$(document).ready(function(){
	$("#mail_from").submit(function(){
		if($("#subject").val()==""){
			alert("빈칸입니다");
			$("#subject").focus();
			return false;
		}
		if($("#content").val()==""){
			alert("빈칸입니다");
			$("#content").focus();
			return false;
		}
	});
});
</script>


</div>




<%@ include  file="/inc/footer.jsp" %>
   
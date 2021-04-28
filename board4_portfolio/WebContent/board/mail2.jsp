<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<body>
<div class="conatiner panel panel-waring">
<h3 class="panel-heading">메일 api</h3>
<pre>
https://ckeditor.com/ckeditor-4/download/
</pre>
<script src="//cdn.ckeditor.com/4.16.0/standard/ckeditor.js"></script>
<script>
$(function(){
	CKEDITOR.replace('content');
});
</script>
<form action="${pageContext.request.contextPath}/Mail1" method="post" id="mail_form">
<fieldset>
<legend>관리자에게 문의 메일 보내기</legend>
<table class="table table-striped">
<caption>궁금하면 메일 보내세요</caption>
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

<td colspan="2"><input type="submit" value="전송" class="btn btn-warning"/></td>
<td colspan="2"><a href="page.jsp" class="btn btn-warning">이전</a></td>
  
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

</body>

</html>
   
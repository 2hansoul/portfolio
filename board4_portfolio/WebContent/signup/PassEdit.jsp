<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<div class="container panel panel-info mymain">
	<h3>수정하기</h3>
	<form action="<%=request.getContextPath() %>/passeditAction.signup" method="post" id="form_edit">
		<fieldset>


			<div class="form-group">
				<label for="mpass">이전비밀번호</label>
				<input type="text" id="mpass" name="mpass" class="form-control"  />
			</div>
			<div class="form-group">
				<label for="newpass">새 비밀번호</label>
				<input type="password" id="newpass" name="newpass" class="form-control" />
			</div>
			<div class="form-group">
				<label for="newpass1">새 비밀번호확인</label>
				<input type="password" id="newpass1" name="newmpass1" size=10 class="form-control" />
			</div>



			<div class="form-group text-right">
				<p>
					
					<input type="submit" value="수정" title="수정" class="btn btn-danger" readonly />
					<input type="reset"   onclick="history.go(-1);"  value="취소"    class="btn btn-info"  > 
			</div>
		</fieldset>
	</form>
	<script>
		$(document).ready(function() {
			$("#form_edit").submit(function() {
				if ($("#newpass").val() == "") {
					alert("빈칸입니다\n비밀번호");
					return false;
					$("#newmpass").foucs();
					return false;
				}
				if ($("#newpass1").val() == "") {
					alert("빈칸입니다\n비밀번호");
					return false;
					$("#newmpass1").foucs();
					return false;
				}

				if ($("#mpass").val() == "") {
					alert("빈칸입니다\비빌번호");
					return false;
					$("#mpass").foucs();
					return false;
				}
				//새비빌번호 입력한 같이랑 새 비빌번호 확인이랑 맞는지 테스트
				if (!($("#newpass").val() == $("#newpass1").val())) {
					alert("새 비빌번호 확인");
					return false;
					$("#newpass2").foucs();
					return false;
				}
			});
		});
	</script>
</div>


<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<%@ include file="../inc/footer.jsp"%>
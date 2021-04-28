<%@page import="com.company.dao.Mdao"%>
<%@page import="com.company.dto.MDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>

<div class="container panel panel-info main"  style="margin-top:2%;">
	<!-- 넒게 보이기위해 -->
	<h3>회원가입</h3>
	<p>(*)은 필수입력사항</p>
	<form action="<%=request.getContextPath()%>/signup_action.signup" method="post" id="form_signup">

		<p>필수정보입력</p>
		<div class="form-group">
			<label for="mid">(*)아이디</label>
			 <input type="text" id="mid" name="mid" />
			<input type="hidden" id="id_ok" class="form-control">
		<div class="form-group">
			<input type="button" value="중복확인" class="btn btn-info" id="idtest" />
		</div>
		
		
	</div>


			 
				
		     
		


		<div class="form-group">
			<label for="mname">(*)이름</label> <input type="text" id="mname"
				name="mname"  />
		</div>

		<div class="form-group">
			<label for="mpass">(*)비밀번호</label> <input type="password" id="mpass"
				name="mpass"  />
		</div>
		<div class="form-group">
			<label for="mpasscheck">(*)비밀번호확인</label> <input type="password"
				id="mpasscheck" name="mpasscheck" />
		</div>
		<div class="form-group">
			<label for="memail">(*)이메일</label> <input type="text" id="memail"
				name="memail"  />
		</div>
<div class="form-group">
		
<div class="row">
<div class="col-sm-4">
<input type="text" id="zonecode" name="zonecode" title="우편번호" placeholder="우편번호" readonly />
</div>

<div class="col-sm-4">
<input type="button" value="우편번호찾기" id="postcode" class="btn btn-info"/>
</div>
</div>
</div>

<div class="row">
<div class="col-sm-6">
<input type="text" id="address" name="address" title="상세주소1" placeholder="주소" class="form-control" readonly/>
</div>
<div class="col-sm-4">
<input type="text" id="address2" name="address2"  title="상세주소2" placeholder="상세주소" class="form-control"/>
</div>
</div>
		
		
		<!-- <div class="form-group">
		<input type="radio" id="남" name="a" value="s2">
          <label for="no">남</label>
			<input type="radio" id="여" name="a" value="s1"> <label
				for="yes">여</label>
		</div> -->
		
		
		
<!-- 스크립트 겸 회원가입 버튼  -->		
<!--  -->
<!--  -->

		<div class="form-group">
			<input type="submit" value="회원가입하기" title="회원가입하기"
				class=" btn btn-danger" />
		</div>
		<p>
			<a href="signu_agree.jsp" class="btn btn-danger">이전</a>
		</p>
	</form>
	
	



	<%--조건식이 아니기 때문에 함수를 밖에서 써준다 --%>
	<script>
		$(document).ready(function() {
			$("#form_signup").submit(function() {
				if ($("#mid").val() == "") {
					alert("빈칸입니다");
					$("#mid").focus();
					return false;
				}
				if($("#id_ok").val()!=1){
					alert("아이디 중복체크 하세요");
					return false;
				}
				if ($("#mname").val() == "") {
					alert("빈칸입니다");
					$("#mname").focus();
					return false;
				}
				if ($("#mpass").val() == "") {
					alert("빈칸입니다");
					$("#mpass").focus();
					return false;
				}
				if ($("#mpasscheck").val() == "") {
					alert("빈칸입니다");
					$("#mpasscheck").focus();
					return false;
				}
				if ($("#memail").val() == "") {
					alert("빈칸입니다");
					$("#memail").focus();
					return false;
				}
				if ($("#address").val() == "") {
					alert("주소빈칸입니다");
					$("#address").focus();
					return false;
				}
				if ($("#address2").val() == "") {
					alert("상세주소를 입력해주세요");
					$("#address2").focus();
					return false;
				}
				if ($("#address2").val() == "") {
					alert("상세주소를 입력해주세요");
					$("#address2").focus();
					return false;
				}
					
			});

		});
	</script>

	
	
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(function(){
	$("#postcode").click(function(){
		alert("우편번호검색입니다");
	    new daum.Postcode({
	        oncomplete: function(data) {
	           $("#zonecode").val(data.zonecode);// 새 우편번호.
	           $("#address").val(data.roadAddress);
	           $("#address2").focus();
	        }
	    }).open();//팝업 띄우기
	});
});
</script>
<!--id 중복체크  -->
<script>
$(function(){
	$("#idtest").click(function(){
		if($("#mid").val()==""){ $("#mid").focus();return false;}
		else{
				$.ajax({
					url : "${pageContext.request.contextPath}/idcheck.signup",
					type : "get",
					dataType : "text",
					data : {"mid" : $("#mid").val()},
					success : function(data){
						if(data==0){
							alert("아이디 사용가능 합니다");$("#id_ok").val(1);
							
							
						}else if(data==1){
							alert("아이디 중복입니다");
						}
					},
					error : function(xhr,textStatus,errorThrown){
						$("#iddouble").html(textStatus+"(HTTP-"+xhr.status+"/"+errorThrown);
					}
				});
			
		}//if
	});
});
	</script>


</div>



<!-- footer end -->
<%@ include file="../inc/footer.jsp"%>



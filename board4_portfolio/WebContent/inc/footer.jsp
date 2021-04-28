<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--           FOOTER              -->
<!--           FOOTER              -->
<!--           FOOTER              -->

<div id="notice" class="container panel panel-success subpopup" 
style="position:fixed; top:30%; left:10%; width:20%; color:#333; ">
<h3 class="panel-heading">공지사항</h3>
<p><img src="frame.png" alt="" style="width:50%; height:50%"/></p>
<p>본 사이트는 상업적 목적이 아닌<strong>개인 포트폴리오 </strong> 용도로 제작되었으며,
홈페이지의 일부 내용과 기타 이미지등은 그 출처가 따로 있음을 밝힙니다.</p>

<p>
<input type="checkbox" id="subpop2" name="subpop2"/>
<label for="subpop2">오늘 하루동안 이창을 열지않음</label>
<input type="button" class="btn btn-danger" id="close" value="close"/>

</p>





</div>

<script>
$(function(){
//쿠키설정 확인   
if(getCookie("subpop2")=="subpop2"){
   $("#notice").hide();
}   
else{$("#notice").show();}
   
   
   $("#close").click(function(){
   if($("#subpop2:checked").length==1){
      setCookie("subpop2","subpop2",1);
   }   
      
      $("#notice").fadeOut();
   });
});

function setCookie(cname, cvalue, exdays) {
	  var d = new Date();
	  d.setTime(d.getTime() + (exdays*24*60*60*1000));
	  var expires = "expires="+ d.toUTCString();
	  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
	}

	function getCookie(cname) {
	  var name = cname + "=";
	  var decodedCookie = decodeURIComponent(document.cookie);
	  var ca = decodedCookie.split(';');
	  for(var i = 0; i <ca.length; i++) {
	    var c = ca[i];
	    while (c.charAt(0) == ' ') {
	      c = c.substring(1);
	    }
	    if (c.indexOf(name) == 0) {
	      return c.substring(name.length, c.length);
	    }
	  }
	  return "";
	}
</script>





<style>
.footer {
	border-top: 2px solid #ddd;
	padding-top: 17px;
}
</style>
<footer class="container-fluid text-center">
	<div class="container panel panel-success" style="border: 1px solid blue">
		<div class="col-sm-8">
			대표자: 이한솔 사업자 등록번호: 139-81-32740<br> e-mail: 2hansoul@naver.com<br> 주소: (21689) 서울특별시 광진구 자양동 (자양동 740-3)
		</div>

		<div class="col-sm-4">
			<p>
				<img src="<%=request.getContextPath()%>/frame.png" alt="" style="width: 20%; margin-top: 10px;" />
			</p>
		</div>
	</div>
</footer>
<footer class="container-fluid text-center">
	<a class="up-arrow" href="#myPage" data-toggle="tooltip" title="To Top">
		<span class="glyphicon glyphicon-chevron-up"></span>
	</a>
	<p>
		LEEHANSOL HOME PAGE
		<a href="http://leed2205.cafe24.com/board4_portfolio/uploadList1.vi" title="Visit w3schools">http://leed2205.cafe24.com</a>
	</p>
</footer>




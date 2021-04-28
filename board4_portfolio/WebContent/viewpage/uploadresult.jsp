<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/inc/header.jsp" %>


	
<!-- 제품 폼 -->		
<div class="container">
<h3 class="" style="background-color: #135dba;padding:25px;color:white;">최신제품 </h3>
<!--검색  -->
<select id="userlist"  name="userlist">
		<option value="default">모델선택</option>
		<option value="1">LGGRAM</option>
		<option value="2">DELL</option>
		<option value="3">SAMSUNG</option>
	</select>
				<div class="panel-body r4">
				<table class="table table-striped">
					<caption></caption>
					<thead>
						<tr>
							<th>MOEDL</th>
							<th>NAME</th>
							<th>PRICE</th>
							<th>CPU</th>
							<th>GPU</th>
							
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				</div>
			<script>
				$(function(){
					$("#userlist").change(function(){
						console.log($(this).val()); // default ,1,2,3
						console.log( typeof($(this).val()) ); // default ,1,2,3
						console.log( Number( $(this).val() ) -1); 
						if($(this).val()=="default"){alert("선택해주세요."); return false;}
						else{
							var index = Number( $(this).val() )-1;  console.log("index : "+index);
							$.ajax({
							url : "${pageContext.request.contextPath}/xml3.xml",
							type: "get",
							dataType : "xml" ,
							success :  function(xml){
								console.log(xml);
								var menu = $(xml).find("menu"); // 
								var mydata = $(menu[index]);
								$(".r4 tbody").html(
									$("<tr>").append($("<td>").html("<img src='img/"+mydata.find("img").text()+"'alt=''/>")) 		 
											.append($("<td>").html(mydata.find("name").text()))		
											.append($("<td>").html(mydata.find("price").text()))		
											.append($("<td>").html(mydata.find("CPU").text()))
											.append($("<td>").html(mydata.find("gpu").text()))

								);

							},
							error : function(xhr,textStatus, errorThrown){
								$(".r4 tbody").html(textStatus + "(HTTP-"+xhr.status + "/" +errorThrown);				
							}
						});
						}
					});
					});
			</script>

<div class="row ">
<c:forEach var="i" items="${list}" varStatus="status">

<div class="col-sm-13 well test">
<p class="test"></p>
<div class="col-sm-3">
				<div data-toggle="modal" data-target="#myModal${i.name}">
					<img src="${pageContext.request.contextPath}/upload/${i.img}" alt="${i.img}" />
				</div>
				<!-- Modal -->
				<div id="myModal${i.name}" class="modal fade" role="dialog">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">${i.info}</h4>
							</div>
							<div class="modal-body">
								<p>${i.name}- ${i.info} - ${i.price}</p>
								<p>
									<img src="${pageContext.request.contextPath}/upload/${i.img}" alt="${i.img}" style="width:50px; height:100px" />
									<%-- <img src="/upload/${i.img}" alt="${i.img}" style="width:50px; height:100px" /> --%>
								</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
			</div>
<p><span class=""></span>이름-<strong>${i.name}</strong> </p>
<p><span class=""></span>정보-<strong>${i.info}</strong> </p>
<p><span class=""></span>가격-<strong>${i.price}</strong> </p>
<p><span class=""></span>CPU-<strong>${i.cpu}</strong> </p>
<p><span class=""></span>GPU-<strong>${i.gpu}</strong> </p>
<!--호스팅 할때 경로 설정 안하면 이미지가 안뜨네  -->
<%-- <p><img src="${pageContext.request.contextPath}/upload/${i.img}" alt="${i.img}" class="img-thumbnail" style="height:174px"></p> --%>
<!-- <p><input type="button" value="더보기" id="xml1" class="btn btn-info"/></p> -->
<%-- <p><img src="/upload/${dto.img}" alt="${dto.img}" class="img-thumbnail" style="height:174px"><p> --%>
<!-- <input type="text" id="name"  name="name"class="form-control">
<input type="button" value="검색" name="select" id="select" class="btn btn-info"/> -->

</div>
</c:forEach>

		<c:forEach var="i" items="${list}" varStatus="status">
			
		</c:forEach>		
		

	

<!-- <script>
$(function(){
	$("#select").click(function(){
		$.ajax({
			url : "${pageContext.request.contextPath}/Ajax_view1",
			type : "get",
			dataType : "text",
			data : {"name" : $("#name").val()},
			success : function(data){
				console.log(data);
				  $(".test").html(data);
				},
			error : function(xhr,textStatus,errorThrown){
				$(".test").html(textStatus+"(HTTP-"+xhr.status+"/"+errorThrown);
			}
		});
	});	
});

</script> -->
</div><!--<div class="row">  -->
		
	

</div><!--<div class="container">  -->

<%@ include  file="/inc/footer.jsp" %>
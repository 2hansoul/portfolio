<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<style>
#myvideo{width:900px; height:500px;}
</style>




<!--Carousel  -->

  <div id="myCarousel1" class="carousel slide" data-ride="carousel">
    <div class="text-center">
    
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel1" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel1" data-slide-to="1"></li>
      <li data-target="#myCarousel1" data-slide-to="2"></li>
      
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <a href="<%=request.getContextPath()%>/uploadList.vi">
        <img src="<%=request.getContextPath()%>/main/images/gream.jpg" alt="Los Angeles" style="width:100%;">
        </a>
      </div>

      <div class="item">
     
       <a href="<%=request.getContextPath()%>/uploadList.vi">
        <img src="<%=request.getContextPath()%>/main/images/macbook.png" alt="Los Angeles" style="width:100%;">
        </a>
      </div>
    
      <div class="item">
       <a href="<%=request.getContextPath()%>/uploadList.vi">
        <img src="<%=request.getContextPath()%>/main/images/righttopmodel2.jpg" alt="Los Angeles" style="width:100%; height:50%; " >
        </a>
      </div>
    
    
      
    </div><!--<div class="carousel-inner">  -->

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel1" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel1" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

</div>







		
	
<div class="panel-body">
<iframe width="700" height="600" src="https://www.youtube.com/embed/6a9T_bvdxkU" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>


<iframe width="400" height="300" 
src="https://www.youtube.com/embed/pz5CxHVBp4A" 
frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
allowfullscreen>
</iframe>


<iframe width="400" height="300" 
src="https://www.youtube.com/embed/chP59GwYaJo" 
frameborder="100" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
allowfullscreen>
</iframe>
</div>




	

<div class="container panel panel-success">
<h3 class="" style="background-color: #135dba;padding:25px;color:white;">요거 어때? </h3>
<div class="row ">
<c:forEach var="i" items="${list}" varStatus="status">

<div class="col-sm-13 well test">
<p class="test"></p>
<div class="col-sm-3">
				<div data-toggle="modal" data-target="#myModal${i.name}">
					<img src="${pageContext.request.contextPath}/upload/${i.img}" alt="${i.img}" style="width:200px; height:140px"  />
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
							<div class="modal-body center">
								<p>${i.name}- ${i.info} - ${i.price}</p>
								<p>
									<img src="${pageContext.request.contextPath}/upload/${i.img}" alt="${i.img}" /><br>
									<%-- <img src="/upload/${i.img}" alt="${i.img}"  /> --%>
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
</div><!--<div class="container panle panel-info">  -->


<div class="container panel panel-success">
<h3 class="" style="background-color: #135dba;padding:25px;color:white;">상세정보 보기 </h3>
<div class="panel-group" id="accordion">
<c:forEach var="i" items="${list}" varStatus="status">
<div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse"  data-parent="#accordion" href="#collapse${i.name}">${i.name}</a>
        </h4>
      </div>
      
        <div id="collapse${i.name}"  class="panle-collapse collapse <c:if test="${status.first}"> in </c:if>">    
        <p><span class=""></span>정보-:<strong>${i.info}</strong> </p>
      <p><span class=""></span>가격-:<strong>${i.price}</strong> </p>
      <p><span class=""></span>CPU-:<strong>${i.cpu}</strong> </p>
      <p><span class=""></span>GPU-:<strong>${i.gpu}</strong> </p>
        </div>
        </div>
    </c:forEach>
    </div>
   </div>
   
    <div class="container panel panel-success">
    <h3 class="" style="background-color: #135dba;padding:25px;color:white;">TAB으로 보기 </h3>
		<ul class="nav nav-tabs">
			<c:forEach var="i" items="${list}" varStatus="status">
				<li <c:if test="${status.first}"> class="active"</c:if>><a data-toggle="tab" href="#menu${i.name}">${i.name}</a></li>
			</c:forEach>
		</ul>

		<div class="tab-content">
			<c:forEach var="i" items="${list}" varStatus="status">
				<div id="menu${i.name}" class="tab-pane fade <c:if test="${status.first}">in active </c:if>">
					<h3>${i.name}</h3>
	  <p><span class=""></span>정보-:<strong>${i.info}</strong> </p>
      <p><span class=""></span>가격-:<strong>${i.price}</strong> </p>
      <p><span class=""></span>CPU-<strong>${i.cpu}</strong> </p>
      <p><span class=""></span>GPU-<strong>${i.gpu}</strong> </p>
				</div>
			</c:forEach>

		</div>


	</div>







<%@ include file="../inc/footer.jsp"%>
   
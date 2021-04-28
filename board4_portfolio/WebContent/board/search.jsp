<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include  file="/inc/header.jsp" %>

<!-- 보드 검색 기능  -->
<!-- 보드 검색 기능  -->
<!-- 보드 검색 기능  -->

	
	<div class="container result"   style="margin-top:5%; min-height:500px">
		<table class="table table-striped">
<thead>
			<tr><th scope="col">NO</th><th scope="col">TITLE</th>
			      <th scope="col">WRITER</th><th scope="col">DATE</th><th scope="col">HIT</th></tr>
		</thead>
			<tbody>
	
			
			</tbody>
		</table>
	</div>
	<script>
	//서치버튼을 클릭하면 url에 bsearch로 보내주고 btitle데이터 값을 받아온다
		$(function(){
			//alert(  $("#btitle").val()  );
				$.ajax({
					url:"${pageContext.request.contextPath}/Bsearch",
					type:"get",
					dataType: "json",
					//btitle 데이터를 받아서 처리   "" 해줘야 텍스트로 같이 정보 받아오
					data:{ "btitle" : "<%=request.getParameter("btitle")%>" },
					success:function(data){
						
						console.log(data);
						console.log(data[0]);
						console.log(data[0].bitltle);
					 	 for(var a = 0; a < data.length; a++){
					 		
					 	<%-- 	<td><a href="<%=request.getContextPath()%>/detail.do?bno=${dto.bno}"></a></td>  --%>
							var row=$("<tr>").append($("<td>").html(data[a].bno))
							                 
							                 //.append($("<td>").html(data[a].bpass))
							                 .append($("<td>").html('<a href="<%=request.getContextPath()%>/detail.do?bno='+data[a].bno +'">'+data[a].btitle+'</a>'))
							                 .append($("<td>").html(data[a].bname))
							                 //.append($("<td>").html(data[a].bcontent))
							                 .append($("<td>").html(data[a].bdate))
							                 .append($("<td>").html(data[a].bhit))
							                 //.append($("<td>").html(data[a].bip))
							                 //.append($("<td>").html(data[a].img));
							$(".result tbody").append(row);
						}  
					},
					error:function(xhr, textStatus, errorThrown){
						$(".result tbody").html(textStatus+"(HTTP-" + xhr.status + "/" + errorThrown);
					}
				});
			
		});
			
	</script>
	






















<%@ include  file="/inc/footer.jsp" %>   
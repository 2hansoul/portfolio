<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="/inc/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  END HEADER -->
<!--  END HEADER -->



<div class="container"   style="margin-top:5%; min-height:500px">
	<h3 style="color:blue; border:1px;" >COMPUTER</h3>
	<table  class="table table-striped">
		<caption></caption>
		<thead>
			<tr><th scope="col">NO</th>
			<th scope="col">TITLE</th>
			  <th scope="col">WRITER</th>
			      
			      
			<th scope="col">DATE</th><th scope="col">HIT</th></tr>
		</thead>
		<tbody>
		<c:set var="total" value="${list.size()}"/>
		<c:forEach var="dto" items="${list}" varStatus="status">
 	      <tr>
 	      <td>${pageTotal-status.index-pstartno}</td>
 	      <td><a href="<%=request.getContextPath()%>/detail.do?bno=${dto.bno}">${dto.btitle }</a></td>
 	      <td>${dto.bname}</td>
 	      <td>${dto.bdate}</td>
 	      <td>${dto.bhit}</td>
 	      </tr>
 	      </c:forEach>
		</tbody>
		<tfoot>
<!-- 하단네비 설정     하단네비 시작페이지       :${start}/하단페이지               :${end}  -->
  <!--   힌트 1. 시작페이지가 bottomlist보다 크면 이전이 나오게 만들기  이전10(90) 11(100) 12 13-->
<!-- a태크 클릭시 1번은 0 /2번은 10/ 데이터 서블릿에 전송 
JSTLItemServlet?pstartno 던져줘야한다 계산식을
-->
<!-- q4) 하단 다음 설정   - 계산식은 서블릿에서 작성 -->
<tr>
<td colspan="5" class="text-center">
<ul class="pagination">
<c:if test="${start>=bottomlist}">
<li><a href="${pageContext.request.contextPath}/list.do?pstartno=${(start-2)*onepagelimit}">이전</a></li>
</c:if>
<c:forEach var="i"  begin="${start}" end="${end}" >
<li><a href="${pageContext.request.contextPath}/list.do?pstartno=${(i-1)*onepagelimit}">${i}</a></li>
</c:forEach>
<c:if test="${pageAll>end}">
     <li><a href="${pageContext.request.contextPath}/list.do?pstartno=${(end)*onepagelimit}">다음</a></li> 
</c:if>
</ul>
</td>
</tr>
</tfoot>
	</table>
	
	<p  class="text-right"><a href="<%=request.getContextPath() %>/write_view.do"   class="btn btn-danger">글쓰기</a></p>
</div>


<!-- 보드 검색 기능  -->
<!-- 보드 검색 기능  -->
<!-- 보드 검색 기능  -->
<div class="container text-center">
	<input type="text" name="btitle" id="btitle"/>
	<input type="button" value="검색" id="searchbtn" name="searchbtn" class="btn btn-info"/>
	
	<div class="form-group result">
	<h3>검색</h3>
		<table class="table table-striped">

			<tbody>
	
			
			</tbody>
		</table>
	</div>
	<script>
	//서치버튼을 클릭하면 url에 bsearch로 보내주고 btitle데이터 값을 받아온다
		$(function(){
			$("#searchbtn").click(function(){
				//alert(  $("#btitle").val()  );
				$.ajax({
					url:"${pageContext.request.contextPath}/Bsearch",
					type:"get",
					dataType: "json",
					//btitle 데이터를 받아서 처리
					data:{ "btitle" :  $("#btitle").val() },
					success:function(data){
						console.log(data);
						console.log(data[0]);
						console.log(data[0].bno);
					 	 for(var a = 0; a < data.length; a++){
	<%--  <td><a href="<%=request.getContextPath()%>/detail.do?bno=${dto.bno}"></a></td>  --%>
							var row=$("<tr>").append($("<td>").html(data[a].bno))
							                 .append($("<td>").html(data[a].bname))
							                 .append($("<td>").html(data[a].bpass))
							                 .append($("<td>").html(data[a].btitle))
							                 .append($("<td>").html(data[a].bcontent))
							                 .append($("<td>").html(data[a].bdate))
							                 .append($("<td>").html(data[a].bhit))
							                 .append($("<td>").html(data[a].bip))
							                 .append($("<td>").html(data[a].img));
							$(".result tbody").append(row);
						}  
					},
					error:function(xhr, textStatus, errorThrown){
						$(".result tbody").html(textStatus+"(HTTP-" + xhr.status + "/" + errorThrown);
					}
				});
			});
		});
			
	</script>
	</div>

<!-- END FOOTER -->
<!-- END FOOTER -->
<%@ include  file="/inc/footer.jsp" %>
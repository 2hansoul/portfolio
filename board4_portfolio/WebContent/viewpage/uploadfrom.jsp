<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container panel panel-info">
<h3 class="panel-heading">업로드 </h3>
<form action="${pageContext.request.contextPath}/create.vi" method="post"  enctype="multipart/form-data">
<fieldset>
<div class="form-group">
<label for="name">이름</label>
<input type="text"  name="name"   id="name"  class="form-control"/>
</div>
<div class="form-group">
<label for="info">설명</label>
<input type="text"  name="info"   id="info"  class="form-control"/>
</div>
<div class="form-group">
<label for="price">가격</label>
<input type="number"  name="price"   id="price"  class="form-control"/>
</div>
<div class="form-group">
<label for="img">파일업로드</label>
<input type="file"  name="img"   id="img"  class="form-control"/>
</div>
<div class="form-group">
<label for="cpu">CPU</label>
<input type="text"  name="cpu"   id="cpu"  class="form-control"/>
</div>
<div class="form-group">
<label for="gpu">GPU</label>
<input type="text"  name="gpu"   id="gpu"  class="form-control"/>
</div>
<div class="form-group">
<input type="submit" value="전송"  class="form-control"/>
</div>

</fieldset>
</form>
</div>

</body>

</html>
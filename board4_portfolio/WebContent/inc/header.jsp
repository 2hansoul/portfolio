<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com -->
  <title>COMPUTER</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  body {
    font: 400 15px Lato, sans-serif;
    line-height: 1.8;
    color: #818181;
  }
  h2 {
    font-size: 24px;
    text-transform: uppercase;
    color: #303030;
    font-weight: 600;
    margin-bottom: 30px;
  }
  h4 {
    font-size: 19px;
    line-height: 1.375em;
    color: #303030;
    font-weight: 400;
    margin-bottom: 30px;
  }  
  .jumbotron {
    background-color: #f4511e;
    color: #fff;
    padding: 100px 25px;
    font-family: Montserrat, sans-serif;
  }
  .container-fluid {
    padding: 60px 50px;
  }
  .bg-grey {
    background-color: #f6f6f6;
  }
  .logo-small {
    color: #f4511e;
    font-size: 50px;
  }
  .logo {
    color: #f4511e;
    font-size: 200px;
  }
  .thumbnail {
    padding: 0 0 15px 0;
    border: none;
    border-radius: 0;
  }
  .thumbnail img {
    width: 100%;
    height: 100%;
    margin-bottom: 10px;
  }
  .carousel-control.right, .carousel-control.left {
    background-image: none;
    color: #f4511e;
  }
  .carousel-indicators li {
    border-color: #f4511e;
  }
  .carousel-indicators li.active {
    background-color: #f4511e;
  }
  .item h4 {
    font-size: 19px;
    line-height: 1.375em;
    font-weight: 400;
    font-style: italic;
    margin: 70px 0;
  }
  .item span {
    font-style: normal;
  }
  .panel {
    border: 1px solid #f4511e; 
    border-radius:0 !important;
    transition: box-shadow 0.5s;
  }
  .panel:hover {
    box-shadow: 5px 0px 40px rgba(0,0,0, .2);
  }
  .panel-footer .btn:hover {
    border: 1px solid #f4511e;
    background-color: #fff !important;
    color: #f4511e;
  }
  .panel-heading {
    color: #fff !important;
    background-color: #f4511e !important;
    padding: 25px;
    border-bottom: 1px solid transparent;
    border-top-left-radius: 0px;
    border-top-right-radius: 0px;
    border-bottom-left-radius: 0px;
    border-bottom-right-radius: 0px;
  }
  .panel-footer {
    background-color: white !important;
  }
  .panel-footer h3 {
    font-size: 32px;
  }
  .panel-footer h4 {
    color: #aaa;
    font-size: 14px;
  }
  .panel-footer .btn {
    margin: 15px 0;
    background-color: #f4511e;
    color: #fff;
  }
  .navbar {
    margin-bottom: 0;
    background-color: #f4511e;
    z-index: 9999;
    border: 0;
    font-size: 12px !important;
    letter-spacing: 4px;
    border-radius: 0;
    font-family: Montserrat, sans-serif;
  }
  .navbar li a, .navbar .navbar-brand {
    color: #333;
  }
  .navbar-nav li a:hover, .navbar-nav li.active a {
    color: #f4511e !important;
    background-color: #fff !important;
  }
  .navbar-default .navbar-toggle {
    border-color: transparent;
    color: #fff !important;
  }
  footer .glyphicon {
    font-size: 20px;
    margin-bottom: 20px;
    color: #f4511e;
  }
  .slideanim {visibility:hidden;}
  .slide {
    animation-name: slide;
    -webkit-animation-name: slide;
    animation-duration: 1s;
    -webkit-animation-duration: 1s;
    visibility: visible;
  }
  @keyframes slide {
    0% {
      opacity: 0;
      transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      transform: translateY(0%);
    }
  }
  @-webkit-keyframes slide {
    0% {
      opacity: 0;
      -webkit-transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      -webkit-transform: translateY(0%);
    }
  }
  @media screen and (max-width: 768px) {
    .col-sm-4 {
      text-align: center;
      margin: 25px 0;
    }
    .btn-lg {
      width: 100%;
      margin-bottom: 35px;
    }
  }
  @media screen and (max-width: 480px) {
    .logo {
      font-size: 150px;
    }
  }
  /* 수정된 부분 */
  .mymain { margin-top: 5%; }
  .myhidden{ position:absolute; left:-9999%; width:1px; height:1px; overflow:hidden;
            font-size:0; line-height:0; }
            
   .my1.navbar ,  .my2.navbar  ,  .my3.navbar{
	    margin-bottom: 0;
	    background-color: white;       
    }  
	.my2 #btitle {
	    border-radius: 0;
	    border: 0 none;
	    border-bottom: 3px solid #135dba; 
	}
	nav.navbar.navbar-default.my2 a, nav.navbar.navbar-default.my2 input {
	    margin-top: 55px;
	} 
	#logo{  color:#135dba;   font-weight:bold;  }  
	
	nav.navbar.navbar-default.my3 {
	    background: #135dba;
	}
	#myNavbar  .navbar-default .navbar-nav>li>a {  color:white; }
	.my1 .navbar-default .navbar-nav>li>a {color:#333; }
	.modal-content {
    z-index: 10;
}
  </style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
 
<div style="position:relative; z-index:2">
 
<div  style="border-bottom:1px solid #ccc">
<nav class="navbar navbar-default  my1">
  <div class="container">
    <div class="collapse navbar-collapse" >
      <ul class="nav navbar-nav navbar-right">
   <%  
         String midsession= (String)session.getAttribute("mid");
         if(midsession!=null){  
      %>
      <li><a href="<%=request.getContextPath()%>/login_page.signup"><%=midsession %></a></li> 
      <li><a href="<%=request.getContextPath()%>/signup/logout.jsp">logout</a></li>
      
      <% }else{ %>
             <li><a href="<%=request.getContextPath()%>/MsignupAgree.signup">sign</a></li>
            <li><a href="<%=request.getContextPath()%>/login.signup">LOGIN</a></li>
            <li><a href="<%=request.getContextPath()%>/viewpage/uploadfrom.jsp" >upload</a></li>
      <% } %>   
      </ul>
    </div>
  </div>
</nav>  
</div>
<!-- 				 -->
<!-- 				 -->
<!-- 				 -->
<!-- 				 -->
<div>
<nav class="navbar navbar-default  my2">
  <div class="container">
	<div class="col-sm-3">
      <a class="navbar-brand"   id="logo"  href="<%=request.getContextPath()%>/uploadList1.vi">
      <img src="<%=request.getContextPath()%>/main/images/main.jpg" style="width: 50%;
    margin-top: -59px;"/></a>
     

    </div>  
   
	<div class="col-sm-5">
	
		<input type="text" name="btitle" id="btitle" placeholder="컴퓨터 입력해보세요 "  class="form-control"/> 
	
	</div>
	
	<div class="col-sm-1"> 
		<input type="button" value="검색" id="searchbtn" name="searchbtn" class="btn btn-info"/>
 
	   <!-- a태그를 클릭하면 $타이틀에 있는 값을 로케이션.href	 -->
	   <script>
	   $(function(){
		  $("#searchbtn").click(function(){
			 location.href="<%=request.getContextPath()%>/board/search.jsp?btitle=" + $("#btitle").val(); 
		  });  
	   });
	   </script>
	</div>
	
	<div class="col-sm-3">
	<!--Carousel  -->
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      
      
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <a href="<%=request.getContextPath()%>/main/images/righttopmodel.jpg">
        <img src="<%=request.getContextPath()%>/main/images/TopRight.jpg" />
        </a>
      </div>

      <div class="item">
       <a href="<%=request.getContextPath()%>/main/images/righttopmodel2.jpg">
        <img src="<%=request.getContextPath()%>/main/images/righttop.jpg" />
       </a>
      </div>
    
      
    
    
      
    </div><!--<div class="carousel-inner">  -->

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
	
	</div>
  </div>
</nav>  
</div>
 
<!-- 				 -->
<!-- 				 -->
<!-- 				 -->
<!-- 				 -->
<div>
<nav class="navbar navbar-default  my3">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav"  >
      <li><a href="<%=request.getContextPath() %>/list.do"  style="color:white">BOARD</a></li>
      <li><a href="<%=request.getContextPath()%>/main/api003_kakao-map.jsp" title="kakaomap"   style="color:white">MAP</a></li>
      <li><a href="<%=request.getContextPath() %>/uploadList.vi"  style="color:white">요거 어떄?</a></li>
      <li><a href="<%=request.getContextPath() %>/viewpage/mail.jsp"  style="color:white">고객센터</a></li>
      </ul>
    </div>
  </div>

 
</nav>
</div> 
</div>  


<!--           HEADER              -->
<!--           HEADER              -->
<!--           HEADER              -->
<!--           HEADER              -->
<!--           HEADER              -->
<!--           HEADER              -->
<!--           HEADER              -->
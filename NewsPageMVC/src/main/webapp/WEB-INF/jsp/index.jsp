<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Khoa Công Nghệ Thông Tin</title>

	<!-- Bootstrap core CSS -->
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	
	<!-- 
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	-->
	
</head>

<body>
<jsp:include page="_header.jsp" />
<div class="container">
<jsp:include page="_menu.jsp" />

			<div id="slider">
				  <figure>
					    <img src="/NewsPageMVC/resources/img/slide1.jpg">
					    <img src="/NewsPageMVC/resources/img/slide2.jpg">
					    <img src="/NewsPageMVC/resources/img/slide3.jpg">
				  </figure>
			</div>




<!--  		<div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
		<div class="col-md-6 px-0">
			<h1 class="display-4 font-italic">Trợ lí đào tạo<span class=""><b></span></h1>
			<h2 class="text-warning">Học viện Nông nghiệp Việt Nam</h2>
			<p class="my-3" style="color: rgb(213,213,213);">
				slideshow
			</p>
		</div>
		</div> -->
		<br>
<!-- 		<h5>Faculties</h5>
		<hr>
		<div class="d-flex ">
			<a class="tag col-2" href="category/Điểm rèn luyện">Điểm rèn luyện</a>
			<a class="tag col-2" href="category/KLTN & TTCN">KLTN & TTCN</a>
			<a class="tag col-2" href="category/Học bổng">Học bổng</a>
			<a href="#">All genres</a>
		</div> -->
	
		<br><br>
 		
 		<div class="row">
		<div class="col-md-8 blog-main">
			<h4 class="pb-3 mb-4 font-italic border-bottom">Giới thiệu</h4>
				Khoa Công nghệ thông tin (CNTT) – Học viện Nông nghiệp Việt Nam được thành lập ngày 10/10/2005. 
				Trong suốt chặng đường phát triển, khoa Công nghệ thông tin đã có những thành tựu đáng ghi nhận
		</div>
		
		
		
	
	<main role="main" class="container">
		<div class="row">
		<div class="col-md-8 blog-main">
		<br><br>
			<h4 class="pb-3 mb-4 font-italic border-bottom">Học phần</h4>
			<ol class="list-unstyled mb-0">
				<li class="col-12">
				<a class="text-dark" href="/NewsPageMVC/ttcn/list/">Danh sách đăng kí học phần Thực tập chuyên ngành</a>
				</li><br>
				<li class="col-12">
				<a class="text-dark" href="/NewsPageMVC/kltn/list/">Danh sách đăng kí học phần Khóa luận tốt nghiệp</a>
				</li><br>			
			</ol>
		</div>
		
	
<!-- 		<aside class="col-md-4 blog-sidebar">
			<div class="p-3 mb-3 bg-light rounded">
			<h4 class="font-italic">About</h4>
			<p class="mb-0"><em>Vietnam National University of Agriculture (VNUA)</em> 
			is a key and leading national university in human resource training and scientific research in agriculture and rural development, 
			becoming more and more diversified in fields of study with ever increasing prestige among the higher education system of Vietnam.</p>
			</div>
	
			<div class="p-3">
			<h4 class="font-italic">Oldest</h4>
			<ol class="list-unstyled mb-0">
				<li><a href="#">The Alchemist</a></li>
				<li><a href="#">The Subtile art of not giving a f*ck</a></li>
				<li><a href="#">Who's Adil</a></li>
				<li><a href="#">The Alchemist</a></li>
				<li><a href="#">The Subtile art of not giving a f*ck</a></li>
				<li><a href="#">Who's Adil</a></li>
				<li><a href="#">The Alchemist</a></li>
				<li><a href="#">The Subtile art of not giving a f*ck</a></li>
				<li><a href="#">Who's Adil</a></li>
			</ol>
			</div>
		</aside> -->
		</div>
	</main>
</div>
	
<jsp:include page="_footer.jsp" />
</body>
</html>
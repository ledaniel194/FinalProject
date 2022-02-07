<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style-home.css">
<title>Home Page</title>
</head>


<body>
<!-- NAVIGATION BAR  -->
	<jsp:include page="navigationBar.jsp"></jsp:include>
	<header id="landingPage" style="background-image: url('image/room.jpg');">
		<div class="landingPageContent">
			<div class="container">
				<div class="row">
					<div class="col-6">
						<p>MINIMAL FURNITURE</p>
						<h1>
							WITHIN A SPACE,</br>IT'S A LIFESTYLE
						</h1>
						<p>Interior design is all about bringing a better, more
							comfortable lifestyle into your area of living. It is not an easy
							work, but it is possible when we are here.</p>
						<button type="button" class="btn btn-secondary"> <a href="ProductServlet">EXPLORE
							MORE </a></button>
					</div>
				</div>
			</div>
		</div>
	</header>
	<%-- 
	<section id="byCategory">
		<div class="container-fluid">
				<div class="col-12">
					<h2>BY CATEGORY</h2>
				</div>
		</div>
			<c:forEach items="${categories}" var="category">
				<div class="categoryItem" >
					<img src="data:image/png;base64,${category.imageCode}"> 
					<h4>${category.name}</h4>
				</div>
			</c:forEach>		
	</section>	
	 --%>
	
	<div id="byRoom">
		<div class="container-fluid section-m1">
				<div class="col-12 justify-content-center">
					<h2>BY ROOM</h2>
					<h4>
					<a href="ProductServlet">
						<span class="click">Learn more ></span>
						</a>
					</h4>
				</div>
			</div>

			
			<c:forEach items="${rooms}" var = "room">
			<div class="rooms">
				<%-- <img src="data:image/png;base64,${room.imageCode}"> --%>
				<img src="${room.imageCode}">
				<div class="content">
				<a href ="ProductServlet?categoryId=${room.id}&roomName=${room.name}">
					<h2>| ${room.name}</h2>
					<button type="button" class="btn btn-warning">EXPLORE
							MORE</button>
							</a>
				</div>
			</div>
			</c:forEach>
		
	</div>
	<%-- <c:forEach items="${categories}" var="category">
			   ${category.name} - <img src="data:image/png;base64,${category.imageCode}"/> <br>
       
      </c:forEach> --%>
      
<iframe src="https://www.google.com/maps/d/u/0/embed?mid=1XSMF_wX_wKy3zE0R0U6tNRVEOiaeVdnM&ehbc=2E312F" width="640" height="480"></iframe></body>
</html>
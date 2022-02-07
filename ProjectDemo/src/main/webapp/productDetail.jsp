<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style-home.css">
<title>Product Details</title>
</head>


<body>


	<jsp:include page="navigationBar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>

	<section id="byCategory">
		<c:forEach items="${rooms}" var="room">
			<div class="col-md-3 col-sm-6 col-12 categoryItem"<%-- style="background-image: url('image/room${room.id}.jpg'); object-fit: cover;" --%>>
				<a href="ProductServlet?categoryId=${room.id}"><h4>${room.name}</h4></a>
			</div>

		</c:forEach>
		<div class="col-12">
			<a href="ProductServlet"><span class="click">Show all
					products</span> </a>
		</div>
	</section>

	<c:if test="${not empty productDetail}">
		<form method="get" action="CartServlet">
			<input hidden="true" name="productId" value="${productDetail.id}">
			<input hidden="true" name="command" value="ADD_TO_CART"> <input
				hidden="true" name="categoryId" value="${productDetail.categoryId}">
			<section class="container product section-p1">
				<div class="row">
					<div class="col-lg-5 col-md-12 col-12">
						<img class="img-fluid" src="${productDetail.imageCode}">
					</div>
					<div class="col-lg-6 col-md-12 col-12 info">
						<!-- <h6>Home / Clothes</h6> -->
						<h2>${productDetail.name}</h2>
						<p>${productDetail.description}</p>
						<hr>
						<h4>Size</h4>
						<h5>${productDetail.size}</h5>


						<h4>Color</h4>
						<h5>${productDetail.color}</h5>


						<h4>Country</h4>
						<h5>${productDetail.country}</h5>

						<h4>Material</h4>
						<h5>${productDetail.material}</h5>
						<hr>
						<h3>${productDetail.price}</h3>
						<input type="number" value="1" name="quantity">
						<div class="space">
							<%-- <a href="CartServlet?command=ADD_TO_CART&productId=${productDetail.id}&categoryId=${cateId}"> --%>
							<input type="submit"
								value="Add to Cart - $ ${productDetail.price} "<%-- onclick="window.location.href='CartServlet?command=ADD_TO_CART&productId=${productDetail.id}&categoryId=${cateId}'" --%>>
							<!-- </a> -->
						</div>
					</div>

				</div>
			</section>
		</form>
	</c:if>
	<section id="productList">

		<c:if test="${not empty product}">
			<div class="pro-container section-p1">
				<c:forEach items="${product}" var="productDetail">
					<%-- <form method = "post" action = "CartServlet">
			<input hidden="true" name="productId" value = "${productDetail.id}"> --%>
					<div class="pro">
						<%-- <a href="ProductServlet?productDetailId=${productDetail.id }"> --%>
						<img src="${productDetail.imageCode}">
						<div class="des">
							<c:if test="${empty productDetail.brand}">
								<h6>ZANUI</h6>
							</c:if>
							<h6>${productDetail.brand }</h6>
							<h3>${productDetail.name}</h3>
							<h5>${productDetail.price }AUD</h5>
							<%-- 	<a href="CartServlet?command=ADD_TO_CART&productId=${productDetail.id}&categoryId=${cateId}"><h4>$ ${productDetail.price} AUD</h4> </a> --%>
							<a href="ProductServlet?productDetailId=${productDetail.id }"><h4>Add
									to Cart</h4></a>
						</div>

						<!-- </a> -->
					</div>
					<%-- <input type="button" value = "Add to Cart"
				onclick="window.location.href='CartServlet?command=ADD_TO_CART&productId=${productDetail.id}';"> --%>
					<!-- </form> -->
				</c:forEach>
			</div>
		</c:if>



		<div>
			<ul>
				<c:if test="${cateId != null}">
					<c:if test="${tag > 1}">
						<li class="page-item disabled"><a
							href="ProductServlet?categoryId=${cateId}&index=${tag-1}">Previous</a></li>
					</c:if>
					<c:forEach begin="1" end="${endPage}" var="i">

						<a
							<%-- class="${tag == i?"active":""}" --%> href="ProductServlet?categoryId=${cateId}&index=${i}">${i}</a>

					</c:forEach>
					<c:if test="${tag < endPage}">
						<a href="ProductServlet?categoryId=${cateId}&index=${tag+1}">Next</a>
					</c:if>
				</c:if>

				<c:if test="${cateId == null}">
					<c:if test="${tag > 1}">
						<li class="page-item disabled"><a
							href="ProductServlet?index=${tag-1}">Previous</a></li>
					</c:if>
					<c:forEach begin="1" end="${endPage}" var="i">

						<a
							<%-- class="${tag == i?"active":""}" --%> href="ProductServlet?index=${i}">${i}</a>

					</c:forEach>
					<c:if test="${tag < endPage}">
						<a href="ProductServlet?index=${tag+1}">Next</a>
					</c:if>
				</c:if>
			</ul>
		</div>
	</section>

</body>
</html>
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
<div class="title section-p1">
<h1>Cart Summary:</h1>
</div>

<c:if test="${empty cart}">
<h5>There is no item in cart at the moment.</h5>

<a href="ProductServlet">CONTINUE SHOPPING</a>
</c:if>


<c:if test="${not empty cart}">
<div id="cart" class="section-p1">
<form method="get" action="CartServlet">
<div class="detail">
<!-- <input hidden="true" name ="command" value="SUBMIT_CART"> -->

<c:forEach var="item" items="${cart.getProducts()}"  varStatus="status">

<table>
<tr>
<td>${status.count}</td>
<td> <img src="${item.key.imageCode}" style="width: 50px"> </td>
<td>${item.key.name}</td>
<td class="right">
 <a href="CartServlet?command=DECREASE&productId=${item.key.id}"> 
- </a> ${item.value} <a href="CartServlet?command=INCREASE&productId=${item.key.id}"> + </a> 
 </td>
 <td class="right">${item.key.price}</td>
 <td class="right">
 <a href="CartServlet?command=REMOVE&productId=${item.key.id}"><span class="click small">Remove</span></a>
</td>


</tr>

</table>

</c:forEach>
</div>
<div class="summary">
<h3>Order Summary</h3>
<table>
<tr>
<td class="left"><h4>Subtotal</h4></td>
<td class="right"><h4>${subtotal}</h4>
</tr>
<tr>
<td><h3>Subtotal</h3></td>
<td class="right">${subtotal }</td>
</tr>
</table>
</div>
<div class="space">
<a href="CartServlet?command=SUBMIT_CART"><input type="submit" value="Submit Cart"></a>
</div>
<!-- <input type="button" value="Check out"></input> -->
</form>
</div>
</c:if>



</body>
</html>
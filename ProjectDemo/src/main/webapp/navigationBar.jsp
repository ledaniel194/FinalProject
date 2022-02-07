<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="HomeServlet">FURNIX</a>
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			
			<c:forEach items="${rooms}" var="room">
			<li class="nav-item">
        <a class="nav-link" href="ProductServlet?categoryId=${room.id}">
          | ${room.name}
        </a>
        </li>
      </c:forEach>
     
			
		
				
			</ul><c:if
						test="${not empty sessionScope.me}">
						<a class="nav-link" href="LoginServlet?command=logout">|
							Logout, ${sessionScope.me.firstName} </a>
					</c:if> <c:if test="${empty sessionScope.me}">
						<a class="nav-link" href="LoginServlet?command=login">Login</a>
					</c:if>
			<a href="CartServlet?command=VIEW_CART">Cart(${sessionScope.cart.products.size()})</a>
		</div>
	</nav> 
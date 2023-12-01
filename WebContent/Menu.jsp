<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="Home">HiepShoes</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end"
			id="navbarsExampleDefault">
			<ul class="navbar-nav m-auto">
				<c:if test="${sessionScope.acc.isadmin == 1}">
					<li class="nav-item"><a class="nav-link" href="editaccount">Quản lý tài khoản</a></li>
				</c:if>
				<c:if test="${sessionScope.acc.isshell == 1}">
					<li class="nav-item"><a class="nav-link" href="manager">Quản lý sản phẩm</a></li>
				</c:if>
				<c:if test="${sessionScope.acc != null}">
					<li class="nav-item"><a class="nav-link" href="#"> Hello
							${sessionScope.acc.user}</a></li>
				</c:if>
				<c:if test="${sessionScope.acc != null}">
					<li class="nav-item"><a class="nav-link" href="logout">Đăng
							xuất</a></li>
				</c:if>
				<c:if test="${sessionScope.acc == null}">
					<li class="nav-item"><a class="nav-link" href="Login.jsp">Đăng
							nhập/ Đăng ký</a></li>
				</c:if>
			</ul>

			<form action="search" method="get" class="form-inline my-2 my-lg-0">
				<div class="input-group input-group-sm">
					<input name="txt" value="${txtSearch}" type="text"
						class="form-control" aria-label="Small"
						aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
					<div class="input-group-append">
						<button type="submit" class="btn btn-secondary btn-number">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<a class="btn btn-success btn-sm ml-3" href="Cart.jsp"> <i
					class="fa fa-shopping-cart"></i> Giỏ hàng <span
					class="badge badge-light">${sessionScope.cart.size() }</span>
				</a>
			</form>
		</div>
	</div>
</nav>
<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">Shop giày Việt chất lượng cao</h1>
		<p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn
			10 năm cung cấp các sản phầm giày chính hãng sản xuất tại Việt Nam</p>
	</div>
</section>
<!--end of menu-->

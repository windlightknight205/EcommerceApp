

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
	<div class="card bg-light mb-3">
		<div class="card-header bg-primary text-white text-uppercase">
			<i class="fa fa-list"></i> Categories
		</div>
		<ul class="list-group category_block">
			<c:forEach items="${listC}" var="o">
				<li class="list-group-item text-white ${tag == o.cid ? "active" :"" }"><a
					href="category?cid=${o.cid}">${o.getName()}</a></li>
			</c:forEach>

		</ul>
	</div>
	<div class="card bg-light mb-3">
		<div class="card-header bg-success text-white text-uppercase">Sản
			phẩm mới nhất</div>
		<div class="card-body">
			<img class="img-fluid" src="${p.image}" />
			<h5 class="card-title">${p.name}</h5>
			<p class="card-text">${p.title}</p>
			<p class="bloc_left_price">${p.price}</p>
		</div>
	</div>
	                     <ul class="pagination">
    <li class="page-item "><a class="page-link" href="paging?action=previous&index=${page-1}">Previous</a></li>
    <c:forEach var = "i" begin = "1" end = "${pc}">
    <li class="page-item ${page==i ? "active" : "" }"><a class="page-link" href="paging?&action=paging&index=${i}">${i}</a></li>  
    </c:forEach>  
    <li class="page-item"><a class="page-link" href="paging?&action=next&index=${page+1}">Next</a></li>
  </ul>
</nav>
</div>
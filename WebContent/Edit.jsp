<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap CRUD Data Table for Database with Modal Form</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/manager.css" rel="stylesheet" type="text/css" />
<style>
img {
	width: 200px;
	height: 120px;
}

.modal-header {
	width: 50%;
	margin: auto;
}

.modal-body {
	width: 50%;
	margin: auto;
}

.modal-footer {
	width: 50%;
	margin: auto;
}
</style>
<form action="update" method="post">
	<div class="modal-header">
		<h2 class="modal-title">
			<b>Add Product</b>
		</h2>
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">&times;</button>
	</div>
	<div class="modal-body">
		<div class="form-group">
			<label>Id</label> <input name="id" type="text"
			 class="form-control" value="${p.id}" required readonly="readonly">
		</div>
		<div class="form-group">
			<label>Name</label> <input name="name" type="text"
				class="form-control" value="${p.name}" required>
		</div>
		<div class="form-group">
			<label>Image</label> <input name="image" type="text"
				class="form-control" value="${p.image}" required>
		</div>
		<div class="form-group">
			<label>Price</label> <input name="price" type="text"
				class="form-control" value="${p.price}"required>
		</div>
		<div class="form-group">
			<label>Title</label>
			<textarea name="title" class="form-control" value="${p.title}" required></textarea>
		</div>
		<div class="form-group">
			<label>Description</label>
			<textarea name="description" class="form-control" value="${p.description}" required></textarea>
		</div>
		<div class="form-group">
			<label>Category</label> <input name="category" type="text"
				class="form-control" required>
		</div>

	</div>
	<div class="modal-footer">
		<input type="submit" class="btn btn-success" value="Add">
	</div>
</form>

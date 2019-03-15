<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
* {
	box-sizing: border-box;
}

html {
	height: 100%;
}

body {
	padding: 0;
	margin: 0;
	font-family:georgia,garamond,serif;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">Product Store</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="list" class="glyphicon glyphicon-home"> HOME</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="logout"><span
					class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		</ul>
	</div>
	</nav>
	<form class="form-horizontal" action="saveProd" method="post">
		<input type="hidden" name="Id" value="${temp.getId()}">
		<div class="form-group">
			<label class="control-label col-sm-2">Vendor ID :</label>
			<div class="col-sm-10">
				<input type="text" name="vid" value="${temp.getVid()}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Name :</label>
			<div class="col-sm-10">
				<input type="text" name="name" value="${temp.getName()}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Category :</label>
			<div class="col-sm-10">
				<input type="text" name="category" value="${temp.getCategory()}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Description :</label>
			<div class="col-sm-10">
				<input type="text" name="desc" value="${temp.getDesc()}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Price :</label>
			<div class="col-sm-10">
				<input type="text" name="price" value="${temp.getPrice()}">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
		</div>		
	</form>
</body>
</html>
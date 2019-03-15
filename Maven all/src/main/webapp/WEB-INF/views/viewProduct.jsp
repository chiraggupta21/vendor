<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
<style>
@import
	url(https://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100)
	;
/* Remove the navbar's default margin-bottom and rounded borders */
* {
	box-sizing: border-box;
}

html {
	height: 100%;
}

body {
	padding: 0;
	margin: 0;
	font-family: georgia, garamond, serif;
}

.footer {
	background-color: #555;
	color: white;
	padding: 15px;
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	text-align: center;
}

.uppercase {
	text-transform: uppercase;
}
</style>
</head>
<body>
	<div class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">Product Store</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="list"
					class="glyphicon glyphicon-home"> HOME</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="uppercase" style="color: WHITE"><h3
						class="glyphicon glyphicon-user">Welcome ${ pageContext.request.userPrincipal.name}
					</h3></li>
				<li><a href="logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
		</div>
	</div>
	<div class="container-fluid">

		<div class="col-sm-3 uppercase text-center">
			<h3>${temp.getName()}</h3>
		</div>
		<div class="col-sm-9 text-left">
			<div class="row">
				<label class="control-label col-sm-2">Id : </label>
				<label class="control-label col-sm-2">${temp.getId()}</label><br>
			</div>
			<div class="row">
				<label class="control-label col-sm-2">Description : </label>
				<label class="control-label col-sm-2">${temp.getDesc()}</label>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="footer">
				<p class="glyphicon glyphicon-copyright-mark">Akshay Katoch</p>
			</div>
		</div>
	</div>
</body>
</html>
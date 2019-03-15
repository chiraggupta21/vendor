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

div.table-title {
	display: block;
	margin: auto;
	padding: 10px;
	width: auto;
}

.table-title h3 {
	font-size: 30px;
	font-weight: 400;
	font-style: normal;
	font-family: "Roboto", helvetica, arial, sans-serif;
	text-transform: uppercase;
}

/*** Table Styles **/
.table-fill {
	background: white;
	border-radius: 5px;
	border-collapse: collapse;
	margin: auto;
	width: 100%;
}

th {
	padding: 10px;
	color: #d5dde5;
	background: #1b1e24;
	border-bottom: 4px solid #9ea7af;
	border-right: 1px solid #343a45;
}

th:first-child {
	border-top-left-radius: 3px;
}

th:last-child {
	border-top-right-radius: 3px;
	border-right: none;
}

tr {
	border-top: 1px solid #c1c3d1;
	border-bottom-: 1px solid #c1c3d1;
	color: #666b85;
}

tr:hover td {
	background: #4e5066;
	color: #ffffff;
	border-top: 1px solid #22262e;
}

tr:first-child {
	border-top: none;
}

tr:last-child {
	border-bottom: none;
}

tr:nth-child(odd) td {
	background: #ebebeb;
}

tr:nth-child(odd):hover td {
	background: #4e5066;
}

tr:last-child td:first-child {
	border-bottom-left-radius: 3px;
}

tr:last-child td:last-child {
	border-bottom-right-radius: 3px;
}

td {
	padding: 5px;
	background: #ffffff;
	text-align: left;
	vertical-align: middle;
	border-right: 1px solid #c1c3d1;
}

td:last-child {
	border-right: 0px;
}

th.text-left {
	text-align: left;
}

th.text-center {
	text-align: center;
}

th.text-right {
	text-align: right;
}

td.text-left {
	text-align: left;
}

td.text-center {
	text-align: center;
}

td.text-right {
	text-align: right;
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
		<div class="row">
			<div class="col-sm-3 text-left">
				<h3 class="uppercase">Welcome ${ pageContext.request.userPrincipal.name}</h3>
				<img
					src="https://upload.wikimedia.org/wikipedia/vi/b/bc/NaVi_LOGO.jpg"
					alt="Natus Vincere">
				<h3>Name : Natus Vincere</h3>
				<h3>Address : Spain</h3>
			</div>
			<div class="col-sm-7 text-left">
				<ul class="nav nav-tabs">
					<li class="active"><a href="/Maven-product/prod/list">Product</a></li>
					<li><a href="/Maven-product/vend/list">Vendor</a></li>
				</ul>
				<div class="tab-content">
					<div id="product" class="tab-pane fade in active">
						<button type="button" class="btn btn-success"
							onclick="window.location.href='addForm';return false;">Add
							Product</button>
						<div class="table-title">
							<h3>Product List</h3>
						</div>
						<table class="table-fill">
							<tr>
								<th class="text-left">ID</th>
								<th class="text-left">Name</th>
								<th class="text-left">Category</th>
								<th class="text-left">Price</th>
								<th class="text-left">Update/ Remove / View</th>
							</tr>
							<c:forEach var="temp" items="${products}">
								<c:url var="updateLink" value="/prod/updateForm">
									<c:param name="prodId" value="${temp.getId()}"></c:param>
								</c:url>
								<c:url var="deleteLink" value="/prod/delete">
									<c:param name="prodId" value="${temp.getId()}"></c:param>
								</c:url>
								<c:url var="viewLink" value="/prod/view">
									<c:param name="prodId" value="${temp.getId()}"></c:param>
								</c:url>
								<tr class="table-hover">
									<td class="text-left">${temp.getId()}</td>
									<td class="text-left">${temp.getName()}</td>
									<td class="text-left">${temp.getCategory()}</td>
									<td class="text-left">${temp.getPrice()}</td>
									<td class="text-left"><button type="button"
											class="btn btn-primary"
											onclick="window.location.href='${updateLink}' ;return false;">Update</button>
										<button type="button" class="btn btn-danger"
											onclick="window.location.href='${deleteLink}' ;return false;">Delete</button>
										<button type="button" class="btn btn-info"
											onclick="window.location.href='${viewLink}' ;return false;">View</button>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
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
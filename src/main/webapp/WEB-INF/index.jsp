<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	</head>

	<body>
		<div class="container">
			<h3>
				<a href="/">Add Product</a> |
				<a href="/categories/new">Add Category</a>
			</h3>
			<h1>New Product</h1>
			<form:form method="POST" action="/addProduct" modelAttribute="product">
				<form:label path="name">Name:<br>
					<form:input path="name" />
					<form:errors path="name" />
				</form:label><br>
				<form:label path="description">Desctription:<br>
					<form:textarea rows="2" cols="20" path="description" />
					<form:errors path="description" />
				</form:label><br>
				<form:label path="price">Price:<br>
					<form:input path="price" />
					<form:errors path="price" />
				</form:label><br>
				<input type="submit" class="btn btn-primary" value="Create" />
			</form:form>
		</div>
	</body>
</html>
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
			<h1>${product.name}</h1>

			<div class="row">
				<h3>Categories</h3>
				<div class="col-xs-6">
					<c:forEach items="${product.categories}" var="category">
						<p>${category.name}</p>
					</c:forEach>
				</div>
				<div class="col-xs-6">
					<form method="POST" action="/categoryPro/${product.id}">
						<label name="products">Add Products:
							<select name="category">
								<c:forEach items="${categories}" var="category">
									<option value="${category.id}">${category.name}</option>
								</c:forEach>
							</select>
						</label>
						<br>
						<input type="submit" class="btn btn-primary" value="Add" />
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
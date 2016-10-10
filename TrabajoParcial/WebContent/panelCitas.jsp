<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>SEGUROS FALABELLA</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Seguros Falabella</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="panelInspector.jsp">Inicio</a></li>
				<li><a href="panelClientes.jsp">Clientes</a></li>
				<li  class="active"><a href="panelCitas.jsp">Citas</a></li>
				<li><a href="panelCotizacion.jsp">Cotización</a></li>
				<li><a href="panelPoliza.jsp">Polizas</a></li>
				
				

			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>MANTENIMIENTO DE CITAS</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#" data-toggle="tab">Citas</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<p style="text-align: right;">
				<a href="agregarCitas.jsp" class="btn btn-success">Agregar</a>

			</p>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Cliente</th>
						<th>Inspector</th>
						<th>Fecha</th>
						<th>Hora</th>
						<th>Lugar</th>
						
					</tr>
				</thead>
				<tbody>



					<c:forEach var="p" items="${requestScope.lispeliculas}">
						<tr>
							<td>${p.id}</td>
							<td>${p.nombre}</td>
							<td>${p.precio}</td>
							<td>${p.stock}</td>
							<td>${p.imagen}</td>
							<td>${p.idcategoria.nombre}</td>
							<td width=350><a class="btn" href="readp?id=${p.id }">Detalle</a>
								&nbsp; <a class="btn btn-success" href="editp?id=${p.id}">Editar</a>
								&nbsp; <a class="btn btn-danger" href="removep?id=${p.id}">Eliminar</a>
					</c:forEach>

				</tbody>
			</table>
		</div>

		<div class="row">
			<c:if test="${!empty requestScope.mensaje}">
				<div>${requestScope.mensaje }</div>
			</c:if>
		</div>
	</div>
	<!-- /container -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>SEGUROS FALABELLA</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Seguros Falabella</a>
			</div>
			<ul class="nav navbar-nav">
					<li class="active"><a href="panelInspector.jsp">Inicio</a></li>
				<li  ><a href="panelClientes.jsp">Clientes</a></li>
				<li><a href="panelCitas.jsp">Citas</a></li>
				<li><a href="panelCotizacion.jsp">Cotización</a></li>
				<li><a href="panelPolizas.jsp">Polizas</a></li>
				
				
			</ul>
		</div>
	</nav>

	<div class="container">
		PANEL INSPECTOR
	</div>
	<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#" data-toggle="tab">Clientes</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<p style="text-align: right;">
				<a href="listCliente" class="btn btn-success">Agregar</a>

			</p>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRE</th>
						<th>APELLIDO</th>
						<th>DNI</th>
						<th>USUARIO</th>
						<th>CONTRASENIA</th>
					</tr>
				</thead>
				<tbody>



					<c:forEach var="p" items="${requestScope.listclientes}">
						<tr>
							<td>${p.idinspector}</td>
							<td>${p.nombre}</td>
							<td>${p.apellido}</td>
							<td>${p.dni}</td>
							<td>${p.usuario}</td>
							<td>${p.contrasenia}</td>
							<td width=350><a class="btn" href="readp?id=${p.idcliente }">Detalle</a>
								&nbsp; <a class="btn btn-success" href="editp?id=${p.idcliente}">Editar</a>
								&nbsp; <a class="btn btn-danger" href="removep?id=${p.idcliente}">Eliminar</a>
								</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

		<div class="row">
			<c:if test="${!empty requestScope.mensaje}">
				<div>${requestScope.mensaje }</div>
			</c:if>
		</div>

</body>
</html>


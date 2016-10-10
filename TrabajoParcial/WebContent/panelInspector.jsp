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
				<li   ><a href="panelClientes.jsp">Clientes</a></li>
				<li><a href="panelVehiculos.jsp">Vehiculos</a></li>
				<li class="active"><a href="panelInspector.jsp">Inspector</a></li>
				<li><a href="panelCitas.jsp">Citas</a></li>
				<li><a href="panelCotizacion.jsp">Cotización Inicial</a></li>
				<li><a href="panelAprobacion.jsp">Cotización Final</a></li>
				<li><a href="panelPoliza.jsp">Polizas</a></li>
				

			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>MANTENIMIENTO DE INSPECTOR</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#" data-toggle="tab">Inspector</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<p style="text-align: right;">
				<a href="agregarInspector.jsp" class="btn btn-success">Agregar</a>

			</p>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRES</th>
						<th>APELLIDOS</th>
						<th>DNI</th>
						<th>USUARIO</th>
						<th>CONTRASEÑA</th>
						<th>ACCIONES</th>
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
							<td width=350><a class="btn" href="readp?id=${p.idcliente}">Detalle</a>
								&nbsp; <a class="btn btn-success" href="editp?id=${p.idcliente}">Editar</a>
								&nbsp; <a class="btn btn-danger" href="removep?id=${p.idcliente}">Eliminar</a>
								</td></tr>
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
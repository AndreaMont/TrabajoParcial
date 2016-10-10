<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<title>SEGUROS FALABELLA</title>
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
				<li   class="active"><a href="panelClientes.jsp">Clientes</a></li>
				<li><a href="panelVehiculos.jsp">Vehiculos</a></li>
				<li><a href="panelInspector.jsp">Inspector</a></li>
				<li><a href="panelCitas.jsp">Citas</a></li>
				<li><a href="panelCotizacion.jsp">Cotización Inicial</a></li>
				<li><a href="panelAprobacion.jsp">Cotización Final</a></li>
				<li><a href="panelPoliza.jsp">Polizas</a></li>

			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>NUEVO CLIENTE</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="" data-toggle="tab">Clientes</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<h3>Agregar Clientes</h3>
		</div>
		<div class="row">
			<form class="form-horizontal" action="insertCliente" method="post">

				<div class="control-group">
					<label class="control-label">NOMBRE</label>
					<div class="controls">
						<input type="text" name="nombre" id="nombre"
							placeholder="Ingresar nombre" value="">
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">APELLIDO</label>
					<div class="controls">
						<input type="text" name="apellido" id="apellido"
							placeholder="Ingresar apellido" value="">
					</div>
				</div>

<div class="control-group">
					<label class="control-label">DNI</label>
					<div class="controls">
						<input type="text" name="dni" id="dni"
							placeholder="Ingresar DNI" value="">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">TELEFONO</label>
					<div class="controls">
						<input type="text" name="telefono" id="telefono"
							placeholder="Ingresar telefono" value="">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">FECHA NACIMIENTO</label>
					<div class="controls">
						<input type="text" name="fechaNacimiento" id="fecha"
							placeholder="Ingresar fecha" value="">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Usuario</label>
					<div class="controls">
						<input type="text" name="usuario" id="usuario"
							placeholder="Ingresar usuario" value="">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Contrasenia</label>
					<div class="controls">
						<input type="text" name="contrasenia" id="contrasenia"
							placeholder="Ingresar contraseña" value="">
					</div>
				</div>
				

				<div class="form-actions">
					<button type="submit" class="btn btn-success">Agregar</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn" href="panelClientes.jsp">Cancelar</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
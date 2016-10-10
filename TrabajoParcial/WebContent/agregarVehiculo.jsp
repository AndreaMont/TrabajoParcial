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
				<li ><a href="panelClientes.jsp">Clientes</a></li>
				<li   class="active"><a href="panelVehiculos.jsp">Vehiculos</a></li>
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
			<h3>NUEVO VEHICULO</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="" data-toggle="tab">Vehiculo</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<h3>Agregar Vehiculos</h3>
		</div>
		<div class="row">
			<form class="form-horizontal" action="insertVehiculo" method="post">

				<div class="control-group">
					<label class="control-label">MODELO</label>
					<div class="controls">
						<input type="text" name="modelo" id="modelo"
							placeholder="Ingresar modelo" value="">
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">MARCA</label>
					<div class="controls">
						<input type="text" name="marca" id="marca"
							placeholder="Ingresar marca" value="">
					</div>
				</div>

<div class="control-group">
					<label class="control-label">PLACA</label>
					<div class="controls">
						<input type="text" name="placa" id="placa"
							placeholder="Ingresar Placa" value="">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">TIPO DE CAJA</label>
					<div class="controls">
						<input type="text" name="tipoCaja" id="tipoCaja"
							placeholder="Ingresar tipo de caja" value="">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">AÑO</label>
					<div class="controls">
						<input type="text" name="anio" id="anio"
							placeholder="Ingresar año" value="">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">KILOMETRAJE</label>
					<div class="controls">
						<input type="text" name="kilometraje" id="kilometraje"
							placeholder="Ingresar kilometraje" value="">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">ESTADO</label>
					<div class="controls">
						<input type="text" name="estado" id="estado"
							placeholder="Ingresar estado" value="">
					</div>
				</div>
				

				<div class="form-actions">
					<button type="submit" class="btn btn-success">Agregar</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn" href="panelVehiculos.jsp">Cancelar</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
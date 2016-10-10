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
				<li  class="active"><a href="panelCitas.jsp">Citas</a></li>
				<li><a href="panelCotizacion.jsp">Cotización</a>
				
				<li><a href="panelCotizacion.jsp">Cotización Inicial</a>
				
				</li>
				<li><a href="panelCotizacion.jsp">Cotización Final</a>
				
				</li>
				</li>
				<li><a href="panelPoliza.jsp">Polizas</a></li>

			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>NUEVA CITA</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="panelc.html" data-toggle="tab">Citas</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<h3>Agregar Citas</h3>
		</div>
		<div class="row">
			<form class="form-horizontal" action="insertp" method="post">

				<div class="control-group">
					<label class="control-label">DIRECCION</label>
					<div class="controls">
						<input type="text" name="dirección" id="nombre"
							placeholder="Ingresar dirección" value="">
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">FECHA</label>
					<div class="controls">
						<input type="text" name="fecha" id="precio"
							placeholder="Ingresar fecha" value="">
					</div>
				</div>

				<!-- <div class="control-group">

					<label class="control-label">IMAGEN:</label>
					<div class="controls">
						<select name="imagen" id="imagen">
							<option value="breaking-bad">breaking-bad</option>
							<option value="dexter">dexter</option>
							<option value="family-guy">family-guy</option>
							<option value="friends">friends</option>
							<option value="gossip-girl">gossip-girl</option>
							<option value="homeland">homeland</option>
							<option value="how-i-met-your-mother">how-i-met-your-mother</option>
							<option value="marco-polo">marco-polo</option>
							<option value="modern-family">modern-family</option>
							<option value="skins">skins</option>
							<option value="suits">suits</option>
							<option value="supernatural">supernatural</option>
							<option value="the-office">the-office</option>

						</select>
					</div>

				</div>


				<div class="control-group">

					<label class="control-label">CATEGORIA:</label>
					<div class="controls">

						<select name="categoria" id="categoria">
							<c:forEach var="c" items="${requestScope.liscategorias}">
								<option value="${c.id}">${c.nombre}</option>
							</c:forEach>
						</select>


					</div>

				</div> -->

				<div class="form-actions">
					<button type="submit" class="btn btn-success">Agregar</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn" href="listp">Cancelar</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
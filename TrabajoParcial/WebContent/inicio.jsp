<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>SEGUROS FALABELLA</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="One Movies Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 




</script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/single.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="css/contactstyle.css" type="text/css"
	media="all" />
<link rel="stylesheet" href="css/faqstyle.css" type="text/css"
	media="all" />
<link href="css/medile.css" rel='stylesheet' type='text/css' />
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font-awesome.min.css" />
<!-- //font-awesome icons -->
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<link
	href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300'
	rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<link href="css/owl.carousel.css" rel="stylesheet" type="text/css"
	media="all">
<script src="js/owl.carousel.js"></script>
<script>
	$(document).ready(function() {
		$("#owl-demo").owlCarousel({

			autoPlay : 3000, //Set AutoPlay to 3 seconds

			items : 5,
			itemsDesktop : [ 640, 5 ],
			itemsDesktopSmall : [ 414, 4 ]

		});

	});
</script>
</head>

<body>
	<!-- header -->
	<div class="header">
		<div class="container">
			<div class="w3layouts_logo">
				<a href="index.html"><h1>
						Seguros<span> Falabella</span>
					</h1></a>
			</div>
		<!--  	<div class="w3_search">
				<form action="#" method="post">
					<input type="text" name="Search" placeholder="Search" required="">
					<input type="submit" value="Go">
				</form>
			</div>-->
			<div class="w3l_sign_in_register">
				<ul>
					<li><i class="fa fa-phone" aria-hidden="true"></i>615-6000</li>
					<li><a href="#" data-toggle="modal" data-target="#myModal">Iniciar
							Sesión</a></li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //header -->
	<!-- bootstrap-pop-up -->
	<div class="modal video-modal fade" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="myModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					Seguros Falabella
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<section>
					<div class="modal-body">
						<div class="w3_login_module">
							<div class="module form-module">
								<div class="toggle">
									<i class="fa fa-times fa-pencil"></i>
									<div class="tooltip">Regístrate</div>
								</div>
								<div class="form">
									<h3>Iniciar Sesión</h3>
									<form action="login" method="post">
										<input type="text" name="correo"
											placeholder="Usuario" required="">
										<input type="password" name="password"
											placeholder="Contraseña" required=""> <input
											type="submit" value="Iniciar Sesión">
									</form>
								</div>
								<div class="form">
									<h3>Registrarse</h3>
									<form action="register" method="post">
										<input type="text" name="nombre"
											placeholder="Nombres" required=""> <input
											type="text" name="apellido" placeholder="Apellidos"
											required=""> <input type="text" name="usuario"
											placeholder="Usuario" required="">
										<input type="password" name="password"
											placeholder="Contraseña" required=""> <input
											type="submit" value="Registrarse">
									</form>
								</div>
								<div class="cta">
									<a href="#">¿Olvidaste tu nombre de usuario o contraseña?</a>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	<script>
		$('.toggle').click(function() {
			// Switches the Icon
			$(this).children('i').toggleClass('fa-pencil');
			// Switches the forms  
			$('.form').animate({
				height : "toggle",
				'padding-top' : 'toggle',
				'padding-bottom' : 'toggle',
				opacity : "toggle"
			}, "slow");
		});
	</script>
	<!-- //bootstrap-pop-up -->
	<!-- nav -->
	<div class="movies_nav">
		<div class="container">
			<nav class="navbar navbar-default">
				<div class="navbar-header navbar-left">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-right"
					id="bs-example-navbar-collapse-1">
					<nav>
						<ul class="nav navbar-nav">
							<c:forEach var="c" items="${requestScope.liscategorias}">

								<li class="w3_home_act"><a href="editc?id=${c.id}">${c.nombre}</a></li>


							</c:forEach>
						</ul>

					</nav>
				</div>
			</nav>
		</div>
	</div>
	<!-- //nav -->
	<div class="general_social_icons">
		<nav class="social">
			<ul>
				<li class="w3_twitter"><a href="#">Twitter <i
						class="fa fa-twitter"></i></a></li>
				<li class="w3_facebook"><a href="#">Facebook <i
						class="fa fa-facebook"></i></a></li>
				<li class="w3_dribbble"><a href="#">Dribbble <i
						class="fa fa-dribbble"></i></a></li>
				<li class="w3_g_plus"><a href="#">Google+ <i
						class="fa fa-google-plus"></i></a></li>
			</ul>
		</nav>
	</div>
	<div class="faq">
		<!-- general -->
		<!-- <div class="general_agileits_genres">
			<h4 class="latest-text w3_latest_text">Featured Movies</h4>
			<div class="container">
				<div class="agileits-single-top">
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">TV - Series</li>
					</ol>
				</div>
			</div>-->
			<div class="container">
				<div class="bs-example bs-example-tabs" role="tabpanel"
					data-example-id="togglable-tabs">
					<ul id="myTab" class="nav nav-tabs" role="tablist">
						<li role="presentation"><a href="inicio.jsp" >Inicio</a></li>
					<li role="presentation" class="active"><a href="cotizar.jsp"
						>Cotiza</a></li>
					<li role="presentation"><a href="#rating">Contactanos</a></li>

						
					</ul>
					
					<h2 align="center">Hola, somos una aseguradora de autos</h2>
					<img src="imagenesCarros/inicio.jpg" title="album-name" class="img-responsive"
									alt=" " />
					
			
			</div>
		</div>
		
		
						
					</div>
				</div>
				<!--body wrapper end-->
			</div>
			<!-- //general -->
		</div>
	</div>
	<!-- footer -->
	<div class="footer">
		<div class="container">
			
			<div class="col-md-5 w3ls_footer_grid1_left">
				<p>Copyright &copy; 2016 Falabella. All Rights Reserved.</p>
			</div>
			<div class="col-md-7 w3ls_footer_grid1_right">
				<ul>
					
					<li><a href="inicio.jsp">Inicio</a></li>
					<li><a href="cotizar.jsp">Cotiza</a></li>
					<li><a href="#">Contactanos</a></li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //footer -->
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$(".dropdown").hover(function() {
				$('.dropdown-menu', this).stop(true, true).slideDown("fast");
				$(this).toggleClass('open');
			}, function() {
				$('.dropdown-menu', this).stop(true, true).slideUp("fast");
				$(this).toggleClass('open');
			});
		});
	</script>
	<!-- //Bootstrap Core JavaScript -->
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- //here ends scrolling icon -->
</body>
</html>
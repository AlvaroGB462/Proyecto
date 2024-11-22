<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bienvenido</title>
<link rel="stylesheet" href="/resources/css/welcome.css">
</head>
<body>
	<header>
		<div class="logo">
			<img src="/resources/images/logo.png" alt="Logo">
		</div>

		<div class="user-info">
			<%
			// Obtén los atributos desde la request
			com.miempresa.proyecto.models.User user = (com.miempresa.proyecto.models.User) request.getAttribute("user");
			Boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
			%>

			<!-- Si el usuario está logueado, muestra su nombre de usuario -->
			<%
			if (user != null) {
			%>
			Hola,
			<%=user.getUsername()%>
			<%
			if (isAdmin != null && isAdmin) {
			%>
			<button>Administrar</button>
			<%
			}
			%>
			<%
			} else {
			%>
			<!-- Si no hay usuario, muestra el enlace para iniciar sesión -->
			<a href="/login">Iniciar sesión</a>
			<%
			}
			%>
		</div>
	</header>

	<main>
		<h1>Bienvenido a la página principal</h1>
		<p>¡Gracias por visitar nuestro sitio!</p>
	</main>

	<footer>
		<p>&copy; 2024 Mi Empresa. Todos los derechos reservados.</p>
	</footer>
</body>
</html>

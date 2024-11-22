<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/stylesLogin.css">
</head>
<body>
    <div class="login-container">
        <h2>Iniciar Sesión</h2>
        <form action="<%= request.getContextPath() %>/login" method="POST">
            <input type="text" name="usernameOrEmail" placeholder="Nombre de usuario o correo electrónico" required />
            <input type="password" name="password" placeholder="Contraseña" required />
            <button type="submit">Iniciar sesión</button>
        </form>
        <div class="error-message">
            <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
        </div>
    </div>
</body>
</html>

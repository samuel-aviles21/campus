
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <div class="container">
            <h1>Iniciar Sesión</h1>
            <form action="Control" method="POST">
                <input type="hidden" name="action" value="1">
                <label for="username">Nombre de usuario:</label>
                <input type="text" id="username" name="username" required>
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required>
                <button type="submit">Iniciar Sesión</button>
            </form>

            <p>¿No tienes una cuenta? <a href="Registrar.jsp">Regístrate</a></p>
            <% if (request.getAttribute("errorMessage") != null)
                out.print("<p class='error'>Contraseña o usuario incorrecto</p>");
            %>
        </div>
    </body>
</html>

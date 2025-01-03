<%-- 
    Document   : crearCuenta
    Created on : 11 jun. 2024, 21:00:50
    Author     : Estudio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
   <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro</title>
        <link rel="stylesheet" href="css/styleslogin.css">
        <link rel="shortcut icon" href="images/faviconcampus.png" type="image/x-icon">
    </head>
    <body>
        <%
            String correo = (String) request.getAttribute("correo");
        %>
        <div class="container">
            <form action="Control" method="POST">
                <input type="hidden" name="action" value="5">
                <input type="hidden" name="correo" value="<%=correo%>">
                <img src="images/logoazul.svg" class="ajustar-imagen">
                <h1>Crear Cuenta</h1>
                <label for="username">Nombre de usuario:</label>
                <input type="text" id="username" name="username" required>
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required>
                <button type="submit">Crear Cuenta</button>
            <%
                if (request.getAttribute("errorMessage") != null)
                    out.print("<p class='error'>" + (String) request.getAttribute("errorMessage") + "</p>");
            %>
            </form>
        </div>
        
        
        
        
        <!--<div class="container">
            <h1>Crear Cuenta</h1>
            <form action="Control" method="POST">
                <input type="hidden" name="action" value="5">
                <input type="hidden" name="correo" value="<%=correo%>">
                <label for="username">Nombre de usuario:</label>
                <input type="text" id="username" name="username" required>
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required>
                <button type="submit">Crear Cuenta</button>
            </form>
            <%
                //if (request.getAttribute("errorMessage") != null)
                  //  out.print("<p class='error'>" + (String) request.getAttribute("errorMessage") + "</p>");
            %>
        </div>-->
    </body>
</html>

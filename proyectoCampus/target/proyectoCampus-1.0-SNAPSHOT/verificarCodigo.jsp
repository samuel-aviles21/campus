<%-- 
    Document   : verificarCodigo
    Created on : 11 jun. 2024, 20:33:42
    Author     : Estudio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Verificación de Correo</title>
        <link rel="stylesheet" href="css/styleslogin.css">
        <link rel="shortcut icon" href="images/faviconcampus.png" type="image/x-icon">
    </head>
    <body>
        <%
            String correo = (String) request.getAttribute("email");
        %>
       <!-- <div class="container">
            <h1>Verificación de Correo Electrónico</h1>
            <form action="Control" method="POST">
                <input type="hidden" name="action" value="4">
                <input type="hidden" name="email" value="<%=correo%>">
                <label for="verification_code">Código de Verificación:</label>
                <input type="text" id="verification_code" name="verification_code" required>
                <button type="submit">Verificar</button>
            </form>
            <% //if (request.getAttribute("errorMessage") != null)
                //    out.print("<p class='error'>" + (String) request.getAttribute("errorMessage") + "</p>");
            %>
            <p>Se ha enviado un código de verificación a tu dirección de correo electrónico. Por favor, revisa tu bandeja de entrada</p>
            <p>Si no has recibido el correo, <a href="Control?action=6&email=<%=correo%>">haz clic aquí para reenviar</a>.</p>
        </div>-->

        <div class="container">
            <form action="Control" method="POST">
                <input type="hidden" name="action" value="4">
                <input type="hidden" name="email" value="<%=correo%>">
                <h1>Verificación de Correo Electrónico</h1>
                <label for="verification_code">Código de Verificación:</label>
                <input type="text" id="verification_code" name="verification_code" required>
                <button type="submit">Verificar</button>
                <% if (request.getAttribute("errorMessage") != null)
                        out.print("<p class='error'>" + (String) request.getAttribute("errorMessage") + "</p>");
                %>
                <p>Se ha enviado un correo de verificación a tu dirección de correo electrónico. Por favor, revisa tu bandeja de entrada.</p>
                <p>Si no has recibido el correo, <a href="Control?action=6&email=<%=correo%>">haz clic aquí para reenviar</a>.</p>
            </form>
        </div>
    </body>
</html>



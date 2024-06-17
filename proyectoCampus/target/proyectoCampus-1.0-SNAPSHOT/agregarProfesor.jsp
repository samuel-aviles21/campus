<%-- 
    Document   : agregarProfesor
    Created on : 16 jun. 2024, 13:49:23
    Author     : Estudio
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Agregar un Profesor</title>
        <link rel="stylesheet" href="css/crear-profesor.css">
    </head>
    <body>
        <%
            Usuario estudiante = (Usuario) session.getAttribute("estudiante");
        %>
        <div class="container">
            <h1>Agregar un Profesor</h1>
            <p class="instructions">Por favor, ingresar el nombre del profesor siguiendo la siguiente estructura.</p>
            <p class="example">Ejemplo: Juan Carlos Pérez Avilés</p>

            <form action="Control" id="professor-form">
                <input type="hidden" name="action" value="10">
                <input type="hidden" name="user" value="<%=estudiante.getIdUsuario()%>">
                <label for="professor-name">Nombre del Profesor:</label>
                <input type="text" id="professor-name" name="professor-name" required>

                <label for="professor-comment">Comentario:</label>
                <textarea id="professor-comment" name="professor-comment" rows="4" required></textarea>

                <!--<label for="professor-image">Prueba</label>
                <input type="file" id="professor-image" name="professor-image" accept="image/*" required>-->

                <button type="submit">Agregar</button>
            </form>
        </div>

        <!-- Modal de Advertencia -->
        <div id="warning-modal" class="modal">
            <div class="modal-content">
                <p>Recuerda que si observamos que la cuenta que creaste es falsa, tu cuenta será suspendida por un mes.</p>
                <button id="go-back">Cancelar</button>
                <button id="confirm-add">Confirmar</button>
            </div>
        </div>

        <script src="script/crear-profesor.js"></script>
    </body>
</html>

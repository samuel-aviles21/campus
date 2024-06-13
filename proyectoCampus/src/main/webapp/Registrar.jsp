
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <div class="container">
            <h1>Verificación de estudiante</h1>
            <p>Se le enviará un mensaje a su correo institucional con un código de verificación</p>
            <form action="Control" method="POST">
                <input type="hidden" name="action" value="3">
                <label for="email">Ingresar correo institucional</label>
                <input type="email" id="email" name="email" placeholder="correo@gmail"required>
                <button type="submit">ENVIAR</button>
            </form>
        </div>
    </body>
</html>

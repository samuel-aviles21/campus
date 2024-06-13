<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
        <link rel="shortcut icon" href="images/faviconcampus.png" type="image/x-icon">
        <title>Campus</title>
    </head>
    <body>  
        <header id="cabecera">
            <div class="contenedor">
                <nav class="navbar navbar-expand-lg">
                    <div class="container-fluid">
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="paginaPrincipal.jsp">Inicio</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Documentos</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="Resenas.jsp">Reseñas</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Asesorias</a>
                                </li>
                            </ul>
                        </div>
                        <div class="contenedor">
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                <div class="d-flex gap-2">
                                    <a href="Login.jsp" class="btn btn-outline-light btn-white">
                                        <i class="fas fa-sign-in-alt"></i> <span class="d-none d-md-inline">Iniciar sesión</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>     
        </header>


        <section id="busqueda">
            <div class="contenedor buscar">
                <div class="logo">
                    <!-- Reemplaza 'logo.png' con la ruta a tu logo -->
                    <img src="images/logoazul.svg" class="ajustar-imagen">
                </div>
                <div class="description in-flex">
                    <p>Conoce a tu profesor</p>
                </div>
                <div class="search-bar">
                    <input type="text" placeholder="Busca un profesor..."/>
                    <button type="submit">Buscar</button>
                </div>
            </div>
        </section>

        <footer>
            <div class="footer-container">
                <p>Campus &copy; 2024 </p>
                <nav class="footer-nav">
                    <a href="#contacto">Contacto</a>
                    <a href="#acerca">Acerca de</a>
                    <a href="#terminos">Términos y condiciones</a>
                </nav>
            </div>
        </footer>
    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js" integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</html>
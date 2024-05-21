<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/style.css" />
    <link
      rel="shortcut icon"
      href="images/faviconcampus.png"
      type="image/x-icon"
    />
    <title>Campus</title>
  </head>
  <body>
    <header id="cabecera">
      <div class="contenedor">
        <nav class="navbar navbar-expand-lg">
          <div class="container-fluid">
            <button
              class="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarNav"
              aria-controls="navbarNav"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a
                    class="nav-link active"
                    aria-current="page"
                    href="index.html"
                    >Inicio</a
                  >
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="documentos.html">Documentos</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="reseñas.html">Reseñas</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="asesorias.html">Asesorias</a>
                </li>
              </ul>
            </div>
          </div>
          <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <a href="registrarse.html">
              <button class="btn btn-outline-light btn-white" type="button">
                Registrarse
              </button>
            </a>
            <a href="iniciarsesion.html">
              <button class="btn btn-outline-light btn-white" type="button">
                Iniciar sesion
              </button>
            </a>
          </div>
        </nav>
      </div>
    </header>

    <div id="busqueda">
      <div class="logo">
        <!-- Reemplaza 'logo.png' con la ruta a tu logo -->
        <img src="images/campus.svg" class="ajustar-imagen" />
      </div>
      <div class="description">
        <p>Encuentra al mejor profesor</p>
      </div>
      <div class="search-bar">
        <input type="text" placeholder="Busca un profesor..." />
        <button type="submit">Buscar</button>
      </div>
    </div>

    <footer>
      <div class="footer-container">
        <p>Campus &copy; 2024</p>
        <nav class="footer-nav">
          <a href="#contacto">Contacto</a>
          <a href="#acerca">Acerca de</a>
          <a href="#terminos">Términos y condiciones</a>
        </nav>
      </div>
    </footer>
  </body>
</html>

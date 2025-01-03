
<%@page import="modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Comentario"%>
<%@page import="modelo.Dao"%>
<%@page import="modelo.Profesor"%>
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
        <%
            Profesor profesor=(Profesor)session.getAttribute("perfil");
            Usuario estudiante=(Usuario)session.getAttribute("estudiante");
            String estado="0";
            if(estudiante==null){
                estado="0";
            }else{
                estado="1";
            }
            //session.removeAttribute("perfil");
        %>
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
                                    <a class="nav-link" href="paginaPrincipal.jsp">Inicio</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Documentos</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="Resenas.jsp">Reseñas</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Asesorias</a>
                                </li>
                            </ul>
                        </div>
                        <div class="contenedor">
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                <div class="d-flex gap-2">
                                    <%
                                        if (session.getAttribute("estudiante") == null) {
                                            out.print("<a href='Login.jsp' class='btn btn-outline-light btn-white'>"
                                                    + "<i class='fas fa-sign-in-alt'></i><span class='d-none d-md-inline'> Iniciar sesión</span></a>");
                                        }
                                        if (session.getAttribute("estudiante") != null) {
                                            out.print("<a href='Control?action=2' class='btn btn-outline-light btn-white'><span class='d-non d-md-inline'>Cerrar sesión</span></a>");
                                        }
                                    %>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>     
        </header>

        <section id="head-teacher">
            <div class="contenedor">
                <div class="fila">
                    <div class="columna columna50">
                        <nav class="navbar">
                            <div class="container-fluid">
                                <form action="Control" class="d-flex" role="search">
                                    <input type="hidden" name="action" value="7">
                                    <input name="nombreProfesor" class="form-control me-2" type="search" placeholder="Ingresa el nombre del profesor" aria-label="Search">
                                    <button class="btn btn-outline-success" type="submit">Buscar</button>
                                </form>
                            </div>
                        </nav>
                    </div>

                    <div class="columna columna50">
                        <div class="button-add d-grid gap-2 d-md-flex justify-content-md-end">
                            <a href="Control?action=11&status=<%=estado%>" class="btn btn-primary me-md-2" type="button">Agregar nuevo docente</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section id="reseñas">
            <div class="contenedor">
                <div class="fila"> 
                    <div class="columna columna25">
                        <i class="fa-solid fa-user-tie"></i>
                    </div>
                    <div class="columna columna35">
                        <h1><%=profesor.getNom_profe()%></h1>
                        <h5>121 comentarios</h5>
                    </div>
                    <div class="columna columna50">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item" role="presentation">
                                <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home-tab-pane" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">COMENTARIOS</button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-tab-pane" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">EXAMENES Y TRABAJOS</button>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                             <div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
                                 <form action="Control">
                                     <input type="hidden" name="action" value="12">
                                     <input type="hidden" name="status" value="<%=estado%>">
                                     <%
                                         if (estudiante!=null) {
                                                 out.print("<input type='hidden' name='user' value='"+estudiante.getIdUsuario()+"'>");
                                             }
                                     %>
                                     <input type="hidden" name="idpf" value="<%=profesor.getId_profe()%>">
                                     <textarea type="text" name="comentario" placeholder="Escribe un comentario aqui"></textarea>
                                     <input type="submit" value="Comentar">
                                 </form>
                             </div>
                            <%
                                Dao dao = new Dao();
                                List<Comentario> comentarios = dao.cargarComentarios(profesor.getId_profe());
                                for (Comentario comentario : comentarios) {
                                    Usuario usuario = dao.inicioUsuario(comentario.getIdUsuario());
                                    out.print("<div class='tab-pane fade show active' id='home-tab-pane' role='tabpanel' aria-labelledby='home-tab' tabindex='0'>"
                                            +"<p>"+usuario.getNombreUsuario()+"</p>" 
                                            +"<p>" + comentario.getComentario() + "</p></div>");
                                }
                            %>
<!--                            <div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
                                <p>Hola</p>
                            </div>
-->
                            <div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
                            </div>
                        </div>
                    </div>
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
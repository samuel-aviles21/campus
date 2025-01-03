CREATE DATABASE IF NOT EXISTS campus;
USE campus;

-- Crear la tabla USUARIOS
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL,
    correo VARCHAR(60) NOT NULL,
    userpassword VARCHAR(50) NOT NULL
);

-- Crear la tabla PROFESORES
CREATE TABLE profesores (
    id_profe INT AUTO_INCREMENT PRIMARY KEY,
    nom_profe VARCHAR(100) NOT NULL,
    id_usuario INT,
    ruta_prueba VARCHAR(100) ,
    FOREIGN KEY (id_usuario) REFERENCES USUARIOS(id_usuario)
);

-- Crear la tabla COMENTARIOS
CREATE TABLE comentarios (
    id_comentario INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_profe INT,
    comentario VARCHAR(500),
    FOREIGN KEY (id_usuario) REFERENCES USUARIOS(id_usuario),
    FOREIGN KEY (id_profe) REFERENCES PROFESORES(id_profe)
);

-- Crear la tabla DOCUMENTOS
CREATE TABLE documentos (
    id_documento INT AUTO_INCREMENT PRIMARY KEY,
    id_prof INT,
    id_estudiante INT,
    fecha_examen DATE,
    id_tipo_documento int NOT NULL,
    ruta_archivo VARCHAR(255),
    descripcion VARCHAR(300),
    FOREIGN KEY (id_prof) REFERENCES PROFESORES(id_profe),
    FOREIGN KEY (id_estudiante) REFERENCES USUARIOS(id_usuario),
    FOREIGN KEY(id_tipo_documento) REFERENCES TIPO_DOCUMENTOS(id_tipo_documento)
);

CREATE TABLE tipo_documentos (
    id_tipo_documento INT AUTO_INCREMENT PRIMARY KEY,
    tipo_documento VARCHAR(100) NOT NULL,
    id_profe int,
    FOREIGN KEY (id_profe) REFERENCES PROFESORES(id_profe)
);  

CREATE TABLE codigos_verificacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    correo VARCHAR(60) NOT NULL,
    codigo VARCHAR(4) NOT NULL
)
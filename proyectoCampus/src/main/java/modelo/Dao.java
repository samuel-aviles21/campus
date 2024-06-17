package modelo;

import conexion.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    public List<Profesor> buscarProfesoresPorNombre(String nombre) {
        Connection con = null;
        List<Profesor> listaProfesores = new ArrayList<>();
        String sql = "SELECT id_profe, nom_profe FROM profesores WHERE nom_profe LIKE ?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nombre.toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Profesor profesor = new Profesor(rs.getInt("id_profe"), rs.getString("nom_profe"));
                listaProfesores.add(profesor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
        return listaProfesores;
    }

    public Profesor profesorPerfil(int idProf) {
        Connection con = null;
        Profesor profesor = null;
        String sql = "SELECT nom_profe FROM profesores WHERE id_profe=?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                profesor = new Profesor(idProf, rs.getString("nom_profe"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
        return profesor;
    }

    public void comentar(int idUsuario, int idProfesor, String comentario) {
        Connection con = null;
        String sql = "insert into comentarios(id_usuario,id_profe,comentario) values (?,?,?)";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ps.setInt(2, idProfesor);
            ps.setString(3, comentario);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
    }

    public List<Comentario> cargarComentarios(int idProfesor) {
        Connection con = null;
        List<Comentario> comentarios = new ArrayList<>();
        String sql = "SELECT id_comentario, id_usuario,comentario FROM comentarios WHERE id_profe=?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProfesor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comentario comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("id_comentario"));
                comentario.setIdUsuario(rs.getInt("id_usuario"));
                comentario.setComentario(rs.getString("comentario"));
                comentarios.add(comentario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
        return comentarios;
    }

    /*public String mostrarUsuario(int idUsuario) {
        Connection con = null;
        String nombre = "";
        String sql = "SELECT comentario FROM comentaris WHERE id_usuario=?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombre=rs.getString("")
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
        return nombre;
    }*/
    public void addTeacher(String nameTeacher, int idUsuario) {
        Connection con = null;
        String sql = "insert into profesores(nom_profe,id_usuario) values (?,?)";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nameTeacher.toUpperCase());
            ps.setInt(2, idUsuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }

    }
    
     public Profesor mostrarProfeAgregado(String nombre) {
        Connection con = null;
        Profesor profesor=null;
        String sql = "SELECT id_profe, nom_profe FROM profesores WHERE nom_profe = ?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,nombre.toUpperCase());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               profesor = new Profesor(rs.getInt("id_profe"), rs.getString("nom_profe"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
        return profesor;
    }

    public void registerUser(String username, String correo, String contrasena) {
        Connection con = null;
        String sql = "insert into usuarios(nombre_usuario,correo,userpassword) values (?,?,?)";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, correo);
            ps.setString(3, contrasena);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
    }

    public int verificarUsuario(String user_name, String user_password) {
        Connection con = null;
        int verificacion = 0;
        String sql = "SELECT id_usuario FROM usuarios WHERE nombre_usuario=? AND userpassword = ?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user_name);
            ps.setString(2, user_password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                verificacion = rs.getInt("id_usuario");
            } else {
                verificacion = -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
        return verificacion;
    }

    public boolean verificarCorreoExiste(String correoNuevo) {
        boolean existe = false;
        Connection con = null;
        String sql = "SELECT * FROM  usuarios WHERE correo=?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correoNuevo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            } else {
                existe = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
        return existe;
    }

    public void generarCodigo(String correoUsuario) {
        if (verificarCorreoVerificado(correoUsuario)) {
            reenviarCodigo(correoUsuario);
        } else {
            Connection con = null;
            Envio envio = new Envio();
            String codigo = envio.prepararCorreo(correoUsuario);
            String sql = "INSERT INTO codigos_verificacion (correo, codigo) VALUES (?, ?)";
            try {
                con = MySQLConnection.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, correoUsuario);
                ps.setString(2, codigo);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                        System.out.println("Conexion cerrada");
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar la conexion");
                    }
                }
            }
        }

    }

    public boolean verificarCorreoVerificado(String correoUser) {
        boolean existe = false;
        Connection con = null;
        String sql = "SELECT * FROM  codigos_verificacion WHERE correo=?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correoUser);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            } else {
                existe = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
        return existe;
    }

    public void reenviarCodigo(String correoUsuario) {
        Connection con = null;
        Envio envio = new Envio();
        String codigo = envio.prepararCorreo(correoUsuario);
        String sql = "UPDATE codigos_verificacion SET codigo=? WHERE correo=?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, correoUsuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
    }

    public boolean verificarCodigo(String correoUsuario, String codigo) {
        Connection con = null;
        boolean verificacion = false;
        String sql = "SELECT id FROM codigos_verificacion WHERE correo=? AND codigo = ?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correoUsuario);
            ps.setString(2, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                verificacion = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
        return verificacion;
    }

    public Usuario inicioUsuario(int id) {
        Connection con = null;
        Usuario usuario = new Usuario();
        String sql = "SELECT id_usuario,nombre_usuario,correo,userpassword FROM usuarios WHERE id_usuario=?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContasena(rs.getString("userpassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
        return usuario;
    }

    public boolean existeNombre(String username) {
        boolean existe = false;
        Connection con = null;
        String sql = "SELECT * FROM  usuarios WHERE nombre_usuario=?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            } else {
                existe = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
        return existe;
    }
}

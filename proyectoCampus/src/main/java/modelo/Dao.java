package modelo;

import conexion.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Dao {

    public void addTeacher(String nameTeacher) {
        Connection con = null;
        String sql = "insert into profesores(nom_profe) values (?)";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nameTeacher.toUpperCase());
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
    
    public void generarCodigo(String correoUsuario) {
        Connection con = null;
        Envio envio=new Envio();
        String codigo=envio.prepararCorreo(correoUsuario);
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
    
    public boolean verificarCodigo(String correoUsuario,String codigo){
        Connection con = null;
        boolean verificacion=false;
        String sql = "SELECT id FROM codigos_verificacion WHERE correo=? AND codigo = ?";
        try {
            con = MySQLConnection.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correoUsuario);
            ps.setString(2, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                verificacion=true;
            } else {
                verificacion = false;
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
    
    public Usuario inicioUsuario(int id){
        Connection con = null;
        Usuario usuario=new Usuario();
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
    
}

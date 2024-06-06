
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/deliper";
            String usr = "root";
            String psw = "";
            con = DriverManager.getConnection(url, usr, psw);
            System.out.println("conexion ok");
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
            System.out.println("No hay Driver!!");

        } catch (SQLException ex) {
            ex.getMessage();
            System.out.println("Error con la BD ");
        }
        return con;
    }
    
     public static void cerrarConexion(Connection con) {
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

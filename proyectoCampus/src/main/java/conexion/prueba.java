/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import modelo.*;

/**
 *
 * @author nilso
 */
public class prueba {

    public static void main(String[] args) {
        Dao dao=new Dao();
        //System.out.println(dao.verificarCodigo("u19218757@utp.edu.pe","3175"));
       // Usuario prueba=dao.inicioUsuario(6);
       // System.out.println(prueba.getIdUsuario()+" "+prueba.getContasena()+""+prueba.getCorreo()+""+prueba.getNombreUsuario());
        System.out.println(dao.verificarCodigo("nachock57@gmail.com", "5911"));
    }
}

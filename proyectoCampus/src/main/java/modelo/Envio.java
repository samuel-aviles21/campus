/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.security.SecureRandom;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Estudio
 */
public class Envio {

    public String enviarCorreo(Session session, String toEmail) {
        String codigo="";
        try {
            String caracteres = "0123456789";
            SecureRandom random = new SecureRandom();
            StringBuilder sb = new StringBuilder(4); // Longitud fija de 4 letras
            for (int i = 0; i < 4; i++) {
                int indice = random.nextInt(caracteres.length());
                sb.append(caracteres.charAt(indice));
            }
            codigo=sb.toString();
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("contacto@campustu.com", "Campus"));
            msg.setReplyTo(InternetAddress.parse("contacto@campustu.com", false));
            msg.setSubject("Verificación de estudiante", "UTF-8");
            msg.setText(codigo, "UTF-8");
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
         return codigo;
    }
    
    public String prepararCorreo(String correo){
        final String fromEmail = "contacto@campustu.com";
        final String password = "5739562kK#";
        String toEmail = correo;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.hostinger.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getDefaultInstance(props, auth);
        return enviarCorreo(session, toEmail);
    }
}

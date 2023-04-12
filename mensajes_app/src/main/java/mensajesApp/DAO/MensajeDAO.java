package mensajesApp.DAO;

import mensajesApp.Mensaje;
import mensajesApp.Utils.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {

    public static void createMessage(Mensaje mensaje) {
        Connection dbConnect = new Connection();
        try (java.sql.Connection connection = dbConnect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO `mensajes` (mensaje, autor_mensaje) VALUES (?, ?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Message send successfull!");
            } catch (SQLException ex){
                System.out.println(ex);
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void readMessage() {
        Connection dbConnect = new Connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (java.sql.Connection connection = dbConnect.get_connection()){
            String query = "SELECT * FROM mensajes";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha"));
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void updateMessage(Mensaje mensaje) {
        Connection dbConnect = new Connection();
        PreparedStatement ps = null;
        try (java.sql.Connection connection = dbConnect.get_connection()){
            try{
                String query = "UPDATE mensajes SET mensaje = ? WHERE mensajes.id_mensaje = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getIdMensaje());
                ps.executeUpdate();
                System.out.println("This message was updated successfull!");
            } catch (SQLException ex){
                System.out.println(ex);
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void deleteMessage(int idMensaje) {
        Connection dbConnect = new Connection();
        PreparedStatement ps = null;
        try (java.sql.Connection connection = dbConnect.get_connection()){
            try{
                String query = "DELETE FROM mensajes WHERE mensajes.id_mensaje = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                System.out.println("This message was deleted successfull!");
            } catch (SQLException ex){
                System.out.println(ex);
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }

}

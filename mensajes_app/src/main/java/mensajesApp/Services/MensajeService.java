package mensajesApp.Services;

import mensajesApp.DAO.MensajeDAO;
import mensajesApp.Mensaje;

import java.util.Scanner;

public class MensajeService {

    public static void createMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Tu nombre");
        String nombre = sc.nextLine();
        Mensaje ms = new Mensaje();
        ms.setMensaje(mensaje);
        ms.setAutorMensaje(nombre);
        MensajeDAO.createMessage(ms);
    }

    public static void listMessages() {
        MensajeDAO.readMessage();
    }

    public static void deleteMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ID del mensaje a borrar");
        int idMensaje = sc.nextInt();
        MensajeDAO.deleteMessage(idMensaje);
    }

    public static void editMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ID del mensaje a editar");
        int idMensaje = sc.nextInt();
        System.out.println("Escribe el nuevo mensaje");
        sc.nextLine();
        String mensaje = sc.nextLine();
        Mensaje ms = new Mensaje();
        ms.setIdMensaje(idMensaje);
        ms.setMensaje(mensaje);
        MensajeDAO.updateMessage(ms);
    }


}

package mensajesApp.Utils;

import mensajesApp.Services.MensajesService;

import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    int option = 0;

    public void startMenu(){

            do {
                System.out.println("------------------------------");
                System.out.println("Aplicación de mensajes");
                System.out.println("1. Crear Mensaje");
                System.out.println("2. Listar Mensaje");
                System.out.println("3. Editar Mensaje");
                System.out.println("4. Eliminar Mensaje");
                System.out.println("5. Salir");

                option = sc.nextInt();

                switch (option){
                    case 1:
                        MensajesService.createMessage();
                        break;
                    case 2:
                        MensajesService.listMessages();
                        break;
                    case 3:
                        MensajesService.deleteMessage();
                        break;
                    case 4:
                        MensajesService.editMessage();
                        break;
                    default:
                        break;
                }

            }while (option != 5);

    }
}

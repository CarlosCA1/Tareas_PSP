import java.io.IOException;
import java.util.Scanner;

public class Tarea_6 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Introduzca un host/ip: ");
            String ip = scanner.nextLine();
            if (ip.equals("salir")){
                break;
            }
            Lanzador lanzador = new Lanzador(ip);
            lanzador.lanzaProceso();
        } while (true);
        scanner.close();
        System.out.println("Programa finalizado");
    }
}

//ip de Google: 172.217.17.14


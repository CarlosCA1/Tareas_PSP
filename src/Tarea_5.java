import java.io.IOException;
import java.util.Scanner;

public class Tarea_5 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String comando;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Introduce un comando: ");
            comando = scanner.nextLine();
            if (comando.equals("0")){
                break;
            }
            System.out.println("Introduce un parámetro a ejecutar: ");
            String parametro = scanner.nextLine();
            lanzaProceso(comando, parametro);
        } while (true);
            scanner.close();
            System.out.println("Programa finalizado");
    }

    public static void lanzaProceso (String comando, String parametro) throws IOException, InterruptedException {
        ProcessBuilder proceso;
        proceso = new ProcessBuilder(comando, parametro);
        int exitcode = proceso.start().waitFor();
        System.out.println("El nombre del programa es " + parametro + ". El proceso hijo ha terminado con el código " + exitcode);
    }
}

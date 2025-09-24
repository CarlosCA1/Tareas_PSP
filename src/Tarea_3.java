import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Tarea_3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo: ");
        String rutaArchivo = scanner.nextLine();
        scanner.close();
        abreArchivo(rutaArchivo);
    }

    public static void abreArchivo (String rutaArchivo) throws IOException {


        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            if(archivo.createNewFile()){
                System.out.println("Archivo creado");
            }else {
                System.out.println("No se pudo crear el archivo");
                return;
            }
        } else {
            System.out.println("Existe ese archivo. Abriendo...");
        }

        ProcessBuilder proceso;
        boolean esWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        if (esWindows) {
            proceso = new ProcessBuilder("notepad", archivo.getAbsolutePath()); //.getAbsolutePath() asegura que el editor recibe la ruta absoluta y funcione en caso de que introduzcas una relativa
        }else {
            proceso = new ProcessBuilder("xdg-open", archivo.getAbsolutePath());
        }
        proceso.start();
    }
}

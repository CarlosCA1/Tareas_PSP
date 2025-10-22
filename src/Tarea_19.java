import java.util.Scanner;

public class Tarea_19 extends Thread {
    private static int contador = 0;
    private static final Object lockA = new Object();
    private String texto;
    private char vocalBuscada;

    public Tarea_19(String nombre, String texto, char vocalBuscada) {
        super(nombre);
        this.texto = texto;
        this.vocalBuscada = vocalBuscada;
    }

    @Override
    public void run() {
        String textoMinusculas = texto.toLowerCase();
        for (int i = 0; i < textoMinusculas.length(); i++) {
            char caracterActual = textoMinusculas.charAt(i);
            if (caracterActual == vocalBuscada) {
                synchronized (lockA) {
                    contador++;
                }
            }
        }}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un texto: ");
        String texto = scanner.nextLine();
        scanner.close();

        Tarea_19 hilo1 = new Tarea_19("A", texto, 'a');
        hilo1.start();
        Tarea_19 hilo2 = new Tarea_19("E", texto, 'e');
        hilo2.start();
        Tarea_19 hilo3 = new Tarea_19("I", texto, 'i');
        hilo3.start();
        Tarea_19 hilo4 = new Tarea_19("O", texto, 'o');
        hilo4.start();
        Tarea_19 hilo5 = new Tarea_19("U", texto, 'u');
        hilo5.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Contador final: " + contador);
    }
}
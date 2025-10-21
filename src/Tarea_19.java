import java.util.Scanner;

public class Tarea_19 extends Thread {
    private static int contador = 0;
    private final Object lockA = new Object();
    private String texto;
    private int tipoTarea;

    public Tarea_19(String nombre, String texto, int tipoTarea) {
        super(nombre);
        this.texto = texto;
        this.tipoTarea = tipoTarea;
    }

    @Override
    public void run() {
        switch (tipoTarea) {
            case 1:
                String vocalBuscada = "a";
                String textoMinusculas = texto.toLowerCase();
                for (int i = 0; i < textoMinusculas.length(); i++) {
                    char caracterActual = textoMinusculas.charAt(i);
                    if (caracterActual == vocalBuscada.charAt(0)) {
                        synchronized (lockA) {
                            contador++;
                        }
                    }
                }
                break;
            case 2:
                String vocalBuscada2 = "e";
                String textoMinusculas2 = texto.toLowerCase();
                for (int i = 0; i < textoMinusculas2.length(); i++) {
                    char caracterActual = textoMinusculas2.charAt(i);
                    if (caracterActual == vocalBuscada2.charAt(0)) {
                        synchronized (lockA) {
                            contador++;
                        }
                    }
                }
                break;
            case 3:
                String vocalBuscada3 = "i";
                String textoMinusculas3 = texto.toLowerCase();
                for (int i = 0; i < textoMinusculas3.length(); i++) {
                    char caracterActual = textoMinusculas3.charAt(i);
                    if (caracterActual == vocalBuscada3.charAt(0)) {
                        synchronized (lockA) {
                            contador++;
                        }
                    }
                }
                break;
            case 4:
                String vocalBuscada4 = "o";
                String textoMinusculas4 = texto.toLowerCase();
                for (int i = 0; i < textoMinusculas4.length(); i++) {
                    char caracterActual = textoMinusculas4.charAt(i);
                    if (caracterActual == vocalBuscada4.charAt(0)) {
                        synchronized (lockA) {
                            contador++;
                        }
                    }
                }
                break;
            case 5:
                String vocalBuscada5 = "u";
                String textoMinusculas5 = texto.toLowerCase();
                for (int i = 0; i < textoMinusculas5.length(); i++) {
                    char caracterActual = textoMinusculas5.charAt(i);
                    if (caracterActual == vocalBuscada5.charAt(0)) {
                        synchronized (lockA) {
                            contador++;
                        }
                    }
                }
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un texto: ");
        String texto = scanner.nextLine();
        scanner.close();

        Tarea_19 hilo1 = new Tarea_19("A", texto, 1);
        hilo1.start();
        Tarea_19 hilo2 = new Tarea_19("E", texto, 2);
        hilo2.start();
        Tarea_19 hilo3 = new Tarea_19("I", texto, 3);
        hilo3.start();
        Tarea_19 hilo4 = new Tarea_19("O", texto, 4);
        hilo4.start();
        Tarea_19 hilo5 = new Tarea_19("U", texto, 5);
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
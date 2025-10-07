import java.util.Random;

public class Tarea_10 extends Thread {

    public Tarea_10(String nombre) {
        super(nombre);
    }

    // Definimos lo que hace el hilo
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i == 10) {
                System.out.println(getName() + "Iteración " + i + "... ¡Has llegado al límite!");
            } else {
                System.out.println(getName() + "Iteración: " + i);
            }
            try {
                int tiempo = new Random().nextInt(10000) + 1000;
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new Tarea_10("[Hilo 1]").start();
        new Tarea_10("[Hilo 2]").start();
        new Tarea_10("[Hilo 3]").start();
        new Tarea_10("[Hilo 4]").start();
    }
}
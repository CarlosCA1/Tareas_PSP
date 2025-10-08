import java.util.Random;

public class Tarea_15 extends Thread {
    private int hilo;
    private Tarea_15 siguienteHilo;

    public Tarea_15(int hilo) {
        super("[Hilo-" + hilo + "]");
        this.hilo = hilo;
    }

    public void run() {
        if (hilo < 3) {
            siguienteHilo = new Tarea_15(hilo + 1);
            siguienteHilo.start();
        }

        for (int i = 1; i <= 8; i++) {
            System.out.println(getName() + " Iteración " + i);
            try {
                int tiempo = new Random().nextInt(501) + 100;
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (siguienteHilo != null) {
            try {
                siguienteHilo.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Acabó hilo " + getName());
        if (hilo == 1) {
            System.out.println("Todos los hilos han terminado.");
        }
    }

    public static void main(String[] args) {
        Tarea_15 hilo1 = new Tarea_15(1);
        hilo1.start();
    }
}
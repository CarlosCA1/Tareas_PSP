import java.util.Random;

public class Tarea_16 extends Thread {
    private static int contador = 0;
    private final Object lockA = new Object();

    public Tarea_16(String nombre) {
        super(nombre);
    }

    public void run() {

        for (int i = 0; i < 50; i++) {
            synchronized (lockA) {
                contador++;
            }
            try {
                int tiempo = new Random().nextInt(501) + 100;
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(contador);
        }
    }

    public static void main(String[] args) {
        Tarea_16 hilo1 = new Tarea_16("[Hilo-1]");
        hilo1.start();
        Tarea_16 hilo2 = new Tarea_16("[Hilo-2]");
        hilo2.start();
        Tarea_16 hilo3 = new Tarea_16("[Hilo-3]");
        hilo3.start();
        Tarea_16 hilo4 = new Tarea_16("[Hilo-4]");
        hilo4.start();
        Tarea_16 hilo5 = new Tarea_16("[Hilo-5]");
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

import java.util.Random;

public class Tarea_13 extends Thread {

    public Tarea_13(String nombre) {
        super(nombre);
    }

    public void run() {

        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + " Iteración " + i + " Prioridad: " + getPriority());
            try {
                int tiempo = new Random().nextInt(9000) + 1000;
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Acabó hilo " + getName());
    }

    public static void main(String[] args) {
        Tarea_13 hilo1 = new Tarea_13("[Hilo-1]");
        hilo1.setPriority(Thread.MAX_PRIORITY);
        hilo1.start();

        Tarea_13 hilo2 = new Tarea_13("[Hilo-2]");
        hilo2.setPriority(Thread.MIN_PRIORITY);
        hilo2.start();

        Tarea_13 hilo3 = new Tarea_13("[Hilo-3]");
        hilo3.setPriority(Thread.NORM_PRIORITY);
        hilo3.start();

        Tarea_13 hilo4 = new Tarea_13("[Hilo-4]");
        hilo4.setPriority(Thread.NORM_PRIORITY);
        hilo4.start();
    }
}

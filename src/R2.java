import java.util.Random;

public class R2 extends Thread {

    public R2(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        System.out.println(getName());
        }

    public static void main(String[] args) {

        R2 hilo1 = new R2("Operario 1");
        hilo1.start();
        try {
            int tiempo = 2000;
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        R2 hilo2 = new R2("Operario 2");
        hilo2.start();
        try {
            int tiempo = 1000;
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        R2 hilo3 = new R2("Operario 3");
        hilo3.start();
        try {
            int tiempo = 1000;
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Pieza lista para envío");
    }
}
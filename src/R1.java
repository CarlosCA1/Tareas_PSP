import java.util.Random;

public class R1 extends Thread {
    private static int totalEspectadores = 0;
    private final Object lockA = new Object();

    public R1(String nombre) {
        super(nombre);
    }

    public void run() {

        for (int i = 0; i < 1000; i++) {
            synchronized (lockA) {
                totalEspectadores++;
            }
            try {
                int tiempo = new Random().nextInt(501) + 100;
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(totalEspectadores);
        }
    }

    public static void main(String[] args) {
        R1 torno1 = new R1("[Hilo-1]");
        torno1.start();
        R1 torno2 = new R1("[Hilo-2]");
        torno2.start();
        R1 torno3 = new R1("[Hilo-3]");
        torno3.start();
        R1 torno4 = new R1("[Hilo-4]");
        torno4.start();

        try {
            torno1.join();
            torno2.join();
            torno3.join();
            torno4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Contador final: " + totalEspectadores);
    }
}

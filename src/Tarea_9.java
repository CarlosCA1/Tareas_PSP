public class Tarea_9 extends Thread {
    public int N = 10;

    public Tarea_9(String nombre) {
        super(nombre);
    }

    public void Tarea_9_1(int N) {
        this.N = N;
    }

    @Override
    public void run() {
    int numero1 = 0;
    int numero2 = 1;
        for (int i = 1; i <= N; i++) {
           int temp = numero2;
           numero2 = numero1 + numero2;
           numero1 = temp;
            System.out.println(getName() + " Número Fibonacci " + i + ": " + numero1);
        }
    }

    public static void main(String[] args) {
        new Tarea_9("[Hilo]").start();
    }
}

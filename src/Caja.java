public class Caja extends Thread {
    public static double capital = 1000.0;
    private int tipoTarea;

    public Caja(String nombre, int tipoTarea) {
        super(nombre);
        this.tipoTarea = tipoTarea;
    }

    // Definimos lo que hace el hilo
    @Override
    public void run() {
        switch (tipoTarea) {
            case 1:
                for (int i = 1; i <= 5000; i++) {
                    capital = capital + 10;
                    System.out.println("Saldo actual: " + capital);
                }
                break;
            case 2:
                for (int i = 1; i <= 3000; i++) {
                    capital = capital - 10;
                    System.out.println(getName() + "Saldo actual: " + capital);
                }
                break;
            }
        }

    public static void main(String[] args) {
        Caja hilo1 = new Caja("[Hilo de ingresos]", 1);
        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        Caja hilo2 = new Caja("[Hilo de gastos]", 2);
        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("El saldo final es: " + capital);
    }
}
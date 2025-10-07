public class Tarea_8 extends Thread {
    private int limite;

    public Tarea_8(String nombre, int limite) {
        super(nombre);
        this.limite = limite;
    }

    // Definimos lo que hace el hilo
    @Override
    public void run() {
        for (int i = 1; i <= limite; i++) {
            if (i == limite) {
                System.out.println(getName() + " Cabreo nivel: " + i + "... ¡He llegado a mi límite!");
            } else {
                System.out.println(getName() + " Cabreo nivel: " + i);
            }
        }
    }

    public static void main(String[] args) {
        new Tarea_8("[Diego]", 4).start();
        new Tarea_8("[Manuel]",5).start();
        new Tarea_8("[Damian]",3).start();
        new Tarea_8("[Araujo]",5).start();
    }
}
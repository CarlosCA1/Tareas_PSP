public class Tarea_12 extends Thread {
    private int tipoTarea;

    public Tarea_12(String nombre, int tipoTarea) {
        super(nombre);
        this.tipoTarea = tipoTarea;
    }

    // Definimos lo que hace el hilo
    @Override
    public void run() {
        switch (tipoTarea) {
            case 1:
                int suma = 0;
                for (int i = 1; i <= 1923; i++) {
                    suma += i;
                    System.out.println(getName() + ": " + suma);
                }
                break;
            case 2:
                int suma2 = 0;
                for (int i = 0; i <=1923; i++) {
                    suma2 += i;
                    System.out.println(getName() + ": " + suma2);
                }
                break;
            case 3:
                int suma3 = 0;
                for (int i = 1; i <=1923; i++) {
                    if (i % 10 == 3 || i % 10 == 4) {
                        suma3 += i;
                        continue;
                    }
                    System.out.println(getName() + ": " + suma3);
                }
                break;
        }
    }

    public static void main(String[] args) {
        new Tarea_12("[Hilo 1]", 1).start();
        new Tarea_12("[Hilo 2]", 2).start();
        new Tarea_12("[Hilo 3]", 3).start();
    }
}
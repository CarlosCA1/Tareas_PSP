import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lanzador{
    private String ip;
    public Lanzador (String ip){
        this.ip = ip;
    }
    public void lanzaProceso () throws IOException, InterruptedException {
        ProcessBuilder proceso = new ProcessBuilder("ping", "-c", "4", ip);
        Process p = proceso.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String linea;
        while ((linea = reader.readLine()) != null){
            System.out.println("PING: " + linea);
        }
        int exitcode = p.waitFor();
        System.out.println("El proceso hijo ha terminado con el código " + exitcode);
    }
}

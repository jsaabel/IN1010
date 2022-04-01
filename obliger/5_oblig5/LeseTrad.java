import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class LeseTrad implements Runnable{
    
    private Monitor2 monitor;
    private String filnavn;
    
    // Konstruktoer
    public LeseTrad(String filnavn, Monitor2 monitor){
        this.filnavn = filnavn;
        this.monitor = monitor;
    }

    @Override
    public void run(){
        try{
            HashMap<String, Subsekvens> hm = monitor.lesInnImmunrepertoar(filnavn);
            monitor.settInn(hm); 
            Thread.sleep(50);
        }

        catch (FileNotFoundException e){
            System.out.println("Fil ikke funnet");
        }

        catch (InterruptedException e){ // temp
            System.out.println("Interrupted");
        }

    }
}    




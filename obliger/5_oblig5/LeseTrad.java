import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/**
 * LeseTrad-klasse
 */
public class LeseTrad implements Runnable{
    
    private Monitor2 monitor;
    private String filnavn;
    
    // Konstruktoer
    public LeseTrad(String filnavn, Monitor2 monitor){

        this.filnavn = filnavn;
        this.monitor = monitor;
    }

    // run-metode
    @Override
    public void run(){

        try{
            HashMap<String, Subsekvens> hm = monitor.lesInnImmunrepertoar(filnavn);
            monitor.settInn(hm); 
            return;
        }

        catch (FileNotFoundException e){
            System.out.println("Fil ikke funnet");
        }
    }
}    




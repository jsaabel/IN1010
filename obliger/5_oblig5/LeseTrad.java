import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class LeseTrad implements Runnable{
    
    private Monitor2 monitor;
    private String filnavn;
    private CountDownLatch latch;
    
    // Konstruktoer
    public LeseTrad(String filnavn, Monitor2 monitor, CountDownLatch latch){
        this.filnavn = filnavn;
        this.monitor = monitor;
        this.latch = latch;
    }

    @Override
    public void run(){
        try{
            HashMap<String, Subsekvens> hm = monitor.lesInnImmunrepertoar(filnavn);
            monitor.settInn(hm);
            latch.countDown();
        }

        catch (FileNotFoundException e){
            System.out.println("Fil ikke funnet");
        }

    }
}    




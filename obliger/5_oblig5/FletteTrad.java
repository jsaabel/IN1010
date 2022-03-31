
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class FletteTrad implements Runnable{
    
    private Monitor2 monitor;
    private String filnavn;
    //private CountDownLatch latch;
    
    // Konstruktoer
    public FletteTrad(String filnavn, Monitor2 monitor){
        this.filnavn = filnavn;
        this.monitor = monitor;
        //this.latch = latch;
    }

    @Override
    public void run(){
        HashMap<String, Subsekvens> hm1 = monitor.taUt();
        HashMap<String, Subsekvens> hm2 = monitor.taUt();
        HashMap<String, Subsekvens> hm = monitor.slaaSammen(hm1, hm2);
        monitor.settInn(hm);
        //latch.countDown();
    }

}    




import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class FletteTrad implements Runnable{
    
    private Monitor2 monitor;
    private String filnavn;
    //private CountDownLatch latch;
    
    // Konstruktoer
    public FletteTrad(Monitor2 monitor){
        //this.filnavn = filnavn;
        this.monitor = monitor;
        //this.latch = latch;
    }

    @Override
    public void run(){
        try{
            System.out.println(this + ": Fletter");
            ArrayList<HashMap<String, Subsekvens>> hms = monitor.hentUtTo();
            while (hms!=null){
                HashMap<String, Subsekvens> hm = 
                    monitor.slaaSammen(hms.get(0), hms.get(1));
                monitor.settInnFlettet(hm);
                hms = monitor.hentUtTo();
            }
        }

        catch (InterruptedException e){
            System.out.println("FletteTrad avbrutt.");
        }
        //latch.countDown();
    }

}    




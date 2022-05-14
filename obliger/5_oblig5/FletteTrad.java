import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * FletteTrad-klasse
 */
public class FletteTrad implements Runnable{
    
    private Monitor2 monitor;
    private String filnavn;
    private CountDownLatch latch;
    
    // Konstruktoer
    public FletteTrad(Monitor2 monitor, CountDownLatch latch){

        this.monitor = monitor;
        this.latch = latch;
    }

    // run-metode
    @Override
    public void run(){

        try{

            System.out.println("Starter flettetraad...");
            while (monitor.hentAntallGangerAaSetteInnTo() > 0){ 

                ArrayList<HashMap<String, Subsekvens>> hms = monitor.hentUtTo();
                HashMap<String, Subsekvens> hm = 
                    monitor.slaaSammen(hms.get(0), hms.get(1));
                monitor.settInn(hm);
                monitor.tellNedAntallGangerAaSetteInnTo();
                //System.out.println("Gjenstaaende fletteprosesser: "
                        //+ monitor.hentAntallGangerAaSetteInnTo());
                latch.countDown();
            }
        }

        catch (InterruptedException e){
            System.out.println("FletteTrad avbrutt.");
        }
    }
}    



kjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkk:qkjjjjjjjj:closekjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkjjqkjjqkjjkkjkjTkjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkjjjjjjjkkkkkkkkkj€ý,€ý.kkkkkkkkkkkkkkkkjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkLjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkLjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkLjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkjjjjjjjjkjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkjjjjjjkkkkkjjjO// !! 05/22: Should this be inside try€kb€kb€kbthe try block>>€kb€kb??:wjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkklllllllkllllllllllllllllllllllllljklllllLjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjLjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkLjkkkkkkkkjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjggjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjHHHkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkggjjjjjjjjjjjjjjjjkkkkLLLjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkjjjjjjjjjjjjjjjjjjjjkkkkkkkkkLLjjjjjjjjjjjjj€ý,€ý-€ý.jjjjjjjjjjjjjjkkkkkkkkkkkkkkjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
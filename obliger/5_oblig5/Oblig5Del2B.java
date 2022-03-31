import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class Oblig5Del2B{
    public static void main(String[] args) throws InterruptedException{
        
        String navnPaaMappe = args[0];
        
        Monitor2 monitor = new Monitor2();

        File f = new File(navnPaaMappe);
        String[] filer = f.list();

        // Burde latchen og innlesingen flyttes inn i Monitor-klassen?
        CountDownLatch latch = new CountDownLatch(filer.length);
        for (String fil : filer){

            if (fil.equals("metadata.csv")){
                latch.countDown();
                continue; // Gjoer det enkelt her. Forandres senere.
            }

            try{
                LeseTrad trad = new LeseTrad(navnPaaMappe + "/" + fil, monitor,
                        latch);
                new Thread(trad).start();
            }

            catch(Exception e){
                System.out.println(e);
            }
        }

        // Barriere: Venter paa alle lesetrad foer fletting
        latch.await();
          

        // Fletting
        // Fortsett her, bli kvitt CountDownLatch.
        // Fix logikk (hvordan vaere sikker paa at det ikke er flere?)
        FletteTrad fletteTrad = new FletteTrad(monitor);
        new Thread(fletteTrad).start();
        new Thread(fletteTrad).start();

        Thread.sleep(10000);

        HashMap<String, Subsekvens> res = monitor.taUt();

        int flest = 0;
        String flest_sekv = null;
        for (Subsekvens subsek: res.values()){
        
            if (subsek.hentForekomster() > flest){
                flest = subsek.hentForekomster();
                flest_sekv = subsek.subsekvens;
            
            }
        }

        System.out.println("Sekvensen med flest forekomster i mappen "
                + navnPaaMappe + " var "+ flest_sekv
                + " (" + flest + ").");
    }

}    


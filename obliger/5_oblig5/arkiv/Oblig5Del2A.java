import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class Oblig5Del2A{
    public static void main(String[] args) throws InterruptedException{
        
        String navnPaaMappe = args[0];
        
        Monitor1 monitor = new Monitor1();

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
        while (monitor.hentAntall() > 1){

            HashMap<String, Subsekvens> hm = monitor.slaaSammen(monitor.taUt(), monitor.taUt());
            monitor.settInn(hm);
        }

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


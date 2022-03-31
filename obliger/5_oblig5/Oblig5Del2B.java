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
        int antFiler = 0; // TEMP
        for (String fil : filer){

            if (fil.equals("metadata.csv")){
                latch.countDown();
                continue; // Gjoer det enkelt her. Forandres senere.
            }

            antFiler++; // TEMP

            try{
                LeseTrad trad = new LeseTrad(navnPaaMappe + "/" + fil, monitor,
                        latch);
                new Thread(trad).start();
                
            }

            catch(Exception e){
                System.out.println(e);
            }
        }

        // TEMP
        monitor.settAntSkalFlettes(antFiler - 1);
        System.out.println("AntSkalFlettes: " + monitor.hentAntSkalFlettes());

        // Barriere: Venter paa alle lesetrad foer fletting
        latch.await();
          

        // Fletting
        // Fortsett her, bli kvitt CountDownLatch.
        // Fix logikk (hvordan vaere sikker paa at det ikke er flere?)
        // Traad run metode: ikke bare en iterasjon?
        // (while condition i try-blokk)
        // Hva med lese-traadene?
        //FletteTrad fletteTrad = new FletteTrad(monitor);
        Runnable fletting = new FletteTrad(monitor);
        new Thread(fletting).start();


        // Barriere (tbi): Vent til fletting er ferdig
        // Thread.sleep(10000);
        // monitor.flettingFerdig.await();
        System.out.println(monitor.hentAntall());
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


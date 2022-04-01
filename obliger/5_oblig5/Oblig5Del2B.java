import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Oblig5Del2B{
    public static void main(String[] args) throws InterruptedException,
           FileNotFoundException{
        
        Monitor2 monitor = new Monitor2();

        int antFletteTrader = 4;
        CountDownLatch fletteLatch = new CountDownLatch(antFletteTrader);


        String navnPaaMappe = args[0];
        

        //File f = new File(navnPaaMappe);
        File f = new File(navnPaaMappe + "/" + "metadata.csv");
        Scanner inn = new Scanner(f);
        while (inn.hasNextLine()){
            String[] biter = inn.nextLine().split(",");
            String filnavn = biter[0];
            LeseTrad trad = new LeseTrad(navnPaaMappe + "/" + filnavn, monitor);
            new Thread(trad).start();
        }

        Runnable fletting = new FletteTrad(monitor, fletteLatch);
        for (int i=0; i < antFletteTrader; i++){
            new Thread(fletting).start();
        }

        // Burde latchen og innlesingen flyttes inn i Monitor-klassen?
        //for (String fil : filer){

        //    if (fil.equals("metadata.csv")){
        //        continue; // Gjoer det enkelt her. Forandres senere.
        //    }

        //    try{
        //        LeseTrad trad = new LeseTrad(navnPaaMappe + "/" + fil, monitor);
        //        new Thread(trad).start();
        //    }

        //    catch(Exception e){
        //        System.out.println(e);
        //    }
        //}


        // Barriere: Venter paa alle lesetrad foer fletting
        //latch.await();
        //System.out.println("Innlesing ferdig");
          

        // Fletting
        // Fortsett her, bli kvitt CountDownLatch.
        // Fix logikk (hvordan vaere sikker paa at det ikke er flere?)
        // Traad run metode: ikke bare en iterasjon?
        // (while condition i try-blokk)
        // Hva med lese-traadene?
        //FletteTrad fletteTrad = new FletteTrad(monitor);


        fletteLatch.await();
        // Barriere (tbi): Vent til fletting er ferdig
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


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

        // Runnable fletting = new FletteTrad(monitor, fletteLatch);
        // for (int i=0; i < antFletteTrader; i++){
        //     new Thread(fletting).start();
        // }
        FletteTrad trad1 = new FletteTrad(monitor, fletteLatch);
        new Thread(trad1).start();
        FletteTrad trad2 = new FletteTrad(monitor, fletteLatch);
        new Thread(trad2).start();
        FletteTrad trad3 = new FletteTrad(monitor, fletteLatch);
        new Thread(trad3).start();
        FletteTrad trad4 = new FletteTrad(monitor, fletteLatch);
        new Thread(trad4).start();
            


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


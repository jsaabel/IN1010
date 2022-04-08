import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Oblig5Del2B{
    public static void main(String[] args) throws InterruptedException,
           FileNotFoundException{
        
        Monitor2 monitor = new Monitor2();

        int ANTFLETTETRADER = 4;

        // Innlesing av filer og setup
        String navnPaaMappe = args[0];
        File f = new File(navnPaaMappe + "/" + "metadata.csv");
        Scanner inn = new Scanner(f);

        System.out.println("Leser inn " + navnPaaMappe + "... \n");
        while (inn.hasNextLine()){
            String[] biter = inn.nextLine().split(",");
            String filnavn = biter[0];
            LeseTrad trad = new LeseTrad(navnPaaMappe + "/" + filnavn, monitor);
            monitor.lagreLeseTrad(trad);
        }

        int antallFileriMappen = monitor.hentLeseTrader().size();

        monitor.settAntallGangerAaSetteInnTo(antallFileriMappen - 1);
        CountDownLatch fletteLatch = new CountDownLatch(antallFileriMappen - 1);
        
        for (LeseTrad t:monitor.hentLeseTrader()){
            new Thread(t).start();
        }

        // Starter flettetraader
        Runnable fletting = new FletteTrad(monitor, fletteLatch);
        for (int i=0; i < ANTFLETTETRADER; i++){
            new Thread(fletting).start();
        }

        // (Venter paa at innlesing, fletting osv avsluttes)
        fletteLatch.await();
        
        // Henter ut og "analyserer" den siste/gjenstaaende HashMappen
        HashMap<String, Subsekvens> res = monitor.taUt();

        int flest = 0;
        String flest_sekv = null;

        for (Subsekvens subsek: res.values()){
            if (subsek.hentForekomster() > flest){
                flest = subsek.hentForekomster();
                flest_sekv = subsek.subsekvens;
            }
        }

        // Skriver ut fasit og avslutter programmet
        System.out.println("\nFletting avsluttet.\n" 
                + "\nSekvensen med flest forekomster i mappen "
                + navnPaaMappe + " var "+ flest_sekv
                + " (" + flest + ").");

        System.exit(1);
    }
}    


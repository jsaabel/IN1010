import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.Scanner;
import java.io.FileNotFoundException;
import org.apache.commons.math3.stat.inference.BinomialTest;
import org.apache.commons.math3.stat.inference.AlternativeHypothesis;

public class Oblig5Hele{
    public static void main(String[] args) throws InterruptedException,
           FileNotFoundException{
        
        Monitor2 monitor_true = new Monitor2();
        Monitor2 monitor_false = new Monitor2();

        int ANTFLETTETRADER = 4;

        // Innlesing av filer og setup
        String navnPaaMappe = args[0];
        File f = new File(navnPaaMappe + "/" + "metadata.csv");
        Scanner inn = new Scanner(f);

        System.out.println("Leser inn " + navnPaaMappe + "... \n");
        while (inn.hasNextLine()){

            String[] biter = inn.nextLine().split(",");
            if (biter.length != 2){
                continue;
            }
            String filnavn = biter[0];
            String status = biter[1];

            if (status.equals("True")){
                LeseTrad trad = new LeseTrad(navnPaaMappe + "/" + filnavn,
                        monitor_true);
                monitor_true.lagreLeseTrad(trad);
            }

            else {
                LeseTrad trad = new LeseTrad(navnPaaMappe + "/" + filnavn,
                        monitor_false);
                monitor_false.lagreLeseTrad(trad);
            }
        }

        int antallFileriMappen_true = monitor_true.hentLeseTrader().size();
        int antallFileriMappen_false = monitor_false.hentLeseTrader().size();
        monitor_true.settAntallGangerAaSetteInnTo(antallFileriMappen_true - 1);
        monitor_false.settAntallGangerAaSetteInnTo(antallFileriMappen_false - 1);
        //OBS
        CountDownLatch fletteLatch_true = new CountDownLatch(
                antallFileriMappen_true - 1);
        CountDownLatch fletteLatch_false = new CountDownLatch(
                antallFileriMappen_false - 1);
        
        // Starter lesetraader
        for (LeseTrad t:monitor_true.hentLeseTrader()){
            new Thread(t).start();
        }

        for (LeseTrad t:monitor_false.hentLeseTrader()){
            new Thread(t).start();
        }

        // Starter flettetraader
        Runnable fletting_true = new FletteTrad(monitor_true, fletteLatch_true);
        for (int i=0; i < ANTFLETTETRADER; i++){
            new Thread(fletting_true).start();
        }
        Runnable fletting_false = new FletteTrad(monitor_false, fletteLatch_false);
        for (int i=0; i < ANTFLETTETRADER; i++){
            new Thread(fletting_false).start();
        }

        // (Venter paa at innlesing, fletting osv avsluttes)
        fletteLatch_true.await();
        fletteLatch_false.await();
        
        // System.out.println(monitor_true.analyserSiste(navnPaaMappe));
        // System.out.println(monitor_false.analyserSiste(navnPaaMappe));

        kjoerSluttAnalyse(monitor_true, monitor_false);
        

        System.exit(1);
    }

    public void kjoerSluttAnalyse(Monitor2 monitor_true, Monitor2 monitor_false){

        hm_true = monitor_true.taUt();
        hm_false = monitor_false.taUt();

        // Gaa gjennom subsekvensene og utfoer binomial test
        for (String subsek: hm_true.keySet()){

            int antITrue = hm_true.get(subsek).hentForekomster();
            int antIFalse = 0;

            if (hm_false.containsKey(subsek)){
                antIFalse = hm_false.get(subsek).hentForekomster();
            }

            int antForsok = antITrue + antIFalse;
            int antSuksesser = antITrue;
            double sannsynlighet = 0.5;
            AlternativeHypothesis alt = AlternativeHypothesis.GREATER_THAN;

            double p = BinomialTest(antForsok, antSuksesser, sannsynlighet, alt);
            System.out.println(p);
        }
    }
}    


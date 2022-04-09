import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.Scanner;
import java.io.FileNotFoundException;

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
        
        System.out.println(monitor_true.analyserSiste(navnPaaMappe));
        System.out.println(monitor_false.analyserSiste(navnPaaMappe));
        

        System.exit(1);
    }
}    


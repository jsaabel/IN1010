import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Oblig5Hele {

    private static int antTraader = 8;

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Laster inn dominante subsekvenser...");
        
        //Oppretter to monitorer
        Monitor2 trueMonitor = new Monitor2();
        Monitor2 falseMonitor = new Monitor2();

        //Sjekker om det sendes inn en mappe som argument fra terminalen.
        String mappe;

        if (args.length != 0) {
            mappe = args[0];
        }
        else {
            System.out.println("Mappe ikke sendt inn.");
            return;
        }
        
        try {
            ArrayList<Thread> traadListeTrue = new ArrayList<>();
            ArrayList<Thread> traadListeFalse = new ArrayList<>();
  
            ArrayList<ArrayList<String>> filListe = hentFilListe(mappe);
     
            ArrayList<String> filListeTrue = filListe.get(0);
            ArrayList<String> filListeFalse = filListe.get(1);
            
            
            for (String e : filListeTrue) {
                LeseTrad tradRun = new LeseTrad(mappe + "/" + e, trueMonitor);
                Thread traad = new Thread(tradRun);
                
                traadListeTrue.add(traad);
                traad.start();
            }
            
            for (String e : filListeFalse) {
                LeseTrad tradRun = new LeseTrad(mappe + "/" + e, falseMonitor);
                Thread traad = new Thread(tradRun);
                
                traadListeFalse.add(traad);
                traad.start();
            }

            
            for (Thread traad : traadListeTrue) {
                traad.join();

            }

            for (Thread traad : traadListeFalse) {
                traad.join();
            }
            
        }
        catch (Exception e) {
            System.out.print("Feil ved sett inn i HashMap");
            return;
        }


        //Oppretter teller for aa telle ned antall
        trueMonitor.settTeller();
        falseMonitor.settTeller();
        try {
            ArrayList<Thread> traadListeFletteTrue = new ArrayList<>();
            ArrayList<Thread> traadListeFletteFalse = new ArrayList<>();

            //Fletting for True
            for (int trueIndeks = 0; trueIndeks < antTraader; trueIndeks++) {
                FletteTrad tradRun = new FletteTrad(trueMonitor);
                Thread traad = new Thread(tradRun);
                
                traadListeFletteTrue.add(traad);
                traad.start();
            }

            //Fletting for False
            for (int falseIndeks = 0; falseIndeks < antTraader; falseIndeks++) {
                FletteTrad tradRun = new FletteTrad(falseMonitor);
                Thread traad = new Thread(tradRun);
                
                traadListeFletteFalse.add(traad);
                traad.start();
            }

            for (Thread traad : traadListeFletteTrue) {
                traad.join();
            }

            for (Thread traad : traadListeFletteFalse) {
                traad.join();
            }
            
        }
        catch (InterruptedException e) {
            System.out.println("Fletting gikk galt.");
        }

        dominanteSubsekvenser(trueMonitor, falseMonitor);
        
    }

    private static void dominanteSubsekvenser(Monitor2 trueMonitor, Monitor2 falseMonitor) {
        HashMap<String, Subsekvens> trueHashMap = trueMonitor.taUtHashMap();
        HashMap<String, Subsekvens> falseHashMap = falseMonitor.taUtHashMap();

        System.out.println("Dominante subsekvenser: ");

        for (String nokkel : trueHashMap.keySet()) {

            int trueAntall = trueHashMap.get(nokkel).hentAntall();
            int falseAntall;

            if (falseHashMap.containsKey(nokkel)) {
                falseAntall = falseHashMap.get(nokkel).hentAntall();
            }

            else {
                falseAntall = 0;
            }

            if ((trueAntall - falseAntall) >= 7) {
                System.out.println(nokkel);
            }
        }
    }

    //Metode for aa hente filer fra mappe
    private static ArrayList<ArrayList<String>> hentFilListe(String mappe) throws FileNotFoundException {
        ArrayList<ArrayList<String>> liste= new ArrayList<>();

        ArrayList<String> filerTrue = new ArrayList<>();
        ArrayList<String> filerFalse = new ArrayList<>();
        
        File metadata = new File(mappe + "/" + "metadata.csv");
        Scanner sc = new Scanner(metadata);

        while (sc.hasNextLine()) {
            String[] biter = sc.nextLine().split(",");
            if (biter[1].equals("True")) {
                filerTrue.add(biter[0]);
            }

            else if (biter[1].equals("False")) {
                filerFalse.add(biter[0]);
            }
        }

        liste.add(filerTrue);
        liste.add(filerFalse);
        
        sc.close();
        
        return liste;
        
    }
}


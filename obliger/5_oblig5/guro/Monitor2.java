import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Monitor2 {
    private ArrayList<HashMap<String, Subsekvens>> hashBeholder;
    private static Lock laas = new ReentrantLock();
    private Condition ledig = laas.newCondition();
    private int teller = 0;

    public Monitor2() {
        hashBeholder = new ArrayList<HashMap<String, Subsekvens>>();
    }

    public int hentTeller() {
        return teller;
    }

    public void settTeller() {
        teller = hentStoerrelse();
    }

    private void tellNed() {
        teller --;
    }

    private boolean ledig() {
        if (hentTeller() == 1) {
            ledig.signalAll();
            return true;
        }
        return (hentStoerrelse() >= 2);
    }
    
    //Setter inn nytt HashMap i listen
    public void settInnHashMap(HashMap<String, Subsekvens> hashMap) {
        laas.lock();
        try {
            hashBeholder.add(hashMap);
        }
        finally {
            if (hentStoerrelse() >= 2) {
                ledig.signalAll();
            }
    
            laas.unlock();
        }
    }

    //Tar ut vilkaarlig HashMap fra listen
    public HashMap<String, Subsekvens> taUtHashMap() {
        Random rn = new Random();
        int randomInt = rn.nextInt(hentStoerrelse());
        return hashBeholder.remove(randomInt);
    }

    public ArrayList<HashMap<String, Subsekvens>> taUtToHashMap() throws InterruptedException {
        laas.lock();
        try {
            ArrayList<HashMap<String, Subsekvens>> liste = new ArrayList<>(); 

            //Venter paa signal om at det er mulig aa hente ut to hashMap.
            if (hentStoerrelse() < 2) {
                while (!ledig()) {
                    ledig.await();
                }
            }

            if (hentTeller() != 1) {
                tellNed();
                liste.add(taUtHashMap());
                liste.add(taUtHashMap());
            }
        
            return liste;
            
        }
        finally {
            laas.unlock();
        }
    }

    public int hentStoerrelse() {
        return hashBeholder.size();
    }

    //Leser fra fil
    public static HashMap<String, Subsekvens> lesFraFil(String filnavn) throws FileNotFoundException {
        laas.lock();
        try {
            HashMap<String, Subsekvens> nyHashMap = new HashMap<>();
            boolean gyldigLinje = true;
            File personFil = new File(filnavn);
            Scanner scanner = new Scanner(personFil);

            while (gyldigLinje && scanner.hasNextLine()) {
                String linje = scanner.nextLine();
                if (linje.length() < 3) {
                        
                    System.out.println("Ugyldig linje");
                    gyldigLinje = false;
                }

                else {
                    for (int teller = 0; teller <= (linje.length()-3); teller++) {
                        String substring = linje.substring(teller,(teller+3));
                        Subsekvens ss = new Subsekvens(substring);
                        
                        if (!(nyHashMap.containsKey(substring))) {
                            nyHashMap.put(substring,ss);
                        }
                    }
                }
            }

            scanner.close();
            return nyHashMap;
        }
        finally{
            laas.unlock();
        }
    }

    public HashMap<String, Subsekvens> hentElementFraBeholder(int indeks) {
        return hashBeholder.get(0);
    }

    public void skrivUtHashMap(HashMap<String, Subsekvens> hashMap) {
        for (Subsekvens s : hashMap.values()) {
            System.out.print(s);
        }
    }

    //Kombinerer to HashMap's
    public static HashMap<String, Subsekvens> kombinerHashMap(HashMap<String, Subsekvens> forsteHashMap, HashMap<String, Subsekvens> andreHashMap) {
        laas.lock();
        try {
            HashMap<String, Subsekvens> nyHashMap = new HashMap<>();
            
            for (String s : forsteHashMap.keySet()) {
                nyHashMap.put(s, forsteHashMap.get(s));
            }

            for (String s : andreHashMap.keySet()) {
                if (nyHashMap.containsKey(s)) {
                    int verdiAndre = andreHashMap.get(s).hentAntall();
                    nyHashMap.get(s).endreAntall(verdiAndre);
                }

                else{
                    nyHashMap.put(s, andreHashMap.get(s));
                }
            }

            return nyHashMap;
        }
        finally {
            laas.unlock();
        }
    }
}
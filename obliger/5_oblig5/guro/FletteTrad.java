import java.util.ArrayList;
import java.util.HashMap;

public class FletteTrad implements Runnable {
    private Monitor2 monitor;

    public FletteTrad(Monitor2 monitor) {
        this.monitor = monitor;
    }
    
    @Override
    public void run() {
        while (monitor.hentTeller() > 1) {
            try {
                //Fletting av to HashMaps som blir sendt hit som to elementer i en liste
                ArrayList<HashMap<String, Subsekvens>> liste = monitor.taUtToHashMap();
                if (liste.size() != 0) {
                    HashMap<String, Subsekvens> hashMap1 = liste.get(0);
                    HashMap<String, Subsekvens> hashMap2 = liste.get(1);

                    monitor.settInnHashMap(Monitor2.kombinerHashMap(hashMap1, hashMap2));
        
                }
            }
            catch (InterruptedException e) {
                System.out.println("Feil oppstaatt: Traad venter eller er okkupert");

            }
        }
    }
}

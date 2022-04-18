import java.io.FileNotFoundException;
import java.util.HashMap;

public class LeseTrad implements Runnable {
    private Monitor2 monitor;
    private String filnavn;

    public LeseTrad(String filnavn, Monitor2 monitor) {
        this.monitor = monitor;
        this.filnavn = filnavn;
    }

    @Override
    public void run() {
        try {
            HashMap<String, Subsekvens> hashMap = Monitor2.lesFraFil(filnavn);
            monitor.settInnHashMap(hashMap);
        }
        catch (FileNotFoundException e) {
            System.out.println("Finner ikke fil.");
        }
    }
}

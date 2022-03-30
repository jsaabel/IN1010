import java.io.FileNotFoundException;
import java.io.File;
import java.util.HashMap;

public class Hovedprogram{
    public static void main(String[] args){
        
        String navnPaaMappe = args[0];
        
        Monitor1 monitor = new Monitor1();

        File f = new File(navnPaaMappe);
        String[] filer = f.list();

        for (String fil : filer){

            if (fil.equals("metadata.csv")){
                continue; // Gjoer det enkelt her. Forandres senere.
            }

            try{
                LeseTrad trad = new LeseTrad(navnPaaMappe + "/" + fil, monitor);
                new Thread(trad).start();
            }

            catch(Exception e){
                System.out.println(e);
            }
        }

        // Fletting
        while (monitor.hentAntall() > 1){
            HashMap<String, Subsekvens> hm = monitor.slaaSammen(monitor.taUt(), monitor.taUt());
            monitor.settInn(hm);
        }

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


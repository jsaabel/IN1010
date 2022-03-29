import java.io.FileNotFoundException;
import java.io.File;
import java.util.HashMap;

public class Oblig5Del1{
    public static void main(String[] args){
        
        String navnPaaMappe = args[0];
        
        SubsekvensRegister reg = new SubsekvensRegister();

        File f = new File(navnPaaMappe);
        String[] filer = f.list();

        for (String fil : filer){

            if (fil.equals("metadata.csv")){
                continue; // Gjoer det enkelt her. Forandres senere.
            }

            try{
                reg.lesInnImmunrepertoar(navnPaaMappe + "/" + fil);
            }

            catch(FileNotFoundException e){
                System.out.println("Fil ikke funnet.");
            }
        }

        // Fletting
        while (reg.hentAntall() > 1){
            HashMap<String, Subsekvens> hm = reg.slaaSammen(reg.taUt(), reg.taUt());
            reg.settInn(hm);
        }

        HashMap<String, Subsekvens> res = reg.taUt();

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


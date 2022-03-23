import java.io.FileNotFoundException;
import java.io.File;
import java.util.HashMap;

public class Testprogram{
    public static void main(String[] args){
        
        String navnPaaMappe = args[0];
        
        SubsekvensRegister reg = new SubsekvensRegister();

        File f = new File(navnPaaMappe);
        String[] filer = f.list();
        
        for (String fil : filer){

            if (fil.equals("metadata.csv")){
                break;
            }

            try{
                reg.lesInnImmunrepertoar(navnPaaMappe + "/" + fil);
            }

            catch(FileNotFoundException e){
                System.out.println("Fil ikke funnet.");
            }
        }

        System.out.println("Antall i hashBeholder: " + reg.hentAntall());

        // Fletting
        while (reg.hentAntall() > 1){
            HashMap<String, Subsekvens> hm = reg.slaaSammen(reg.taUt(), reg.taUt());
            reg.settInn(hm);
            System.out.println("Antall i hashBeholder: " + reg.hentAntall());

        }

        HashMap<String, Subsekvens> res = reg.taUt();

        for (Subsekvens subsek: res.values()){
        
            System.out.println(subsek);
        }

        

     

    }

}    


import java.io.FileNotFoundException;
import java.util.HashMap;

public class MittTestprogram{
    public static void main(String[] args){
        
        String testString = "ABCDBCD";

        for (int i=0; i < testString.length() - 2; i++){
        
            String ss = testString.substring(i, i + 3);

            System.out.println(ss);
        }

        System.out.println("Tester Subsekvensregister...");
        
        SubsekvensRegister reg = new SubsekvensRegister();

        try{
            reg.lesInnImmunrepertoar("TestData/fil1.csv");
        }

        catch(FileNotFoundException e){
            System.out.println("Fil ikke funnet.");
        }

        int count = reg.hentAntall();
        System.out.println("Antall i hashBeholder: " + count);

        System.out.println("Tester aa hente fra Subsekvensregister...");


        HashMap<String, Subsekvens> hm = reg.taUt();

        for (Subsekvens subsek: hm.values()){
        
            System.out.println(subsek);
        }

        System.out.println("\nTester Oppgave 4 ...");

        
        SubsekvensRegister reg2 = new SubsekvensRegister();

        try{
            reg2.lesInnImmunrepertoar("fil1.csv");
            reg2.lesInnImmunrepertoar("fil2.csv");
        }

        catch(FileNotFoundException e){
            System.out.println("Fil ikke funnet.");
        }

        HashMap<String, Subsekvens> hm1 = reg2.taUt();
        HashMap<String, Subsekvens> hm2 = reg2.taUt();

        HashMap<String, Subsekvens> hm3 = reg2.slaaSammen(hm1, hm2);

        for (Subsekvens subsek: hm3.values()){
        
            System.out.println(subsek);
        }
     

    }

}    


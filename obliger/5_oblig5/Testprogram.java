import java.io.FileNotFoundException;
import java.util.HashMap;

public class Testprogram{
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


     

    }

}    


import java.util.ArrayList;
import java.util.HashMap;
import java.io.File; // used?
import java.io.FileReader; //used?
import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

public class SubsekvensRegister{

        private ArrayList<HashMap<String, Subsekvens>> hashBeholder;

        // Konstruktoer
        public SubsekvensRegister(){

            hashBeholder = new ArrayList<HashMap<String, Subsekvens>>();
        }

        // Sett inn HashMap
        public void settInn(HashMap<String, Subsekvens> hm){

            hashBeholder.add(hm);
        }
        
        // Ta ut HashMap --- OBS: Skal elementet fjernes eller ei???
        public HashMap<String, Subsekvens> taUt(){

            return hashBeholder.remove(0); // foerste element
        }
        
        // Returnere antall HashMaps
        public int hentAntall(){

            return hashBeholder.size();
        }

        //HashMap<String, Subsekvens> lesInnImmunrepertoar(
        // Lese inn immunrepertoar (Oppgave 3)
        // Ta med NoSuchElementException, IOException?
        public HashMap<String, Subsekvens> lesInnImmunrepertoar(String filnavn)
            throws FileNotFoundException{
        
            HashMap<String, Subsekvens> hm = new HashMap<String, Subsekvens>();
            File innFil = new File(filnavn);
            Scanner inn = new Scanner(innFil);

            while (inn.hasNextLine()){

                String linje = inn.nextLine();
                for (int i=0; i < linje.length() - 2; i++){
                    String ss = linje.substring(i, i + 3);
                    System.out.println(ss); // TEMP
                    if (!hm.containsKey(ss)){
                        Subsekvens sk = new Subsekvens(ss);
                        hm.put(ss, sk);
                    }
                }
            }
            settInn(hm);

            return hm;
        }
        

}    


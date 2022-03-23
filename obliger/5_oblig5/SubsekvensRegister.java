import java.util.ArrayList;
import java.util.HashMap;

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
        

}    


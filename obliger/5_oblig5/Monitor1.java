import java.util.concurrent.* // mer spesifikt?

public class Monitor1{

    SubsekvensRegister reg = new SubsekvensRegister();
    private Lock laas;

    // Sett inn HashMap
    public void settInn(HashMap<String, Subsekvens> hm){
        
        reg.settInn(hm);

    }
    
    // Ta ut HashMap 
    public HashMap<String, Subsekvens> taUt(){

        return reg.taUt(); // foerste element
    }
    
    // Returnere antall HashMaps
    public int hentAntall(){

        return reg.hentAntall();
    }

    public HashMap<String, Subsekvens> lesInnImmunrepertoar(String filnavn)
        throws FileNotFoundException{

        return reg.lesInnImmunrepertoar(filnavn);
    
    }

    public static HashMap<String, Subsekvens> slaaSammen(
            HashMap<String, Subsekvens> en, HashMap<String, Subsekvens> to){

        return reg.slaaSammen(en, to);
    }


}    


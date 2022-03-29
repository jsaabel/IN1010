import java.util.concurrent.locks.Lock; 
import java.util.concurrent.locks.ReentrantLock; 
import java.util.HashMap;
import java.io.FileNotFoundException;

public class Monitor1{

    private SubsekvensRegister reg;
    private Lock laas;  

    // Konstruktoer
    public Monitor1(){

        reg = new SubsekvensRegister();
        laas = new ReentrantLock(); // TEMP true?

    }
    
    // Sett inn HashMap
    public void settInn(HashMap<String, Subsekvens> hm){
        
        laas.lock();
        try{
            reg.settInn(hm);
        }

        finally{
            laas.unlock();
        }


    }
    
    // Ta ut HashMap 
    public HashMap<String, Subsekvens> taUt(){

        laas.lock();

        try{
            return reg.taUt(); // foerste element
        }

        finally{
            laas.unlock();
        }
    }
    
    // Returnere antall HashMaps
    public int hentAntall(){

        return reg.hentAntall();
    }

    // TEMP OBS Tror kanskje ikke denne trengs, siden HMs blir lest inn av traad?
    public HashMap<String, Subsekvens> lesInnImmunrepertoar(String filnavn)
        throws FileNotFoundException{

        laas.lock();

        try{
            return reg.lesInnImmunrepertoar(filnavn);
        }

        finally{
            laas.unlock();
        }
    }

    public HashMap<String, Subsekvens> slaaSammen(
            HashMap<String, Subsekvens> en, HashMap<String, Subsekvens> to){

        laas.lock();

        try{
            return reg.slaaSammen(en, to);
        }

        finally{
            laas.unlock();
        }
    }

}    


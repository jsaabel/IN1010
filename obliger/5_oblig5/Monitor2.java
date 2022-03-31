import java.util.concurrent.locks.Lock; 
import java.util.concurrent.locks.ReentrantLock; 
import java.util.concurrent.locks.Condition;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Monitor2{

    private SubsekvensRegister reg;
    private Lock laas;  
    private Condition minstTo;

    // Konstruktoer
    public Monitor2(){

        reg = new SubsekvensRegister();
        laas = new ReentrantLock(); // TEMP true?
        minstTo = laas.newCondition();

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

    public ArrayList<HashMap<String, Subsekvens>> hentUtTo() throws InterruptedException{

        laas.lock();

        try{
            while (hentAntall() < 2){
                minstTo.await();
            }
            ArrayList<HashMap<String, Subsekvens>> hms = new ArrayList<HashMap<String, Subsekvens>>();
            hms.add(taUt());
            hms.add(taUt());
            return hms;
        }

        finally{
            laas.unlock();
        }
    }
    
    // Returnere antall HashMaps
    // OBS TEMP trenger man lock her??
    public int hentAntall(){

        laas.lock();

        try{
            return reg.hentAntall();
        }
        finally{
            laas.unlock();
        }
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


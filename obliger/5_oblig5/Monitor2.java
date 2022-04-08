import java.util.concurrent.locks.Lock; 
import java.util.concurrent.locks.ReentrantLock; 
import java.util.concurrent.locks.Condition;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File; 
import java.util.Scanner;

public class Monitor2{

    private SubsekvensRegister register;
    private ArrayList<LeseTrad> leseTrader;
    private Lock laas;  
    private Condition sattInnNy;
    // Holder styr paa hvor lenge fletteTraadene skal kjoere
    private Lock fletteAntallLaas;  
    private int antallGangerAaSetteInnTo;

    // Konstruktoer
    public Monitor2(){

        register = new SubsekvensRegister();
        laas = new ReentrantLock(); 
        sattInnNy = laas.newCondition();
        leseTrader = new ArrayList<LeseTrad>();
        fletteAntallLaas = new ReentrantLock();
    }

    /**
     * De foelgende metodene brukes for aa holde styr paa hvor lenge/ofte
     * flettetraadene skal kjoeres. Dette tallet settes i hovedprogrammet,
     * og er n-1 for n filer med DNA-sekvenser.
     */
    public void settAntallGangerAaSetteInnTo(int antall){

        this.antallGangerAaSetteInnTo = antall;

    }

    public void tellNedAntallGangerAaSetteInnTo(){

        fletteAntallLaas.lock();
        
        try{
            antallGangerAaSetteInnTo--;
        }

        finally{
            fletteAntallLaas.unlock();
        }
    }

    public int hentAntallGangerAaSetteInnTo(){

        return antallGangerAaSetteInnTo;
    }

    // Lagre lesetrader
    public void lagreLeseTrad(LeseTrad trad){

        leseTrader.add(trad);

    }

    // Hente lesetrader
    public ArrayList<LeseTrad> hentLeseTrader(){

        return leseTrader;
    }
    
    /**
     * Resten av metodene styrer innsetting, henting og fletting av HashMapsene.
     */
    // Sett inn HashMap
    public void settInn(HashMap<String, Subsekvens> hm){
        
        laas.lock();
        
        try{
            register.settInn(hm);
            sattInnNy.signalAll();
        }

        finally{
            laas.unlock();
        }
    }
    
    // Ta ut HashMap 
    public HashMap<String, Subsekvens> taUt(){

        laas.lock();
        HashMap<String, Subsekvens> hm = null;
        
        try{
            while (hentAntall() == 0){
                sattInnNy.await();
            }
        }

        catch (InterruptedException e){
            System.out.println("taUt interrupted");}

        finally{
            laas.unlock();
        }

        return register.taUt(); // foerste element

    }

    // Ta ut to HashMaps
    public ArrayList<HashMap<String, Subsekvens>> hentUtTo() 
            throws InterruptedException{

        laas.lock();

        try{
            while(hentAntall() < 2){
                sattInnNy.await();
            }

            ArrayList<HashMap<String, Subsekvens>> hms = 
                new ArrayList<HashMap<String, Subsekvens>>();
            hms.add(taUt());
            hms.add(taUt());

            return hms;
        }

        finally{
             laas.unlock();
        }
    }
    
    // Returner antall HashMaps
    public int hentAntall(){

        return register.hentAntall();
    }

    // Les inn immunrepertoar fra fil
    public HashMap<String, Subsekvens> lesInnImmunrepertoar(String filnavn)
        throws FileNotFoundException{

            return register.lesInnImmunrepertoar(filnavn);
    }

    // Slaa sammen to HashMaps
    public HashMap<String, Subsekvens> slaaSammen( 
            HashMap<String, Subsekvens> en, 
            HashMap<String, Subsekvens> to){

        return register.slaaSammen(en, to);
    }
}    


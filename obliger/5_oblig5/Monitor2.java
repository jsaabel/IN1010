import java.util.concurrent.locks.Lock; 
import java.util.concurrent.locks.ReentrantLock; 
import java.util.concurrent.locks.Condition;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Monitor2{

    private SubsekvensRegister register;
    private ArrayList<LeseTrad> leseTrader;
    private Lock laas;  
    private Lock fletteAntallLaas;  
    private int antallGangerAaSetteInnTo;
    private Condition sattInnNy;

    // Konstruktoer
    public Monitor2(){

        register = new SubsekvensRegister();
        laas = new ReentrantLock(); 
        sattInnNy = laas.newCondition();
        leseTrader = new ArrayList<LeseTrad>();
        fletteAntallLaas = new ReentrantLock();
        antallGangerAaSetteInnTo = 0;

    }

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
    public ArrayList<LeseTrad> getLeseTrader(){
    
        return leseTrader;
    }
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

    // Sett inn flettet HashMap
    // foreloepig samme som "vanlig" settInn .. hvorfor trengs denne?
     //public void settInnFlettet(HashMap<String, Subsekvens> hm){
 
     //   laas.lock();
     //   try{
     //       settInn(hm);
     //       System.out.println("Utfoert settInnFlettet");
     //       sattInnNy.signalAll();
     //   }
 
     //   finally{
     //        laas.unlock();
     //   }
     //}
    
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

    public ArrayList<HashMap<String, Subsekvens>> hentUtTo() 
            throws InterruptedException{

        laas.lock();
        try{
            while(hentAntall() < 2){
                sattInnNy.await();
            }
            System.out.println("Utfoerer hentUtTo");

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
    
    // Returnere antall HashMaps
    // OBS TEMP trenger man lock her??
    public int hentAntall(){
        return register.hentAntall();
    }

    public HashMap<String, Subsekvens> lesInnImmunrepertoar(String filnavn)
        throws FileNotFoundException{
            return register.lesInnImmunrepertoar(filnavn);
    }

    public HashMap<String, Subsekvens> slaaSammen( // static?
            HashMap<String, Subsekvens> en, 
            HashMap<String, Subsekvens> to){

        return register.slaaSammen(en, to);


    }

}    


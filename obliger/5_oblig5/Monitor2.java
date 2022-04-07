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

    private ArrayList<HashMap<String, Subsekvens>> register;
    private ArrayList<LeseTrad> leseTrader;
    private Lock laas;  
    private Condition sattInnNy;

    // Konstruktoer
    public Monitor2(){

        register = new ArrayList<HashMap<String, Subsekvens>>();
        laas = new ReentrantLock(); 
        sattInnNy = laas.newCondition();
        leseTrader = new ArrayList<LeseTrad>();

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
            register.add(hm);
            System.out.println("Utfoert settInn");
            sattInnNy.signalAll();
        }

        finally{
            laas.unlock();
        }
    }

    // Sett inn flettet HashMap
    // foreloepig samme som "vanlig" settInn .. hvorfor trengs denne?
     public void settInnFlettet(HashMap<String, Subsekvens> hm){
 
        laas.lock();
        try{
            settInn(hm);
            System.out.println("Utfoert settInnFlettet");
            sattInnNy.signalAll();
        }
 
        finally{
             laas.unlock();
        }
     }
    
    // Ta ut HashMap 
    public HashMap<String, Subsekvens> taUt(){

        laas.lock();
        System.out.println("Utfoerer taUt");

        HashMap<String, Subsekvens> hm = null;
        try{
            while (hentAntall() == 0){
                System.out.println("taUt venter");
                sattInnNy.await();
            }
            System.out.println("taUt returnerer");
        }

        catch (InterruptedException e){
            System.out.println("taUt interrupted");}
        finally{
            laas.unlock();
        }

        return register.remove(0); // foerste element

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
        return register.size();
    }

    public HashMap<String, Subsekvens> lesInnImmunrepertoar(String filnavn)
        throws FileNotFoundException{
            HashMap<String, Subsekvens> hm = new HashMap<String, Subsekvens>();
            File innFil = new File(filnavn);
            Scanner inn = new Scanner(innFil);

            while (inn.hasNextLine()){

                String linje = inn.nextLine();
                
                // Stopper hvis linjen er kortere enn 3 tegn
                if (linje.length() < 3){
                    break; // implementer IOException her?
                }

                for (int i=0; i < linje.length() - 2; i++){
                    String ss = linje.substring(i, i + 3);

                    if (!hm.containsKey(ss)){
                        Subsekvens sk = new Subsekvens(ss);
                        hm.put(ss, sk);
                    }
                }
            }
            return hm;
    }

    public static HashMap<String, Subsekvens> slaaSammen(
            HashMap<String, Subsekvens> en, 
            HashMap<String, Subsekvens> to){


        System.out.println("Utfoerer slaaSammen");
        for (Subsekvens subsek : en.values()){
            if (!to.containsKey(subsek.subsekvens)){
                to.put(subsek.subsekvens, subsek);
            }
            else {
                Subsekvens aktSubsek = to.get(subsek.subsekvens);
                aktSubsek.endreForekomster(subsek.hentForekomster());
            }
        }

        return to;


    }

}    


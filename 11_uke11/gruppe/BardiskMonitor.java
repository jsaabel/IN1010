import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BardiskMonitor{

    Lock lock = new ReentrantLock();
    Condition erIkkeFull = lock.newCondition();
    Condition erIkkeTom = lock.newCondition();

    Leveranse[] leveranser = new Leveranse[10];
    int leveranseTeller = 0;

    public void settFram(Leveranse l){
        lock.lock();
        try{
            if (!(leveranseTeller < leveranser.length)){
                erIkkeFull.await();}
            leveranser[leveranseTeller++] = l;
            erIkkeTom.signalAll();

        }

        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            lock.unlock()
        }
    
    }

    public Leveranse leverLeveranse(){
        Leveranse hentet = null;
        lock.lock();
        try{
            if(leveranseTeller == 0) {
                erIkkeTom.await();
            }
            hentet = leveranser[--leverLeveranse]; // -- FOER variabelen
            erIkkeFull.signalAll();
        }
    }

    public boolean erFerdig(){
        Boolean erTom = leverLeveranse == 0;
        Boolean }
     


}    


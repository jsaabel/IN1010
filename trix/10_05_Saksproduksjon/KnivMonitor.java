import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

class KnivMonitor{

  ArrayList<Kniv> kniver;
  Lock laas;
  Condition sattInn;

  public KnivMonitor(){
    kniver = new ArrayList<Kniv>();
    laas = new ReentrantLock();
    sattInn = laas.newCondition();
  }

  public void settInnKniv(Kniv enKniv){

    laas.lock();
    try{
      kniver.add(enKniv);
      System.out.println("Kniv satt inn");
      sattInn.signalAll();
    }

    finally{
      laas.unlock();
    }
    

  }

  public Kniv[] hentToKniver(){

    laas.lock();
    try{
      while (hentAntallKniver() < 2){
        sattInn.await();
      }

      Kniv[] knivene;
      Kniv en = kniver.remove(0);
      Kniv to = kniver.remove(0);

      knivene = new Kniv[2];
      knivene[0] = en;
      knivene[1] = to;
      return knivene;
    }

    catch (InterruptedException e){
      System.out.println("hentToKniver avbrutt");
    }

    finally{
      laas.unlock();
    }
  }

  public int hentAntallKniver(){
    return kniver.size();
  }

}

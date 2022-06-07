import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

class SaksMonitor{

  ArrayList<Saks> sakser;
  Lock laas;

  public SaksMonitor(){
    sakser = new ArrayList<Saks>();
    laas = new ReentrantLock();
  }

  public void settInnSaks(Saks enSaks){

    laas.lock();
    try{
      sakser.add(enSaks);
    }
    finally{
      laas.unlock();
    }
  }

  public int hentAntall(){
    return sakser.size();
  }


}

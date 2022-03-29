import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Program som viser at vranglas (deadlock) kan oppstaa
// Skrevet av Stein Gjessing 2017 - 2021

class Bil implements Runnable {
   private Veistump enVei, toVei;
   private int ind;
   public Bil (Veistump en, Veistump to, int i) {
        enVei = en;  toVei = to;
        ind = i;
   }
   public void run ( ) { 
           System.out.println(" Bil nr " + ind + " venter pa a passere " + enVei.del );
        enVei.taVei();
        // Det tar litt tid a kjore dette veistykket:
        try {   Thread.sleep(50);  }
           catch (InterruptedException e) { System.out.println("FEIL"); System.exit(1);}
           System.out.println(" Bil nr " + ind + "  venter pa a passere " + toVei.del );
        toVei.taVei();
        enVei.friVei();
        // Det tar litt tid a kjore dette veistykket:
        try {   Thread.sleep(50);  }
           catch (InterruptedException e) { System.out.println("FEIL"); System.exit(1);}        
        toVei.friVei();
           System.out.println(" Bil nr " + ind + "  har passert hele den smale veien ");
           System.out.println();
    }
}

class Veistump  {
   private Lock laas = new ReentrantLock();
   private Condition ledig = laas.newCondition();
   private boolean veiLedig = true;
   final String del;  
   public Veistump (String hvilken) {
       del = hvilken;
   }
   public void taVei() {
       laas.lock();
       try {
           while (! veiLedig) {             
               ledig.await();  
           }
           // Na er veien ledig , den er min
           veiLedig = false;
        }
        catch (InterruptedException e) {System.out.println("FEIL"); System.exit(1);}
	    finally {laas.unlock();}
  }
  public void friVei() {
 	  laas.lock();
 	  try{
 	      // System.out.println(" laser opp ");
            veiLedig= true;
            ledig.signal();
        }
        finally {laas.unlock();}
  }
}

class SmaltVeistykke2 {
   static Random ran = new Random();
   public static void main (String[] args) {
      Scanner inn = new Scanner(System.in);
      System.out.println(" ");
      System.out.println(" Main starter ");
      Veistump venstre = new Veistump(" venstre " );
      Veistump hoyre   = new Veistump(" hoyre ");
      for (int ind = 1; ind <= 20; ind ++) {     
          try {   Thread.sleep((int)(ran.nextFloat()*1000));  }
           catch (InterruptedException e) {System.out.println("FEIL"); System.exit(1);}     
          Bil  bilen1 = new Bil(venstre,hoyre,ind*2-1);
          new Thread(bilen1).start();          
          try {   Thread.sleep((int)(ran.nextFloat()*1000));  }
           catch (InterruptedException e) {System.out.println("FEIL"); System.exit(1);}          
          Bil  bilen2 = new Bil(hoyre,venstre, ind*2);
          new Thread(bilen2).start();
      }     
     System.out.println(" 40 biler er startet ");
     System.out.println(" Main er ferdig ");
  }
}

      


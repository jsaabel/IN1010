import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Program som viser at vranglas (deadlock) kan oppsta
// Skrevet av Stein Gjessing 2017 - 2021

class BilVenstre implements Runnable {
  Veistump smallVei;
  BilVenstre(Veistump vei) {
        smallVei = vei;
  }
  public void run ( ) {  
    for (int ind = 0; ind < 10; ind ++) {
        try {   Thread.sleep((int)(SmaltVeistykke.ran.nextFloat()*1000));  }
         catch (InterruptedException e) { System.out.println("FEIL"); System.exit(1);}  
           System.out.println(" Bil nr " + ind + " fra venstre skal passere den smale veien ");
        smallVei.taVenstre(); 
           System.out.println(" Bil nr " + ind + " fra venstre kjorer ");
        try {   Thread.sleep(40);  }
         catch (InterruptedException e) { System.out.println("FEIL"); System.exit(1);}
        smallVei.taHoyre(); 
        smallVei.friVenstre(); 
        try {   Thread.sleep(40);  }
         catch (InterruptedException e) { System.out.println("FEIL"); System.exit(1);}
        smallVei.friHoyre();
           System.out.println(" Bil nr " + ind + " fra venstre har passert den smale veien ");
           System.out.println();
     }
  }
}

class BilHoyre implements Runnable {
  Veistump smallVei;
  BilHoyre(Veistump vei) {
        smallVei = vei;
  }
  public void run ( ) { 
    for (int ind = 0; ind < 10; ind ++) { 
        try {   Thread.sleep((int)(SmaltVeistykke.ran.nextFloat()*1000));  }
         catch (InterruptedException e) { System.out.println("FEIL"); System.exit(1);}    
             System.out.println(" Bil nr " + ind + " fra hoyre skal passere den smale veien ");
        smallVei.taHoyre();
             System.out.println(" Bil nr " + ind + " fra hoyre kjorer ");
        try {   Thread.sleep(4);  }
         catch (InterruptedException e) { System.out.println("FEIL"); System.exit(1);}
        smallVei.taVenstre();
        smallVei.friHoyre();
        try {   Thread.sleep(4);  }
         catch (InterruptedException e) { System.out.println("FEIL"); System.exit(1);}
        smallVei.friVenstre();
          System.out.println(" Bil nr " + ind + " fra hoyre har passert den smale veien ");
          System.out.println();
     }
  }
}

class Veistump  {
    private Lock laas = new ReentrantLock();
    private Condition ledigVenstre  = laas.newCondition();
    private Condition ledigHoyre = laas.newCondition();

    private boolean venstreLedig = true;
    private boolean hoyreLedig   = true;

    void taVenstre() {
       laas.lock();
       try {
          while (! venstreLedig) {
              ledigVenstre.await(); 
          }
          // Na er venstreLedig.   Den er MIN!
          venstreLedig = false;    // opptatt for alle andre
       }
       catch (InterruptedException e) { System.out.println("FEIL"); System.exit(1);}
       finally {laas.unlock();}   
    }
    void taHoyre() {
       laas.lock();
       try {
          while (! hoyreLedig) {
               ledigHoyre.await(); 
          }
          // Na er hoyre ledig.   Den er MIN!
      hoyreLedig = false;    // opptatt for alle andre
      }
      catch (InterruptedException e) { System.out.println("FEIL"); System.exit(1);}
      finally {laas.unlock();}   
   }
   void friHoyre() {
       laas.lock();
       try {
            hoyreLedig= true;
            ledigHoyre.signal( );
        }
        finally {laas.unlock(); }
   }
   void friVenstre() {
  	   laas.lock();
  	   try {
            venstreLedig= true;
           ledigVenstre.signal();
        }
        finally {laas.unlock(); }
   }
}

class SmaltVeistykke {
   static Random ran = new Random();
   public static void main (String[] args) {
      Scanner inn = new Scanner(System.in);
      System.out.println(" ");
      System.out.println(" Main starter ");
      Veistump denneVeien = new Veistump();
      BilVenstre bileneV = new BilVenstre(denneVeien);
      BilHoyre   bileneH  = new BilHoyre(denneVeien);
      new Thread(bileneV).start();
      new Thread(bileneH).start();
      System.out.println(" 20 biler er startet opp ");
      System.out.println(" Main er ferdig ");
  }
}

      


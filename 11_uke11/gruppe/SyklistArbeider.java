public class SyklistArbeider implements Runnable{
     
    BardiskMonitor monitor;

    public SyklistArbeider(BardiskMonitor monitor){
        this.monitor = monitor;
    }

    @Override
    public void run(){
        while(!monitor.erFerdig())
    }

    // Naar det ikke er noen bestillinger som er klare maa syklisten vente 
    // utafor.
}    


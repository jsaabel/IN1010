public class KokkArbeider implements Runnable{

    private final int ANT_LEVERANSER = 1000;
    private BardiskMonitor monitor;


    public KokkArbeider(BardiskMonitor monitor){
        this.monitor = monitor;
    }


    @Override
    public void run(){
        for (int i=0; i < ANT_LEVERANSER; i++){
            Leveranse l = new Leveranse();
            monitor.settFram(l);
        }
        System.out.println("Kokken: Jeg er ferdig")
    }

    // Naar det er fullt maa kokken vente med aa sette fram neste bestilling
     

}    


public class LeseTrad implements Runnable{
    
    private Monitor1 monitor;
    private String filnavn;
    
    // Konstruktoer
    public LeseTrad(String filnavn, Monitor1 monitor){
        this.filnavn = filnavn;
        this.monitor = monitor;
    }

    @Override
    public void run(){
        try{
            monitor.lesInnImmunrepertoar(filnavn);
        }

        catch (InterruptedException e){
            ; // fortsett her
        }
    }
}    




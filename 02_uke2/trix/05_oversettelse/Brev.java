import java.util.ArrayList;
public class Brev {

    private String avsender;
    private String mottaker;
    private ArrayList<String> linjer;

    public Brev(String avs, String mot) {
    avsender = avs;
    mottaker = mot;
    linjer = new ArrayList<String>();
    }
    
    public void skrivLinje(String linje) {
    linjer.add(linje); 

    }

    public void lesBrev(){
       System.out.println("Hei " + mottaker);
       System.out.println();
       for (String l : linjer) {
           System.out.println(l);
       }

       System.out.println();
       System.out.println("Hilsen fra, ");
       System.out.println(avsender);
       
        
    }

}    


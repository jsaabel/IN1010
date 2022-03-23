import java.util.HashMap;

public class Hovedprogram{
    public static void main(String[] args){

        SubsekvensRegister reg = new SubsekvensRegister();

        Subsekvens a = new Subsekvens("abc");
        Subsekvens b = new Subsekvens("def");

        HashMap<String, Subsekvens> h = new HashMap<String, Subsekvens>();
        h.put("abc", a);
        reg.settInn(h);

        int antall = reg.hentAntall();

        System.out.println("Registeret inneholder " + antall + " elementer.");
     

    }

}    


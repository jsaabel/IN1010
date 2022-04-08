/**
 * Klasse som kan ta vare paa en subsekvens og et antall.
 */
public class Subsekvens{

    private int forekomster;
    public final String subsekvens;

    public Subsekvens(String ss){
        subsekvens = ss; 
        forekomster = 1;
    }

    public int hentForekomster(){
        return forekomster;
    }

    public void endreForekomster(int tall){
        forekomster += tall;
    }

    @Override
    public String toString(){
        return subsekvens + "," + forekomster;
    }
}    


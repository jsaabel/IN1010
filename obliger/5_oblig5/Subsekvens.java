/**
 * Klasse som kan ta vare paa en subsekvens og et antall.
 * ...
 */
public class Subsekvens{

    private int forekomster;
    public final String subsekvens;

    public Subsekvens(String ss){
        subsekvens = ss; // forekomster 0 eller 1?
        forekomster = 1;
    }

    public int hentForekomster(){
        return forekomster;
    }

    // (Temp - se naermere paa implementasjonen paa et senere tidspunkt)
    public void endreForekomster(int tall){
        forekomster += tall;
    }

    @Override
    public String toString(){
        return subsekvens + "," + forekomster;
    }





}    


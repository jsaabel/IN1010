/**
 * En abstract klasse som fungerer som grunnlag for legemiddel-subclasses.
 */
public abstract class Legemiddel{
        
    protected String navn; // navnet paa legemidellet
    protected int id; // unik identifikasjonsnummer (pos. heltall)
    // OBS: STATIC variable for "lastid"? Increment counter in 
    // constructor
    protected int pris; // legemiddelets pris (heltall) 
    protected double virkestoff; // menge virkestoff i mg (flyttall)

    /**
     * Jeg bruker en static variabel for aa holde styr paa idnumre.
     */
    protected static int sisteId;

    public int hentId(){
        return this.id;
    }

    public String hentNavn(){
        return this.navn;
    }

    /** Setter en ny pris for legemiddelet.
     * @param nyPris Leggemiddelets nye pris.
     */
    public void settNyPris(int nyPris){
        pris = nyPris;
    }

    /**
     * Konstruktoer.
     * Naar et nytt legemiddel blir opprettet (...) blir sisteId
     * inkrementert, slik at vi faar en ny unik id som kan gis til
     * legemiddelet.
     */
    public Legemiddel(String navn, int pris, double virkestoff) {
    
        sisteId++;

        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.id = sisteId;
    }
}    

/**
 * Klasse for et 'vanlig' legemiddel.
 */
class Vanlig extends Legemiddel {


    public Vanlig(String navn, int pris, double virkestoff){
    
        super(navn, pris, virkestoff);
    }

    public String toString(){
        return ""+ this.hentNavn()
            + " (id " + this.hentId() + ")"
            +": vanlig legemiddel.";
    }
    
}

/**
 * Klasse for et vanedannende legemiddel.
 */
class Vanedannende extends Legemiddel {

    private int styrke;

    // Konstruktoer
    public Vanedannende(String navn, int pris, double virkestoff, int styrke){

        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    /**
     * Henter legemiddelets vanedannende styrke
     * @return styrken
     */
    public int hentVanedannendeStyrke(){
        return this.styrke;
    }

    public String toString(){
        return "" + this.hentNavn()
            + " (id " + this.hentId() + ")"
            +": vanedannende legemiddel med styrke "
            + this.hentVanedannendeStyrke()
            + ".";
    }
}



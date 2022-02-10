import java.util.HashMap;

public class Student{

    private String navn;
    private HashMap<String, Fag> fag = new HashMap<String, Fag>;

    // Konstruktoer
    public Student(String navn){
        this.navn = navn;
    }

    // toString-metode
    public String toString(){
        return this.navn;
    }

    // oppgi antall fag 
    public int antallFag(){
        return 0;
    }

    // legg til fag
    public void leggTilFag(Fag etFag){
        if (fagFinnes(etFag)){
            System.out.println("Studenten tar allerede faget.");
        }
        else {
            fag.put(etFag.toString(), etFag);
        }
    }
    
    // fjern fag
    public void fjernFag(Fag etFag){
        if (!fagFinnes){
            System.out.println(this.toString() + " tar ikke dette faget.");
        }
        else {
            fag.remove(etFag.toString());
        }
    }
    
    // skriv ut alle fag
    public void skrivUtFag(){
        System.out.println("Denne studenten tar fagene...   ");
    }

    // HJELPEMETODER
    public boolean fagFinnes(Fag etFag){
        if (fag.containsValue(etFag)){
            return true;
        }
        return false;
    }
    
}    


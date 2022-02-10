import java.util.HashMap;

public class Fag{
   
    private String fagkode;
    private HashMap<String, Student> studenter = new HashMap<String, Student>();
        
    // Konstruktoer
    public Fag(String fagkode){
        this.fagkode = fagkode;
    }
    
    // toString-metode
    public String toString(){
        return this.fagkode;
    }

    // (t) oppgi antall studenter 
    public int antStudenter(){
        return studenter.size();
    }

    // (t) skriv ut studenter
    public void skrivUtStudenter(){
        System.out.println("Disse studentene tar " + this.fagkode + ":");
        for (Student s : studenter.values()){
            System.out.println(s.toString());
        }

    }

    // (t) legg til student
    // ... hva om studenten allerede finnes?
    public void leggTilStudent(Student student){
        if (studentFinnes(student)){
            System.out.println("Denne studenten er allerede registrert");
        }
        else {
        studenter.put(student.toString(), student);
        }
    }
    
    // (t) fjern student
    public void fjernStudent(Student student){
        if (!studentFinnes(student)){
            System.out.println("Denne studenten tar ikke faget.");
        }
        else {
            studenter.remove(student.toString());
        }

    }

    // HJELPEMETODER
    public boolean studentFinnes(Student student){
        if (studenter.containsValue(student)){
            return true;
        }
        return false;
    }

}    


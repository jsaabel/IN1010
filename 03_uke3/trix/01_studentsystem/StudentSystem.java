import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StudentSystem{

    private HashMap<String, Fag> fagliste = new HashMap<String, Fag>();
    private HashMap<String, Student> studentliste = new HashMap<String, Student>();

    public void lesFraFil(String filnavn) throws FileNotFoundException{
        // "Oppret'" fil og Scanner
        File fil = new File(filnavn);
        Scanner les = new Scanner(fil);


        Fag naavaerendeFag = null;

        while (les.hasNextLine()){

            String linje = les.nextLine();

            String firstChar = linje.substring(0,1);
            String identifier = "*";

            Student naavaerendeStudent = null;
        // Gaa gjennom linjene ...


            if (firstChar.equals(identifier)){ // Vi er paa en *-linje...

                String fagkode = linje.substring(1, linje.length());
                
                // sjekk om faget eksisterer, opprett hvis ikke
                if (!fagliste.containsKey(fagkode)){
                    opprettFag(fagkode);
                }

                naavaerendeFag = fagliste.get(fagkode);
            }

            else{ // Vi er paa en student-linje ...
            
                if (!studentliste.containsKey(linje)){
                    opprettStudent(linje);
                }

                naavaerendeStudent = studentliste.get(linje);
            }
            // Legg til fag til student og omvendt
            if (naavaerendeStudent != null){
                naavaerendeStudent.leggTilFag(naavaerendeFag);
                naavaerendeFag.leggTilStudent(naavaerendeStudent);
            }
        }
    }

    public void visMeny(){
        System.out.println("Vennligst velg funksjon: ");
        System.out.println("1 - Vis mest populaert fag");
        System.out.println("2 - Vis mest aktiv student");
        System.out.println("3 - Vis studenter i fag");
        System.out.println("4 - Vis fag til student");
        System.out.println("5 - Legg student til fag");
        System.out.println("6 - Fjern student fra fag");
        System.out.println("7 - Legg til ny student");
        System.out.println("8 - Legg til nytt fag");
        System.out.println("0 - Avslutt program");
    }

    public void brukerValg(){
        System.out.print("Oppgi valg: ");
        Scanner in = new Scanner(System.in);
        int valg = in.nextInt();
        System.out.println("");

    
        if (valg == 1){
            mestPopulaertFag();
        }

        else if (valg == 2){
            mestAktivStudent();
        }

        else if (valg == 3){
            System.out.print("Oppgi fagkode: ");
            String fagkode = userPrompt();

            Fag valgtFag = fagliste.get(fagkode);
            valgtFag.skrivUtStudenter();
        }

        else if (valg == 4){
            ;
        }

        else if (valg == 5){
            ;
        }

        else if (valg == 6){
            ;
        }

        else if (valg == 7){
            ;
        }

        else if (valg == 8){
            ;
        }

    }

    public void opprettFag(String fagkode){
        Fag nyttFag = new Fag(fagkode);
        fagliste.put(nyttFag.toString(), nyttFag);
    }

    public void opprettStudent(String navn){
        Student nyStudent = new Student(navn);
        studentliste.put(nyStudent.toString(), nyStudent);
    }

    public void skrivUt(){
        for (Fag f: fagliste.values()){
            f.skrivUtStudenter();
        }
    }
                       
    public void mestPopulaertFag(){
        String mestPopulaert = null;
        int flestHittil = 0;

        for (Fag f: fagliste.values()){
            if (f.antStudenter() > flestHittil){
            flestHittil = f.antStudenter();
            mestPopulaert = f.toString();
            }
        }

        System.out.println("Det mest populaere faget er " + mestPopulaert);

    }

    public void mestAktivStudent(){
        String mestAktiv = null;
        int flestHittil = 0;

        for (Student s: studentliste.values()){
            if (s.antallFag() > flestHittil){
                flestHittil = s.antallFag();
                mestAktiv = s.toString();
            }
        }
        System.out.println("Den mest aktive studenten er " + mestAktiv);

    }

    public String userPrompt(){
        
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

}

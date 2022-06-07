import java.io.File;
import java.io.FileNotFoundException;

class Studentsystem{

  public static void main(String args[]) throws FileNotFoundException{



  }

  // Les inn fra File
  public void lesInnFil(String filnavn) throws FileNotFoundException{

  }
  // Finn mest populaert fag
  String mestPopulaertFag(){

  }

  // Student med flest fag
  // Studenter som tar et fag
  // Skriv ut alle fag en student tar
  // Legg til nytt fag til student
  // Legg til student til fag
  // Fjern fag fra student
  // Fjern student fra fag
  // Legg til ny student
  // Legg til nytt fag
  // Avslutt program
}

class Student{
  String navn;
  ArrayList<Fag> fag;

  public Student(String navn){
    this.navn = navn;
    fag = new ArrayList<Fag>;
  }

  public void leggTilFag(Fag f){
    fag.add(f);
  }

  public void fjernFag(Fag f){
    fag.remove(f); // try - catch
  }

  @Override
  public String toString(){
    return this.navn;
  }

}

class Fag{
  String fagkode;
  ArrayList<Student> studenter;

  public Fag(String fagkode){
    this.fagkode = fagkode;
    studenter = new ArrayList<Student>;
  }

  public void leggTilStudent(Student s){
    studenter.add(s);
  }

  public void fjernStudent(Student s){
    studenter.remove(s);
    s.fjernFag(this);
  }

  @Override
  public String toString(){
    return fagkode;
  }



}

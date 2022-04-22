import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Labyrint
 */
public class Labyrint {

  Rute[][] ruter;
  int dim_x;
  int dim_y;

  // ...
  boolean utveiFunnet;


  public void lesInn(String filnavn) throws FileNotFoundException{

    File f = new File(filnavn);
    Scanner inn = new Scanner(f);

    String[] dimensjoner = inn.nextLine().split(" ");
    dim_x = Integer.parseInt(dimensjoner[0]);
    dim_y = Integer.parseInt(dimensjoner[1]);
    ruter = new Rute[dim_x][dim_y]; 

    int l = 0;

    while (inn.hasNextLine()){
      String linje = inn.nextLine();

      for (int i = 0; i < linje.length(); i++) {
        int[] pos = {l, i};
        Character c = linje.charAt(i);

        if (c.equals('.') && (pos[0] == 0 || pos[0] == (dim_x - 1) 
              || pos[1] == 0 || pos[1] == (dim_y - 1))){
          ruter[l][i] = new Aapning(this, pos);
        }

        else if (c.equals('.')){
          ruter[l][i] = new HvitRute(this, pos);
        }

        else if (c.equals('#')){
          ruter[l][i] = new SortRute(this, pos);
        }

        else {
          System.out.println("Fant ugyldig tegn: pos " + pos[0] + "," + pos[1]);
        }
        
      }
      l++;

        
      }
    inn.close();
  }

  public void settNaboer(){

    for (int linje = 0; linje < dim_x; linje++){
      for (int kolonne = 0; kolonne < dim_y; kolonne++){
        Rute aktuellRute = ruter[linje][kolonne];

        // Litt "hacky", men enklere enn aa forholde seg til alle
        // mulige tilfeller... 
        try {
          aktuellRute.addNabo(ruter[linje][kolonne+1]);
          
        } catch (IndexOutOfBoundsException e) {
          ;
        }
        try {
          aktuellRute.addNabo(ruter[linje][kolonne-1]);
          
        } catch (IndexOutOfBoundsException e) {
          ;
        }
        try {
          aktuellRute.addNabo(ruter[linje-1][kolonne]);
          
        } catch (IndexOutOfBoundsException e) {
          ;
        }
        try {
          aktuellRute.addNabo(ruter[linje+1][kolonne]);
          
        } catch (IndexOutOfBoundsException e) {
          ;
        }
      }
    }

  }

  public void brukerDialog(){

    Scanner inn = new Scanner(System.in);
    Boolean polling = true;

    while (polling){
      System.out.println("Skriv inn koordinater <rad> <kolonne>"
          + "('-1 for aa avslutte)");
      String input = inn.nextLine();

      if (input.equals("-1")){
        polling = false;
      } 

      else{
        String[] koord = input.split(" ");

        try{
          System.out.println("\nAapninger: ");
          finnUtveiFra(Integer.parseInt(koord[0]), Integer.parseInt(koord[1]));

          if (!utveiFunnet){
            System.out.println("Ingen utvei funnet :(");
          }
          else{
            skrivUtRekkefoelge();
            nullstill();
          }
        }

        catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
           System.out.println("Ugyldige koordinater! Proev igjen.");
        }

      }
    }
    inn.close();

  }

  public void finnUtveiFra(int rad, int kol){

    utveiFunnet = false;
    Rute aktuellRute = ruter[rad][kol];
    aktuellRute.finn(null);
  }

  @Override
  public String toString(){

    String res = "";

    for (int linje = 0; linje < dim_x; linje++){
      String line = "";

      for (int kolonne = 0; kolonne < dim_y; kolonne++){
        Rute aktuellRute = ruter[linje][kolonne];

        if (aktuellRute instanceof SortRute){
          line += String.format("%4s", "#");
        } 

        else{
          line += String.format("%4s", ".");
        }
      }
      line += "\n";
      res += line;
    }
    return res;
  }

  public void skrivUtRekkefoelge(){

    String res = "";

    for (int linje = 0; linje < dim_x; linje++){
      String line = "";

      for (int kolonne = 0; kolonne < dim_y; kolonne++){
        Rute aktuellRute = ruter[linje][kolonne];

        if (aktuellRute instanceof SortRute){
          line += String.format("%4s", "#");
        } 

        else{
          String rep = String.format("%4d", aktuellRute.getRekkefoelge());
          line += rep; 
        }
      }
      line += "\n";
      res += line;
    }
    System.out.println("\nHer er labyrinten slik du gikk gjennom den : \n\n"
        + res);


  }

  public void markerSomLoest(){
    utveiFunnet = true;
  }

  public boolean loest(){
    return utveiFunnet;
  }

  public void nullstill(){
    
    for (int linje = 0; linje < dim_x; linje++){
      for (int kolonne = 0; kolonne < dim_y; kolonne++){
        Rute aktuellRute = ruter[linje][kolonne];
        aktuellRute.nullstill();
      }
    }
  }
}



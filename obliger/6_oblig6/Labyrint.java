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

  // Konstruktoer
  public Labyrint(String filnavn) throws FileNotFoundException{ // String filnavn

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


    // sett naboer
    for (int linje = 0; linje < dim_x; linje++){
      for (int kolonne = 0; kolonne < dim_y; kolonne++){
        Rute aktuellRute = ruter[linje][kolonne];

        // nicht unbedingt elegant, aber effektiv..
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

  @Override
  public String toString(){
    String res = "";
    for (int linje = 0; linje < dim_x; linje++){
      String line = "";
      for (int kolonne = 0; kolonne < dim_y; kolonne++){
        Rute aktuellRute = ruter[linje][kolonne];

        if (aktuellRute instanceof SortRute){
          line += "#";
        } else{
          line += ".";
        }
      }
      line += "\n";
      res += line;
      }
    return res;
  }

  public void finnUtveiFra(int rad, int kol){
    Rute aktuellRute = ruter[rad][kol];
    aktuellRute.finn(null);
  }
}



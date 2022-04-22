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
  public Labyrint() throws FileNotFoundException{ // String filnavn

    File f = new File("./labyrinter/2.in");
    Scanner inn = new Scanner(f);

    String[] dimensjoner = inn.nextLine().split(" ");
    dim_x = Integer.parseInt(dimensjoner[0]);
    dim_y = Integer.parseInt(dimensjoner[1]);
    ruter = new Rute[dim_x][dim_y]; 

    int l = 0;
    while (inn.hasNextLine()){
      // Loopnivaa 1: Linjer
      String linje = inn.nextLine();

      // Loopnivaa 2: Ruter
      for (int i = 0; i < linje.length(); i++) {
        int[] pos = {l, i};
        Character c = linje.charAt(i);
        // Special case: Aapning
        if (c.equals('.') && (pos[0] == 0 || pos[0] == (dim_x - 1) || pos[1] == 0 || pos[1] == (dim_y - 1))){
          ruter[l][i] = new Aapning(pos);
          // System.out.println("Fant aapning: " + pos[0] + pos[1]);
        }

        else if (c.equals('.')){
          ruter[l][i] = new HvitRute(pos);
          // System.out.println("Fant HvitRute: " + pos[0] + pos[1]);
        }

        else {
          ruter[l][i] = new SortRute(pos);
          // System.out.println("Fant SortRute: " + pos[0] + pos[1]);
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

    // Test av nabo-funksjonalitet
    Rute testRute = ruter[1][0];
    ArrayList<Rute> list = testRute.getNaboer();
    for (Rute r:list){
      System.out.println(r);
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
}



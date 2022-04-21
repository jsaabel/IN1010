import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Labyrint
 */
public class Labyrint {

  Rute[][] ruter;

  // Konstruktoer
  public Labyrint() throws FileNotFoundException{ // String filnavn

    File f = new File("./labyrinter/1.in");
    Scanner inn = new Scanner(f);

    String[] dimensjoner = inn.nextLine().split(" ");
    int dim_x = Integer.parseInt(dimensjoner[0]);
    int dim_y = Integer.parseInt(dimensjoner[1]);
    ruter = new Rute[dim_x][dim_y]; 

    while (inn.hasNextLine()){
      // Loopnivaa 1: Linjer
      int l = 0;
      String linje = inn.nextLine();

      // Loopnivaa 2: Ruter
      for (int i = 0; i < linje.length(); i++) {
        int[] pos = {l, i};
        Character c = linje.charAt(i);
        // Special case: Aapning
        if (c.equals('.') && (pos[0] == 0 || pos[0] == (dim_x - 1) || pos[1] == 0 || pos[1] == (dim_y - 1))){
          ruter[l][i] = new Aapning(pos);
          System.out.println("Fant aapning: " + pos[0] + pos[1]);
        }

        else if (c.equals('.')){
          ruter[l][i] = new HvitRute(pos);
          System.out.println("Fant HvitRute: " + pos[0] + pos[1]);
        }

        else {
          ruter[l][i] = new SortRute(pos);
          System.out.println("Fant SortRute: " + pos[0] + pos[1]);
        }
        
      }

      l++;
        
      }
    inn.close();
    }
    // ruter = new Rute[][];
}



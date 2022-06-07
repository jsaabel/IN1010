import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

class Hovedprogram{
  public static void main(String[] args) throws FileNotFoundException{

    File innfil = new File(args[0]);
    Scanner sc = new Scanner(innfil);

    // catch (FileNotFoundException e){
    //   System.out.println("Denne filen finnes ikke!");
    // }


    ArrayList<CDAlbum> albumer = new ArrayList<CDAlbum>();

    while (sc.hasNextLine()){
      String linje = sc.nextLine().strip();
      String[] biter = linje.split(",");
      CDAlbum nyttAlbum = new CDAlbum(biter[0], biter[1], biter[2]);

      // sorter inn ...
      int index = 0;
      boolean sattInn = false;
      while (index < albumer.size() && !sattInn){
        if (nyttAlbum.compareTo(albumer.get(index)) < 0){
          albumer.add(index, nyttAlbum);
          sattInn = true;
        }
        index++;
      }
      if (!sattInn){
        albumer.add(nyttAlbum);
      }
    }

  for (CDAlbum a:albumer){
    System.out.println(a);
  }
  }
}

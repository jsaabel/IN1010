import java.io.FileNotFoundException;

public class Oblig6 {
  public static void main(String[] args) {
    
    Labyrint lab = null;
    try {
      lab = new Labyrint();
    } catch (FileNotFoundException e) {
      //TODO: handle exception
    }

    System.out.println(lab);
  }
}

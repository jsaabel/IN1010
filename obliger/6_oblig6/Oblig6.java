import java.io.FileNotFoundException;

public class Oblig6 {
  public static void main(String[] args) {
    
    Labyrint lab = null;
    try {
      lab = new Labyrint(args[0]);
    } catch (FileNotFoundException e) {
      //TODO: handle exception
    }

    System.out.println("Slik ser labyrinten ut: \n" +lab);
  }
}

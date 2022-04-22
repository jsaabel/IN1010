import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oblig6 {
  public static void main(String[] args) {
    
    Labyrint lab = null;
    try {
      lab = new Labyrint(args[0]);
    } catch (FileNotFoundException e) {
      //TODO: handle exception
    }

    System.out.println("Slik ser labyrinten i " + args[0] + " ut: \n\n" +lab);

    Scanner inn = new Scanner(System.in);
    Boolean polling = true;
    while (polling){
      System.out.println("Skriv inn koordinater <rad> <kolonne>"
          + "('-1 for aa avslutte)");
      String input = inn.nextLine();
      if (input.equals("-1")){
        polling = false;
      } else{
        String[] koord = input.split(" ");
        System.out.println("Aapninger: ");
        try{
          lab.finnUtveiFra(Integer.parseInt(koord[0]), Integer.parseInt(koord[1]));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
           System.out.println("Ugyldige koordinater! Proev igjen.");
        }

      }
    }
    

    
  }
}

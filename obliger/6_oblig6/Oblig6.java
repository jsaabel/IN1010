import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oblig6 {
  public static void main(String[] args) {
    
    Labyrint lab = new Labyrint();

    if(args.length != 1){
      System.out.println("Feil: oppgi filbane til labyrintfil som parameter.");
      System.exit(0);
    }

    try {
      lab.lesInn(args[0]);
    } catch (FileNotFoundException e) {
        System.out.println("Feil: Oppgitt filbane ble ikke funnet");
        System.exit(0);
    }

    lab.settNaboer();

    System.out.println("Slik ser labyrinten i " + args[0] + " ut: \n\n" +lab);

    lab.brukerDialog();

    
  }
}

/**
 * Aapning
 */
public class Aapning extends HvitRute{

  public Aapning(Labyrint lab, int[] pos){
    super(lab, pos);
  }

  @Override
  public void finn(Rute fra){
    System.out.println("(" + pos[0] + "," + pos[1] + ")");
  }

  
}

/**
 * HvitRute
 */
public class HvitRute extends Rute{

  public HvitRute(Labyrint lab, int[] pos){
    super(lab, pos);
  }

  @Override
  public String toString() {
    return ("HvitRute (" + pos[0] + ", " + pos[1] + ")");
  }

}

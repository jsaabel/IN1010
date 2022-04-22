/**
 * SortRute
 */
public class SortRute extends Rute{

  public SortRute(Labyrint lab, int[] pos){
    super(lab, pos);
  }

  @Override
  public String toString() {
    return ("SortRute (" + pos[0] + ", " + pos[1] + ")");
  }


  
}

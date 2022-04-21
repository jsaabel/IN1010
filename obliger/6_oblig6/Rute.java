import java.util.ArrayList;

/**
 * Rute
 */
public abstract class Rute {

  int[] pos;
  ArrayList<Rute> naboer;

  // KONSTRUKTOER
  public Rute(int[] pos){
    this.pos = pos;
    this.naboer = new ArrayList<Rute>();
  }

  public ArrayList<Rute> getNaboer(){
    return naboer;
  }

  public void addNabo(Rute nabo){
    this.naboer.add(nabo);
  }

  public int[] getPos(){
    return pos;
  }

}

import java.util.ArrayList;

/**
 * Rute
 */
public abstract class Rute {

  Labyrint lab;
  int[] pos;
  ArrayList<Rute> naboer;

  // KONSTRUKTOER
  public Rute(Labyrint lab, int[] pos){
    this.lab = lab;
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

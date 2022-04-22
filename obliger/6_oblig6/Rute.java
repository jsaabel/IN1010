import java.util.ArrayList;

/**
 * Rute
 */
public abstract class Rute {

  Labyrint lab;
  int[] pos;
  ArrayList<Rute> naboer;
  boolean besoekt;

  // KONSTRUKTOER
  public Rute(Labyrint lab, int[] pos){

    this.lab = lab;
    this.pos = pos;
    this.naboer = new ArrayList<Rute>();
    this.besoekt = false;
  }

  public void addNabo(Rute nabo){

    this.naboer.add(nabo);
  }

  public int[] getPos(){

    return pos;
  }

  public void finn(Rute fra){ 

    if (besoekt){
      return;
    }

    besoekt = true;

    for (Rute n:naboer){
      if(!(n == fra)){
         n.finn(this);
      }
    }
  }
}

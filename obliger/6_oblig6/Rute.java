import java.util.ArrayList;

/**
 * Rute
 */
public abstract class Rute {

  static int teller;

  Labyrint lab;
  int[] pos;
  ArrayList<Rute> naboer;
  boolean besoekt;
  int rekkefoelge;

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
    rekkefoelge = ++teller;

    for (Rute n:naboer){
      if(!(n == fra)){
         n.finn(this);
      }
    }
  }

  public int getRekkefoelge(){

    return rekkefoelge;
  }

  public void nullstill(){
    this.besoekt = false;
    teller = 0;
  }

}

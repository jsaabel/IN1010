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
  ArrayList<Tuppel> sti;

  // KONSTRUKTOER
  public Rute(Labyrint lab, int[] pos){

    this.lab = lab;
    this.pos = pos;
    this.naboer = new ArrayList<Rute>();
    this.besoekt = false;
    this.sti = new ArrayList<Tuppel>();
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

    try{
      this.sti = new ArrayList<>(fra.getSti());
      // System.out.println(this.sti);
    }

    catch (NullPointerException e){
      ;
    }
    
    besoekt = true;
    rekkefoelge = ++teller;
    
    Tuppel tuppel = new Tuppel(pos[0], pos[1]);
    this.sti.add(tuppel);

    for (Rute n:naboer){
      if(!(n == fra)){
         n.finn(this);
      }
    }
  }

  public int getRekkefoelge(){

    return rekkefoelge;
  }

  public ArrayList<Tuppel> getSti(){
    // System.out.println("utfeoerer getSti");
    return this.sti;
  }

  public void nullstill(){
    this.besoekt = false;
    teller = 0;
  }

}

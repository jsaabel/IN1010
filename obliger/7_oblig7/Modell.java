import java.util.ArrayList;

class Modell {

  Slange slange;
  ArrayList<Skatt> skatter;
  String retning;
  boolean spillErAktiv;

  public Modell(){

    spillErAktiv = true; // temp

    skatter = new ArrayList<Skatt>();
    for (int i =0; i<5; i++){
      int trekkEn = trekk(0, 11);
      int trekkTo = trekk(0, 11);
      skatter.add(new Skatt(trekkEn, trekkTo));
    }
    // Skatt skatt = new Skatt(7, 7);
    // skatter.add(skatt);
    slange = new Slange();

    retning = "n";
  }

  

  public void oppdater(){

    flyttSlange();
    opprettSkatt();
  }

  public void opprettSkatt(){

    int test = trekk(1, 15);
    if (test == 10){
      int r = trekk(0, 11);
      int k = trekk(0, 11);
      Skatt s = new Skatt(r, k);
      skatter.add(s);
    }

  }
  public void settRetning(String r){

    if (r.equals(retning)){
      return;
    }

    else if ((r.equals("v") && retning.equals("r")) || (r.equals("r") && 
          retning.equals("v"))){
      return;
    }

    else if ((r.equals("o") && retning.equals("n")) || (r.equals("n") && 
          retning.equals("o"))){
      return;
    }

    else{
      retning = r;
    }
  }

  public void flyttSlange(){
    // Denne burde ligge et annet sted...
    if (skattFunnet(slange.hentHode().hentKoordinater())){
      slange.spis();
    }
    slange.flytt(retning);
  }

  // should have function: sjekk kollisjon (Element 1, Element 2)?
  public boolean skattFunnet(int[] koordinater){
    for (Skatt s:skatter){
      int[] skattKoordinater = s.hentKoordinater();
      if (skattKoordinater[0] == koordinater[0] && skattKoordinater[1] == 
          koordinater[1]){
        skatter.remove(s);
        return true;
      };
    }
    return false;
  }
  public boolean sjekkKollisjon(){

    if (slange.sjekkKollisjoner()){
      return true;
    }

    int[]hodeKoordinater = slange.hentHode().hentKoordinater();
    if(hodeKoordinater[0] <0 || hodeKoordinater[0] > 11){
      return true;
    }
    if(hodeKoordinater[1] <0 || hodeKoordinater[1] > 11){
      return true;
    }
    return false;
  }



  public Slange hentSlange(){
    return slange;
  }
  
  public ArrayList<Skatt> hentSkatter(){
    return skatter;
  }

  public int hentScore(){
    return slange.hentScore();
  }

  public int trekk(int a, int b){ // static ...
    // Trekk et tilfeldig heltall i intervallet [a..b]
    return (int)(Math.random()*(b-a+1)+a);

  }
  

}

import java.util.ArrayList;

class Modell {

  Slange slange;
  ArrayList<Tuppel> skatter;
  String retning;
  boolean spillErAktiv;

  public Modell(){

    spillErAktiv = true; // temp

    slange = new Slange();
    // skatter = new ArrayList<Tuppel>();

    retning = "n";
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
    slange.flytt(retning);
    // SlangeSegment aktuellSegment = null;
    // int[] nyeKoordinater = null;
    // for (int i=0; i < slange.size(); i++){
    //   aktuellSegment = slange.get(i);
    //   if (i == 0) {
    //     nyeKoordinater = aktuellSegment.hentKoordinater();
    //     aktuellSegment.flytt(retning);
    //   }
    //   else{
    //     int[] gamleKoordinaer = aktuellSegment.hentKoordinater();
    //     aktuellSegment.settKoordinater(nyeKoordinater);
    //     nyeKoordinater = gamleKoordinaer;
    //   }
    // }
    // // spis();
   // System.out.println("\nSlange: ");
    // for (SlangeSegment s:slange){
    //   System.out.println(s);
  }

  // public void spis(){
  //   int[] hode = slange.get(0).hentKoordinater();
  //   SlangeSegment nyttSlangeSegment = new SlangeSegment(hode[0],hode[1]);
  //   slange.add(0, nyttSlangeSegment);
  // }

  public boolean spillErAktiv(){
    return spillErAktiv;
  }

  public Slange hentSlange(){
    return slange;
  }
  
  // public ArrayList<Tuppel> getSkatter(){
  //   return skatter;
  // }

  public int hentScore(){
    return slange.hentScore();
  }

  public int trekk(int a, int b){ // static ...
    // Trekk et tilfeldig heltall i intervallet [a..b]
    return (int)(Math.random()*(b-a+1)+a);

  }
  

}

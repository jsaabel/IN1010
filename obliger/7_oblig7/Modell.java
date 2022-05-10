import java.util.ArrayList;

class Modell {

  ArrayList<SlangeSegment> slange;
  ArrayList<Tuppel> skatter;
  String retning;
  boolean spillErAktiv;

  public Modell(){

    spillErAktiv = true; // temp

    slange = new ArrayList<SlangeSegment>();
    // skatter = new ArrayList<Tuppel>();

    SlangeSegment testSegment = new SlangeSegment(5, 7);
    slange.add(testSegment);
    SlangeSegment testSegment2 = new SlangeSegment(5, 8);
    slange.add(testSegment2);
    SlangeSegment testSegment3 = new SlangeSegment(5, 9);
    slange.add(testSegment3);

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
    SlangeSegment aktuellSegment = null;
    int[] nyeKoordinater = null;
    for (int i=0; i < slange.size(); i++){
      aktuellSegment = slange.get(i);
      if (i == 0) {
        nyeKoordinater = aktuellSegment.hentKoordinater();
        aktuellSegment.flytt(retning);
      }
      else{
        int[] gamleKoordinaer = aktuellSegment.hentKoordinater();
        aktuellSegment.settKoordinater(nyeKoordinater);
        nyeKoordinater = gamleKoordinaer;
      }
    }
    // System.out.println("\nSlange: ");
    // for (SlangeSegment s:slange){
    //   System.out.println(s);
  }

  public boolean spillErAktiv(){
    return spillErAktiv;
  }

  public ArrayList<SlangeSegment> hentSlange(){
    return slange;
  }
  
  // public ArrayList<Tuppel> getSkatter(){
  //   return skatter;
  // }

  public int hentScore(){
    return slange.size();
  }

  static int trekk(int a, int b){
    // Trekk et tilfeldig heltall i intervallet [a..b]
    return (int)(Math.random()*(b-a+1)+a);

  }
  

}

import java.util.ArrayList;

class Modell {

  ArrayList<SlangeSegment> slange;
  ArrayList<Tuppel> skatter;
  String retning;
  boolean spillErAktiv;

  public Modell(){

    // ruter = new Rute[12][12];
    // for(int x = 0; x < 12; x++) {
    //   for (int y = 0; y < 12; y++){
    //     Rute rute = new TomRute(x, y);
    //     ruter[x][y] = rute;
    //   }
    // }

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
    System.out.println("\nSlange: ");
    for (SlangeSegment s:slange){
      System.out.println(s);
    }
  }

  public boolean spillErAktiv(){
    return spillErAktiv;
  }

  public ArrayList<SlangeSegment> hentSlange(){
    return slange;
  }
  
  public ArrayList<Tuppel> getSkatter(){
    return skatter;
  }

  static int trekk(int a, int b){
    // Trekk et tilfeldig heltall i intervallet [a..b]
    return (int)(Math.random()*(b-a+1)+a);

  }
  

  // public Rute[][] getRuter(){
  //   return ruter;
  // }


}

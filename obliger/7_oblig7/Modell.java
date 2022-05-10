import java.util.ArrayList;

class Modell {

  IndeksertListe<SlangeSegment> slange;
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

    slange = new IndeksertListe<SlangeSegment>();
    // skatter = new ArrayList<Tuppel>();

    SlangeSegment testSegment = new SlangeSegment(5, 7);
    slange.leggTil(testSegment);
    SlangeSegment testSegment2 = new SlangeSegment(5, 8);
    slange.leggTil(testSegment2);
    SlangeSegment testSegment3 = new SlangeSegment(5, 9);
    slange.leggTil(testSegment3);
    SlangeSegment testSegment4 = new SlangeSegment(5, 10);
    slange.leggTil(testSegment4);

    retning = "v";
  }

  

  // OBS: This is not correct... not all segments move into the same direction!
  // Head moves in chosen direction, each other segment moves to the previous
  // location of its predecessor...
  // might have to look into linkedlist (previous assignments...)
  public void flyttSlange(){
    for (SlangeSegment s:slange){
      s.flytt(retning);
    }
  }

  public boolean spillErAktiv(){
    return spillErAktiv;
  }

  public IndeksertListe<SlangeSegment> hentSlange(){
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

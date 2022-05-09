class Modell {

  Rute[][] ruter;

  public Modell(){

    ruter = new Rute[12][12];
    for(int x = 0; x < 12; x++) {
      for (int y = 0; y < 12; y++){
        Rute rute = new TomRute();
        ruter[x][y] = rute;
      }
    }
  }

  public Rute[][] getRuter(){
    return ruter;
  }


}

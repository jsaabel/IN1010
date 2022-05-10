class SlangeSegment{

  int[] koordinater;

  public SlangeSegment(int r, int k){
    koordinater = new int[2];
    koordinater[0] = r;
    koordinater[1] = k;
  }

  public void flytt(String retning){

    if (retning.equals("o")){
      koordinater[0]--; }

    else if (retning.equals("n")){
      koordinater[0]++; }

    else if (retning.equals("v")){
      koordinater[1]--; }

    else{
      koordinater[1]++;
    }
    System.out.println("Segment flyttet " + retning + ":" + hentKoordinater()[0]
        + hentKoordinater()[1]);
  }

  public int[] hentKoordinater(){
    int[] rKoordinater = new int[2];
    rKoordinater[0] = koordinater[0];
    rKoordinater[1] = koordinater[1];
    return rKoordinater;
  }
}
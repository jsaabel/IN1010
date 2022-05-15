abstract class Element {

  int[] koordinater;

  public Element(int r, int k){
    koordinater = new int[2];
    koordinater[0] = r;
    koordinater[1] = k;
  }

  public Element(int[] koordinater){
    this.koordinater = koordinater;
  }

  public int[] hentKoordinater(){
    int[] rKoordinater = new int[2];
    rKoordinater[0] = koordinater[0];
    rKoordinater[1] = koordinater[1];
    return rKoordinater;
  }
}

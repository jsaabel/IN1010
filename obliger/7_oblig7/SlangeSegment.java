class SlangeSegment extends Element{


  public SlangeSegment(int r, int k){
    super(r, k);
  }

  public SlangeSegment(int[] koordinater){
    super(koordinater);
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
  }

  public void settKoordinater(int[] nyeKoordinater){
    this.koordinater = nyeKoordinater;
  }

  @Override
  public String toString(){
    return "Slangesegment @ " + koordinater[0] + "/" + koordinater[1]; 
  }
}

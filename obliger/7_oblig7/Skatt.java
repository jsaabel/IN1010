class Skatt extends Element{


  public Skatt(int r, int k){
    super(r, k);
  }

  public Skatt(int[] koordinater){
    super(koordinater);
  }

  @Override
  public String toString(){
    return "Skatt @ " + koordinater[0] + "/" + koordinater[1]; 
  }
}

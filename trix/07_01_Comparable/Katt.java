class Katt implements Comparable<Katt>{

  String navn;
  int alder;

  public Katt(String navn, int alder){
    this.navn = navn;
    this.alder = alder;
  }

  @Override
  public String toString(){
    return navn + " (" + alder + ")";
  }

  @Override
  public int compareTo(Katt k){
    return this.alder - k.alder;
  }
}

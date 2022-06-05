class Hund implements Comparable<Hund>{

  String navn;
  Kull kull;
  Tidspunkt fodselstid;

  public Hund(String navn, Kull kull, Tidspunkt fodselstid){
    this.navn = navn;
    this.kull = kull;
    this.fodselstid = fodselstid;
  }

  @Override
  public int compareTo(Hund h){
    return this.fodselstid.compareTo(h.fodselstid);
  }

  public Hund mor(){
    return kull.mor;
  }

  public Hund far(){
    return kull.far;
  }

  public boolean erHelsosken(Hund h){

    return (mor() != null && far() != null && far() == h.far() && mor() == h.mor());

  }

  public boolean erHalvsosken(Hund h){

    return ((mor() != null && mor() == h.mor()) || (far() != null && far() == h.far())
        && ! erHelsosken(h));

  }

  public Hund finnEldsteKjenteOpphav(){

    if (mor() == null && far() == null){
      return this;
    }

    if (mor() == null){
      return far().finnEldsteKjenteOpphav();
    }

    if (far() == null){
      return mor().finnEldsteKjenteOpphav();
    }

    Hund farsEldsteOpphav = far().finnEldsteKjenteOpphav();
    Hund morsEldsteOpphav = mor().finnEldsteKjenteOpphav();

    if (farsEldsteOpphav.compareTo(morsEldsteOpphav) > 0){
      return farsEldsteOpphav;
    }

    return morsEldsteOpphav;
  }
}

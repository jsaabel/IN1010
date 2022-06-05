class Tidspunkt implements Comparable<Tidspunkt>{

  int aar, mnd, dag, time, min, sek;

  Tidspunkt(int aar, int mnd, int dag, int time, int min, int sek){

    this.aar = aar;
    this.mnd = mnd;
    this.dag = dag;
    this.time = time;
    this.min = min;
    this.sek = sek;
  }

  public int compareTo(Tidspunkt t){

    if (this.aar != t.aar){return this.aar - t.aar;}
    if (this.mnd != t.mnd){return this.mnd - t.mnd;}
    if (this.dag != t.dag){return this.dag - t.dag;}
    if (this.min != t.min){return this.min - t.min;}
    if (this.sek != t.sek){return this.sek - t.sek;}
    return 0;
  }
}

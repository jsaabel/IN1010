import java.util.ArrayList;

class Slange{

  SlangeSegment hode;
  ArrayList<SlangeSegment> segmenter;

  public Slange(){
    this.segmenter = new ArrayList<SlangeSegment>();
    hode = new SlangeSegment(5, 5);
    SlangeSegment to = new SlangeSegment(5, 6);
    SlangeSegment tre = new SlangeSegment(5, 7);
    segmenter.add(to); segmenter.add(tre);
  }

  public void flytt(String retning){
    int[] nyeKoordinater = hode.hentKoordinater();
    hode.flytt(retning);
    // simplify for loop

    for (SlangeSegment ss:segmenter){
      int[] gamleKoordinaer = ss.hentKoordinater();
      ss.settKoordinater(nyeKoordinater);
      nyeKoordinater = gamleKoordinaer;
      }
  }

  public void spis(){
    segmenter.add(new SlangeSegment(hode.hentKoordinater()));
  }

  public boolean sjekkKollisjoner(){

    int[] hodeKoordinater = hode.hentKoordinater();
    for (SlangeSegment ss: segmenter){
      int[] segmentKoordinater = ss.hentKoordinater();
      if (segmentKoordinater[0] == hodeKoordinater[0] && segmentKoordinater[1]
          == hodeKoordinater[1]){
        return true;
      }
    }
    return false;
  }

  public int hentScore(){
    return segmenter.size() + 1;
  }

  public SlangeSegment hentHode(){
    return this.hode;
  }

  public ArrayList<SlangeSegment> hentSegmenter(){
    return this.segmenter;
  }
}

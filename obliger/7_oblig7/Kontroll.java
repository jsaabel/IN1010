import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

class Kontroll{
  GUI gui;
  Modell modell;

  public Kontroll(){

    modell = new Modell();
    gui = new GUI(this);
    gui.plasserSlange(modell.hentSlange());
    // gui.gjoerOmRuteLabel(5, 5, "SlangeHode");
    // gui.visSkatt(5, 5);
    KlokkeTraad klokkeTraad = new KlokkeTraad(this);
    new Thread(klokkeTraad).start();
  }

  public void oppdater(){
    // ArrayList<SlangeSegment> gammelSlange = modell.hentSlange();
    // SlangeSegment tail = gammelSlange.get(gammelSlange.size() -1);
    // int[] tailKoordinater = tail.hentKoordinater();
    // gui.gjoerOmRuteLabel(tailKoordinater, "TomRute");
    modell.flyttSlange(); 
    gui.tegnNySlange(modell.hentSlange());
    // ArrayList<SlangeSegment> nySlange = modell.hentSlange();
    // SlangeSegment head = nySlange.get(0);
    // int[] koordinater = head.hentKoordinater();
    // gui.gjoerOmRuteLabel(koordinater, "SlangeHode");
  }

  public boolean spillErAktiv(){
    return modell.spillErAktiv();
  }


  // public Rute[][] getRuter(){
  //   return modell.getRuter();
  // }
}

import java.awt.*;
import javax.swing.*;

class Kontroll{
  GUI gui;
  Modell modell;

  public Kontroll(){

    modell = new Modell();
    gui = new GUI(this);
    // gui.gjoerOmRuteLabel(5, 5, "SlangeHode");
    // gui.visSkatt(5, 5);
    KlokkeTraad klokkeTraad = new KlokkeTraad(this);
    new Thread(klokkeTraad).start();
  }

  public void oppdater(){
    modell.flyttSlange();
    SlangeSegment head = modell.hentSlange().get(0);
    int[] koordinater = head.hentKoordinater();
    gui.gjoerOmRuteLabel(koordinater[0], koordinater[1], "SlangeHode");
  }

  public boolean spillErAktiv(){
    return modell.spillErAktiv();
  }


  // public Rute[][] getRuter(){
  //   return modell.getRuter();
  // }
}

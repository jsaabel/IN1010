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
  }

  public boolean spillErAktiv(){
    return modell.spillErAktiv();
  }


  // public Rute[][] getRuter(){
  //   return modell.getRuter();
  // }
}

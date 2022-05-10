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
    modell.flyttSlange(); 
    gui.tegnNySlange(modell.hentSlange());
    gui.visScore(modell.hentScore());
  }

  public boolean spillErAktiv(){
    return modell.spillErAktiv();
  }

  public void settRetning(String r){
    modell.settRetning(r);
  }

  public void avslutt(){
    System.exit(0);
  }


  // public Rute[][] getRuter(){
  //   return modell.getRuter();
  // }
}

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

class Kontroll{
  GUI gui;
  Modell modell;
  boolean spillErAktiv;

  public Kontroll(){

    spillErAktiv = true;
    modell = new Modell();
    gui = new GUI(this);
    // gui.plasserSlange(modell.hentSlange());
    // gui.gjoerOmRuteLabel(5, 5, "SlangeHode");
    // gui.visSkatt(5, 5);
    KlokkeTraad klokkeTraad = new KlokkeTraad(this);
    new Thread(klokkeTraad).start();
  }

  public void oppdater(){

    modell.flyttSlange(); 
    if (modell.sjekkKollisjon()){
      spillErAktiv=false;
      return;
    }
    gui.tegnSlange(modell.hentSlange());
    gui.visScore(modell.hentScore());
    // int test = modell.trekk(1, 5);
    // if (test == 5){
    //   modell.spis();
    // }

    
  }

  public void settRetning(String r){
    modell.settRetning(r);
  }

  public void avslutt(){
    System.exit(0);
  }
}

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
    KlokkeTraad klokkeTraad = new KlokkeTraad(this);
    new Thread(klokkeTraad).start();
  }

  public void oppdater(){

    modell.oppdater(); 

    if (modell.sjekkKollisjon()){
      spillErAktiv=false;
      gui.roedSlange(modell.hentSlange());
      return;
    }

    gui.tegnSkatter(modell.hentSkatter());
    gui.tegnSlange(modell.hentSlange());
    gui.visScore(modell.hentScore());

    
  }

  public void settRetning(String r){
    modell.settRetning(r);
  }

  public void avslutt(){
    System.exit(0);
  }
}

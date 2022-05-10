import java.awt.*;
import javax.swing.*;

class Kontroll{
  GUI gui;
  Modell modell;

  public Kontroll(){

    modell = new Modell();
    gui = new GUI(this);
    // gui.visSkatt(5, 5);
  }

  // public Rute[][] getRuter(){
  //   return modell.getRuter();
  // }
}

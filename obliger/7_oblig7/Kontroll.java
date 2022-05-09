import java.awt.*;
import javax.swing.*;

class Kontroll{
  GUI gui;
  Modell modell;

  public Kontroll(){

    modell = new Modell();
    gui = new GUI(this);
  }

  public Rute[][] getRuter(){
    return modell.getRuter();
  }
}

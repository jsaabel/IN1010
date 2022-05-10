import java.awt.*;
import javax.swing.*;

abstract class Rute extends JLabel{

  Rute(){
    super(" ");
    setOpaque(true);
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    setHorizontalAlignment(JLabel.CENTER);
  }
}


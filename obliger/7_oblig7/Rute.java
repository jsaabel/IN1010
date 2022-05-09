import java.awt.*;
import javax.swing.*;

class Rute extends JLabel{

  public Rute(String text){
    super(text);
    setOpaque(true);
    setBackground(Color.WHITE);
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    setHorizontalAlignment(JLabel.CENTER);
  }
}

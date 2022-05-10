import java.awt.*;
import javax.swing.*;

/**
 * (Standardoppsett for JLabels som representerer en (tom) rute paa 
 * spillebrettet.)
 */
class RuteLabel extends JLabel{

  RuteLabel(){
    super(" ");
    setOpaque(true);
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    setHorizontalAlignment(JLabel.CENTER);
    setBackground(Color.WHITE);
  }
}


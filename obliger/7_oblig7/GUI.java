import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUI {

  Kontroll kontroll;
  JFrame vindu;
  JPanel panel;

  GUI (Kontroll k){
    
    kontroll = k;

    try {
        UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) { System.exit(1); }

    vindu = new JFrame("Slangespillet");
    vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel();
    vindu.add(panel);

    vindu.pack();
    vindu.setVisible(true);
  }
}

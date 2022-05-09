import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUI {

  Kontroll kontroll;
  JFrame vindu;
  JLabel labelLengde;
  JPanel kontrollpanel, styring;
  JButton knappOpp, knappVenstre, knappHoyre, knappNed, knappSlutt;

  GUI (Kontroll k){
    
    kontroll = k;

    try {
        UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) { System.exit(1); }

    vindu = new JFrame("Slangespillet");
    vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    kontrollpanel = new JPanel();

    // Lengde:
    labelLengde = new JLabel("Lengde: x");
    kontrollpanel.add(labelLengde);

    // Styringselementer
    styring = new JPanel();
    kontrollpanel.add(styring);

    knappOpp = new JButton("Opp");
    styring.add(knappOpp);

    knappVenstre = new JButton("Venstre");
    styring.add(knappVenstre);

    knappHoyre = new JButton("Hoyre");
    styring.add(knappHoyre);

    knappNed = new JButton("Ned");
    styring.add(knappNed);

    // Slutt-knapp
    knappSlutt = new JButton("Slutt");
    kontrollpanel.add(knappSlutt);

    vindu.add(kontrollpanel);
    vindu.pack();
    vindu.setVisible(true);
  }
}

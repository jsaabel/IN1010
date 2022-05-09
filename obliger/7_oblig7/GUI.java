import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUI {

  Kontroll kontroll;
  JFrame vindu;
  JLabel labelLengde;
  JPanel panel;
  JButton knappOpp, knappVenstre, knappHoyre, knappNed, knappSlutt;

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

    labelLengde = new JLabel("Lengde: x");
    panel.add(labelLengde);

    // Knapper
    knappOpp = new JButton("Opp");
    panel.add(knappOpp);

    knappVenstre = new JButton("Venstre");
    panel.add(knappVenstre);

    knappHoyre = new JButton("Hoyre");
    panel.add(knappHoyre);

    knappNed = new JButton("Ned");
    panel.add(knappNed);

    knappSlutt = new JButton("Slutt");
    panel.add(knappSlutt);

    vindu.pack();
    vindu.setVisible(true);
  }
}

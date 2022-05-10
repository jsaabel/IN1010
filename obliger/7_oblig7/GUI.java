import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUI {

  Kontroll kontroll;
  JFrame vindu;
  JLabel labelLengde;
  JPanel grunnflate, kontrollpanel, styring, rutenett;
  JButton knappOpp, knappVenstre, knappHoyre, knappNed, knappSlutt;

  // NEW / TEST
  RuteLabel[][] ruteLabels;

  GUI (Kontroll k){
    
    kontroll = k;

    try {
        UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) { System.exit(1); }

    vindu = new JFrame("Slangespillet");
    vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    grunnflate = new JPanel();
    grunnflate.setLayout(new BorderLayout());

    // KONTROLLPANEL
    kontrollpanel = new JPanel();
    grunnflate.add(kontrollpanel, BorderLayout.NORTH);
    
    // Lengde:
    labelLengde = new JLabel("Lengde: x");
    kontrollpanel.add(labelLengde);

    // Styringselementer
    styring = new JPanel();
    styring.setLayout(new BorderLayout());
    kontrollpanel.add(styring);

    knappOpp = new JButton("Opp");
    styring.add(knappOpp, BorderLayout.NORTH);

    knappVenstre = new JButton("Venstre");
    styring.add(knappVenstre, BorderLayout.WEST);

    knappHoyre = new JButton("Hoyre");
    styring.add(knappHoyre, BorderLayout.EAST);

    knappNed = new JButton("Ned");
    styring.add(knappNed, BorderLayout.SOUTH);

    // Slutt-knapp
    knappSlutt = new JButton("Slutt");
    kontrollpanel.add(knappSlutt);

    // Temp rutenett
    rutenett = new JPanel();
    rutenett.setLayout(new GridLayout(12, 12));

    // Initital draw/assignment (?)
    ruteLabels = new RuteLabel[12][12];
    for(int x = 0; x < 12; x++) {
      for (int y = 0; y < 12; y++){
        // Rute rute = ruter[x][y];
        RuteLabel ruteLabel = new RuteLabel();
        rutenett.add(ruteLabel);
      }
    }


    grunnflate.add(rutenett, BorderLayout.SOUTH);
    

    vindu.add(grunnflate);
    // ruter[3][3].setText("O"); // this works...
    vindu.pack();
    vindu.setVisible(true);
  }

}

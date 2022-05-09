import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUI {

  Kontroll kontroll;
  JFrame vindu;
  JLabel labelLengde;
  JPanel grunnflate, kontrollpanel, styring, rutenett;
  JButton knappOpp, knappVenstre, knappHoyre, knappNed, knappSlutt;

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

    // RUTENETT 
    rutenett = new JPanel();
    rutenett.setLayout(new GridLayout(12, 12));
    // OBS: Should prob. event. be implement. by extending JLabel!!
    // ... which has been done. delete this eventually. 
    // JLabel[][] ruter = new JLabel[12][12];
    // for(int x = 0; x < 12; x++) {
    //   for (int y = 0; y < 12; y++){
    //     JLabel rute = new JLabel("X");
    //     rute.setOpaque(true);
    //     rute.setBackground(Color.WHITE);
    //     rute.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    //     rute.setHorizontalAlignment(JLabel.CENTER);
    //     rutenett.add(rute);
    //     ruter[x][y] = rute;
    //   }
    Rute[][] ruter = new Rute[12][12];
    for(int x = 0; x < 12; x++) {
      for (int y = 0; y < 12; y++){
        Rute rute = new Rute("X");
        // rute.setOpaque(true);
        // rute.setBackground(Color.WHITE);
        // rute.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // rute.setHorizontalAlignment(JLabel.CENTER);
        rutenett.add(rute);
        ruter[x][y] = rute;
      }
      
    }

    grunnflate.add(rutenett, BorderLayout.SOUTH);
    
    // SETUP
    vindu.add(grunnflate);
    vindu.pack();
    vindu.setVisible(true);
  }
}

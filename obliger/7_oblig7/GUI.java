import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class GUI {

  Kontroll kontroll;
  JFrame vindu;
  JLabel labelLengde;
  JPanel grunnflate, kontrollpanel, styring, rutenett;
  JButton knappOpp, knappVenstre, knappHoyre, knappNed, knappSlutt;

  // NEW / TEST
  RuteLabel[][] ruteLabels;
  int[] sisteHode, sisteHale, nyttHode, nyHale;

  // Konstruktoer
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

        RuteLabel ruteLabel = new RuteLabel();
        ruteLabels[x][y] = ruteLabel;
        rutenett.add(ruteLabel);
      }
    }


    grunnflate.add(rutenett, BorderLayout.SOUTH);
    

    vindu.add(grunnflate);
    vindu.pack();
    vindu.setVisible(true);
  }
  // draw-Methods
  public void plasserSlange(ArrayList<SlangeSegment> slange){

    for (int i = 1; i < slange.size(); i++){
      int[] segmentKoordinater = slange.get(i).hentKoordinater();
      gjoerOmRuteLabel(segmentKoordinater, "SlangeSegment");
    }

    sisteHode = slange.get(0).hentKoordinater();
    gjoerOmRuteLabel(sisteHode, "SlangeHode");
    sisteHale = slange.get(slange.size() - 1).hentKoordinater();
    gjoerOmRuteLabel(sisteHale, "SlangeSegment");

  }

  public void tegnNySlange(ArrayList<SlangeSegment> slange){

    nyttHode = slange.get(0).hentKoordinater();
    nyHale = slange.get(slange.size() - 1).hentKoordinater();

    gjoerOmRuteLabel(sisteHode, "SlangeSegment");
    gjoerOmRuteLabel(nyttHode, "SlangeHode");
    gjoerOmRuteLabel(sisteHale, "TomRute");
    gjoerOmRuteLabel(nyHale, "SlangeSegment");
    sisteHode = nyttHode;
    sisteHale = nyHale;
  }

  public void gjoerOmRuteLabel(int[] koordinater, String type){

    int r = koordinater[0];
    int k = koordinater[1];
    RuteLabel rl = ruteLabels[r][k];

    if (type.equals("TomRute")){
      rl.setText(" ");
      rl.setBackground(Color.WHITE);
    }

    else if (type.equals("Skatt")){
      rl.setText("$");
      rl.setBackground(Color.WHITE);
      rl.setForeground(Color.RED);
    }
    
    else if (type.equals("SlangeHode")){
      rl.setText("O");
      rl.setBackground(Color.GREEN);
      rl.setForeground(Color.BLACK);
    }

    else if (type.equals("SlangeSegment")){
      rl.setText("+");
      rl.setBackground(Color.GREEN);
      rl.setForeground(Color.BLACK);
    }

    else{
      System.out.println("TEMP ERROR"); //  TEMP
    }
  }

}

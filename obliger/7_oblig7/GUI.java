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
    
    class KnappOpp implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e){
        kontroll.settRetning("o");
      }
    }

    knappOpp.addActionListener(new KnappOpp());
    styring.add(knappOpp, BorderLayout.NORTH);

    knappVenstre = new JButton("Venstre");

    class KnappVenstre implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e){
        kontroll.settRetning("v");
      }
    }

    knappVenstre.addActionListener(new KnappVenstre());
    styring.add(knappVenstre, BorderLayout.WEST);

    knappHoyre = new JButton("Hoyre");
    class KnappHoyre implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e){
        kontroll.settRetning("h");
      }
    }

    knappHoyre.addActionListener(new KnappHoyre());
    styring.add(knappHoyre, BorderLayout.EAST);

    knappNed = new JButton("Ned");
    class KnappNed implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e){
        kontroll.settRetning("n");
      }
    }

    knappNed.addActionListener(new KnappNed());
    styring.add(knappNed, BorderLayout.SOUTH);

    // Slutt-knapp
    knappSlutt = new JButton("Slutt");
    class KnappSlutt implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent E){
        kontroll.avslutt();
      }
    }
    knappSlutt.addActionListener(new KnappSlutt());
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

  public void tegnSlange(Slange slange){

    nyttHode = slange.hentHode().hentKoordinater(); // OBS 
    ArrayList<SlangeSegment> segmenter = slange.hentSegmenter();

    // gjoerOmRuteLabel(sisteHode, "SlangeSegment");
    gjoerOmRuteLabel(nyttHode, "SlangeHode");
    if (sisteHale != null) {
      gjoerOmRuteLabel(sisteHale, "TomRute");
    }
    for (SlangeSegment ss:segmenter){
      gjoerOmRuteLabel(ss.hentKoordinater(), "SlangeSegment");
    }
    sisteHale = segmenter.get(segmenter.size()-1).hentKoordinater();
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

  public void visScore(int score){
    labelLengde.setText("Lengde: " + score);
  }

}

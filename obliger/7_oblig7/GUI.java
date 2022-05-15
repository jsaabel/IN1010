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

    // Keyboardkontroller
    class KeyboardKontroll extends Frame implements KeyListener{
      @Override
      public void keyPressed(KeyEvent e){

        int keyCode = e.getKeyCode();

        if (keyCode == 38){
          kontroll.settRetning("o");
        }
        else if (keyCode == 40){
          kontroll.settRetning("n");
        }
        else if (keyCode == 37){
          kontroll.settRetning("v");
        }
        else if (keyCode == 39){
          kontroll.settRetning("h");
        }
      }
      @Override
      public void keyReleased(KeyEvent e){
        ;
      }
      @Override
      public void keyTyped(KeyEvent e){
        ;
      }

    }

    knappOpp.addKeyListener(new KeyboardKontroll());

    knappVenstre = new JButton("Venstre");

    class KnappVenstre implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e){
        kontroll.settRetning("v");
      }
    }

    knappVenstre.addActionListener(new KnappVenstre());
    knappVenstre.addKeyListener(new KeyboardKontroll());
    styring.add(knappVenstre, BorderLayout.WEST);

    knappHoyre = new JButton("Hoyre");
    class KnappHoyre implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e){
        kontroll.settRetning("h");
      }
    }

    knappHoyre.addActionListener(new KnappHoyre());
    knappHoyre.addKeyListener(new KeyboardKontroll());
    styring.add(knappHoyre, BorderLayout.EAST);

    knappNed = new JButton("Ned");
    class KnappNed implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e){
        kontroll.settRetning("n");
      }
    }

    knappNed.addActionListener(new KnappNed());
    knappNed.addKeyListener(new KeyboardKontroll());
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

    // Rutenett
    rutenett = new JPanel();
    rutenett.setLayout(new GridLayout(12, 12));
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

  public void tegnSkatter(ArrayList<Skatt> skatter){

    for (Skatt s: skatter){
      gjoerOmRuteLabel(s.hentKoordinater(), "Skatt");
    }

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

  public void roedSlange(Slange slange){

    // gjoerOmRuteLabel(slange.hentHode().hentKoordinater(), "Feil");
    for (SlangeSegment ss:slange.hentSegmenter()){
      gjoerOmRuteLabel(ss.hentKoordinater(), "Feil");
    }
    gjoerOmRuteLabel(sisteHale, "Feil");
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

    else if (type.equals("Feil")){
      rl.setBackground(Color.RED);
    }

    else{
      System.out.println("TEMP ERROR"); //  TEMP
    }
  }

  public void visScore(int score){
    labelLengde.setText("Lengde: " + score);
  }

}

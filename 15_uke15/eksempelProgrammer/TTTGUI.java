import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Hovedprogrammet

class TTTGUI {
    public static void main (String[] arg) {
	Kontroll kontroll = new Kontroll();
	kontroll.startSpillet();
    }
}

// Modellen

class Modell {
    char[][] brett = new char[3+1][3+1];
    int antTrekk = 0;
    boolean spilletErFerdig = false;

    Modell () {
	for (int rx = 1;  rx <= 3;  ++rx)
	    for (int kx = 1;  kx <= 3;  ++kx)
		brett[rx][kx] = ' ';
    }

    boolean lovligTrekk (int r, int k) {
	return brett[r][k] == ' ';
    }

    void noterTrekk (int r, int k, char spiller) {
	brett[r][k] = spiller;
	++antTrekk;
    }

    void noterSpilletFerdig () {
	spilletErFerdig = true;
    }

    boolean erSpilletFerdig () {
	return spilletErFerdig || antTrekk == 9;
    }

    boolean harVunnet (char s) {
	return
	    // Sjekk radene
	    brett[1][1]==s && brett[1][2]==s && brett[1][3]==s ||
	    brett[2][1]==s && brett[2][2]==s && brett[2][3]==s ||
	    brett[3][1]==s && brett[3][2]==s && brett[3][3]==s ||
	    // Sjekk kolonnene
	    brett[1][1]==s && brett[2][1]==s && brett[3][1]==s ||
	    brett[1][2]==s && brett[2][2]==s && brett[3][2]==s ||
	    brett[1][3]==s && brett[2][3]==s && brett[3][3]==s ||
	    // Sjekk diagonalene
	    brett[1][1]==s && brett[2][2]==s && brett[3][3]==s ||
	    brett[1][3]==s && brett[2][2]==s && brett[3][1]==s;
    }
}

// Brukergrensesnittet

class GUI {
    JFrame vindu;
    JPanel spill, rutenett;
    JButton[][] ruter = new JButton[3+1][3+1];
    JLabel status;
    JButton stoppknapp;
    Kontroll kontroll;
    
    GUI (Kontroll k) {
	kontroll = k;
	
	try {
	    UIManager.setLookAndFeel(
	        UIManager.getCrossPlatformLookAndFeelClassName());
	} catch (Exception e) { System.exit(9); }

        vindu = new JFrame("Tripp trapp tresko");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	spill = new JPanel();
	vindu.add(spill);

	rutenett = new JPanel();
	spill.add(rutenett);
	rutenett.setLayout(new GridLayout(3,3));
	for (int rx = 1;  rx <= 3;  ++rx) {
	    for (int kx = 1;  kx <= 3;  ++kx) {
		JButton b = new JButton(" ");
		ruter[rx][kx] = b;
		b.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));

		class Spillvelger implements ActionListener {
		    int rad, kol;

		    Spillvelger (int r, int k) {
			rad = r;  kol = k;
		    }
		    
		    @Override
		    public void actionPerformed (ActionEvent e) {
			kontroll.brukervalg(rad, kol);
		    }
		}
		b.addActionListener(new Spillvelger(rx,kx));
		rutenett.add(b);
	    }
	}

	status = new JLabel("Velg en rute");
	spill.add(status);

	stoppknapp = new JButton("Exit");
	spill.add(stoppknapp);
	class Stoppbehandler implements ActionListener {
	    @Override
	    public void actionPerformed (ActionEvent e) {
		kontroll.avsluttSpillet();
	    }
	}
	stoppknapp.addActionListener(new Stoppbehandler());

	vindu.pack();
	vindu.setVisible(true);
    }

    void markerTrekk (int r, int k, char c) {
	ruter[r][k].setText(""+c);
    }

    void visStatus (String tekst) {
	status.setText(tekst);
    }
}

// Kontroller

class Kontroll {
    Modell modell;
    GUI gui;

    Kontroll () {
	modell = new Modell();
	gui = new GUI(this);
    }

    void startSpillet () {
	laMaskinenTrekke();
    }

    void laMaskinenTrekke () {
	int r, k;
	do {
	    r = trekkTilfeldig(1,3);  k = trekkTilfeldig(1,3);
	} while (! modell.lovligTrekk(r,k));
	modell.noterTrekk(r, k, 'X');
	gui.markerTrekk(r, k, 'X');

	if (modell.harVunnet('X')) {
	    gui.visStatus("Maskinen har vunnet!");
	    modell.noterSpilletFerdig();
	} else if (modell.erSpilletFerdig()) {
	    gui.visStatus("Det ble uavgjort.");
	    modell.noterSpilletFerdig();
	}
    }

    private int trekkTilfeldig (int a, int b) {
	// Trekk et tilfeldig heltall x slik at a <= x <= b.
	return (int)(Math.random()*(b-a+1)) + a;
    }
    

    void brukervalg (int r, int k) {
	if (modell.erSpilletFerdig()) {
	    gui.visStatus("Spillet er ferdig!");
	    return;
	}
	
	if (! modell.lovligTrekk(r, k)) {
	    gui.visStatus("Ulovlig trekk!");
	    return;
	} 
	    
	modell.noterTrekk(r, k, 'O');
	gui.markerTrekk(r, k, 'O');
	if (modell.harVunnet('O')) {
	    modell.noterSpilletFerdig();
	    gui.visStatus("Du har vunnet!");
	    return;
	} 

	laMaskinenTrekke();
	if (! modell.erSpilletFerdig())
	    gui.visStatus("Velg en rute");
    }

    void avsluttSpillet () {
	System.exit(0);
    }
}

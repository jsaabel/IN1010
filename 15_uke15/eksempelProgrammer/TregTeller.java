import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TregTeller {
    static int tellerverdi = 0;

    public static void main (String[] arg) {
        JFrame vindu = new JFrame("Treg teller");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        JLabel antall = new JLabel(" 0  ");

        JButton tell = new JButton(" +1 ");
        class OekTeller implements ActionListener {
            @Override
            public void actionPerformed (ActionEvent e) {
                ++tellerverdi;  
                antall.setText(" " + tellerverdi + " ");
            }
        }
        tell.addActionListener(new OekTeller());

        JButton resett = new JButton(" = 0 ");
        class Nuller implements ActionListener {
            @Override
            public void actionPerformed (ActionEvent e) {
                tellerverdi = 0;
                antall.setText(" " + tellerverdi);
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException ie) {}
            }
        }
        resett.addActionListener(new Nuller());

        JButton slutt = new JButton("Exit");
        class Stopper implements ActionListener {
            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        }
        slutt.addActionListener(new Stopper());

        panel.add(antall);  panel.add(tell);  panel.add(resett);
        panel.add(slutt);

        vindu.pack();
        vindu.setVisible(true);

        // Hovedtråden fortsetter på egen hånd:
        for (int sek = 0;  sek < 30;  ++sek) {
            System.out.print(sek + " ");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException ie) {}
        }
        System.out.println("ferdig");
    }
}

package ssp;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cwegner
 */
public class Gui2 extends JFrame
{

    KI ki = new KI();
    Gewinner sieger = new Gewinner();
    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel nameLabel;
    private JLabel roundLabel;
    private JLabel spielstand;
    private JLabel gewinner;
    private JLabel auswahlAnzeige;
    private JLabel punktestand;
    private JLabel rundenCounter;
    private JTextField nameField;
    private JTextField roundField;
    private JButton eingabeButton;
    private JButton steinButton;
    private JButton schereButton;
    private JButton papierButton;
    private JButton nextButton;
    private int spielerScore;
    private int compScore;
    String name;
    String runden;
    int rundenZahl = 0;
    int RundenZeiger = 0;
    String spielerwahl;
    String computerwahl;
    int siegerNummer;

    public Gui2()
    {

        // Erstellung des Frames //
        frame = new JFrame("Stein - Schere - Papier");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setResizable(false);

        // Frame Position in Bildschirm-Mitte //
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (dimension.width - w) / 2;
        int y = (dimension.height - h) / 2;
        frame.setLocation(x, y);

        // Erstellung der Panels //
        panel1 = new JPanel();
        panel2 = new JPanel();

        // Panel 1 //
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        panel1.setBorder(new EmptyBorder(10, 10, 10, 20));
        panel1.setBounds(200, 200, 400, 200);
        panel1.setVisible(true);
        frame.add(panel1);

        // Panel 2 //       
        panel2.setLayout(new GridBagLayout());
        panel2.setBorder(new EmptyBorder(10, 10, 10, 20));
        panel2.setBounds(200, 200, 400, 200);
        panel2.setVisible(false);
        frame.add(panel2);

        ///////////// Panel 1 Objekte ////////////////////////////
        // Border //
        TitledBorder border = new TitledBorder(" Deine Angaben ");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        panel1.setBorder(border);

        // Objekte //
        nameLabel = new JLabel("Wie ist dein Name?");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel1.add(nameLabel, constraints);

        nameField = new JTextField(20);
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel1.add(nameField, constraints);
        nameField.setSize(nameField.getPreferredSize());

        roundLabel = new JLabel("Wieviele Runden?");
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel1.add(roundLabel, constraints);
        roundLabel.setSize(roundLabel.getPreferredSize());

        roundField = new JTextField(5);
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel1.add(roundField, constraints);
        nameField.setSize(roundField.getPreferredSize());

        // Eingabe-Button wird kreiert //
        eingabeButton = new JButton("Bestätigen");
        constraints.weighty = 2;
        constraints.gridx = 0;
        constraints.gridy = 4;
        eingabeButton.addActionListener(new Listener());
        panel1.add(eingabeButton, constraints);
        panel1.revalidate();
        panel1.repaint();

        ///////////////////// Panel 2 Objekte //////////////////
        steinButton = new JButton("Stein");
        constraints.gridx = 1;
        constraints.gridy = 1;
        steinButton.setSize(steinButton.getPreferredSize());
        steinButton.addActionListener(new Listener());
        panel2.add(steinButton, constraints);

        schereButton = new JButton("Schere");
        constraints.gridx = 2;
        constraints.gridy = 1;
        schereButton.addActionListener(new Listener());
        panel2.add(schereButton, constraints);

        papierButton = new JButton("Papier");
        constraints.gridx = 3;
        constraints.gridy = 1;
        papierButton.addActionListener(new Listener());
        panel2.add(papierButton, constraints);

        nextButton = new JButton("Nächste Runde!");
        constraints.gridx = 2;
        constraints.gridy = 1;
        nextButton.addActionListener(new Listener());
        nextButton.setVisible(false);
        panel2.add(nextButton, constraints);

        rundenCounter = new JLabel();
        constraints.gridx = 2;
        constraints.gridy = 0;
        panel2.add(rundenCounter, constraints);

        auswahlAnzeige = new JLabel();
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.weightx = 3;
        panel2.add(auswahlAnzeige, constraints);

        gewinner = new JLabel();
        constraints.gridx = 2;
        constraints.gridy = 3;
        panel2.add(gewinner, constraints);

        punktestand = new JLabel();
        constraints.gridx = 2;
        constraints.gridy = 4;
        panel2.add(punktestand, constraints);

        TitledBorder border2 = new TitledBorder(" Stein Schere Papier ");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        panel2.setBorder(border2);

    }

    class Listener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {

            if (e.getSource() == eingabeButton)
            {
                name = nameField.getText();
                runden = roundField.getText();
                rundenZahl = Integer.valueOf(runden);
                panel1.setVisible(false);
                frame.setTitle("Spieler: " + name);
                panel2.setVisible(true);
                //rundenCounter.setText("Runde: " + RundenZeiger);

            }

            if (e.getSource() == steinButton)
            {
                spielerwahl = "Stein";
                computerwahl = ki.ComputerWahl();
                auswahlAnzeige.setText("<html><body>" + name + " wählte: " + spielerwahl
                        + "<br>Computer wählte: " + computerwahl
                        + "</body></html>");
                steinButton.setVisible(false);
                schereButton.setVisible(false);
                papierButton.setVisible(false);
                siegerNummer = sieger.GewinnerString(spielerwahl, computerwahl);
                switch (siegerNummer)
                {
                    case 1:
                        gewinner.setText(name + " gewinnt!");
                        spielerScore++;
                        break;
                    case 2:
                        gewinner.setText(name + " verliert!");
                        compScore++;
                        break;
                    case 3:
                        gewinner.setText("Die Runde endet unentschieden!");
                        spielerScore++;
                        compScore++;
                        break;
                    default:
                        gewinner.setText("Es gab einen Fehler!");
                        break;
                }

                punktestand.setText("<html><body>Spieler: " + spielerScore
                        + "<br>Computer: " + compScore + "</body></html>");

                for (int i = 1; i < rundenZahl; i++)
                {
                    int rundenZeiger = i;
                    rundenZeiger++;
                    rundenZahl--;
                    if (rundenZahl > 0)
                    {
                        nextButton.setVisible(true);
                    }
                }

            }

            if (e.getSource() == schereButton)
            {
                spielerwahl = "Schere";
                computerwahl = ki.ComputerWahl();
                auswahlAnzeige.setText("<html><body>" + name + " wählte: " + spielerwahl
                        + "<br>Computer wählte: " + computerwahl
                        + "</body></html>");
                steinButton.setVisible(false);
                schereButton.setVisible(false);
                papierButton.setVisible(false);
                siegerNummer = sieger.GewinnerString(spielerwahl, computerwahl);
                switch (siegerNummer)
                {
                    case 1:
                        gewinner.setText(name + " gewinnt!");
                        spielerScore++;
                        break;
                    case 2:
                        gewinner.setText(name + " verliert!");
                        compScore++;
                        break;
                    case 3:
                        gewinner.setText("Die Runde endet unentschieden!");
                        spielerScore++;
                        compScore++;
                        break;
                    default:
                        gewinner.setText("Es gab einen Fehler!");
                        break;
                }

                punktestand.setText("<html><body>Spieler: " + spielerScore
                        + "<br>Computer: " + compScore + "</body></html>");

                rundenZahl--;
                if (rundenZahl > 0)
                {
                    nextButton.setVisible(true);
                }

            }

            if (e.getSource() == papierButton)
            {
                spielerwahl = "Papier";
                computerwahl = ki.ComputerWahl();
                auswahlAnzeige.setText("<html><body>" + name + " wählte: " + spielerwahl
                        + "<br>Computer wählte: " + computerwahl
                        + "</body></html>");
                steinButton.setVisible(false);
                schereButton.setVisible(false);
                papierButton.setVisible(false);
                siegerNummer = sieger.GewinnerString(spielerwahl, computerwahl);
                switch (siegerNummer)
                {
                    case 1:
                        gewinner.setText(name + " gewinnt!");
                        spielerScore++;
                        break;
                    case 2:
                        gewinner.setText(name + " verliert!");
                        compScore++;
                        break;
                    case 3:
                        gewinner.setText("Die Runde endet unentschieden!");
                        spielerScore++;
                        compScore++;
                        break;
                    default:
                        gewinner.setText("Es gab einen Fehler!");
                        break;
                }
                punktestand.setText("<html><body>Spieler: " + spielerScore
                        + "<br>Computer: " + compScore + "</body></html>");

                rundenZahl--;
                if (rundenZahl > 0)
                {
                    nextButton.setVisible(true);
                } else
                {
                    System.out.println("Spielende");
                }
            }

            if (e.getSource() == nextButton)
            {
                steinButton.setVisible(true);
                schereButton.setVisible(true);
                papierButton.setVisible(true);
                nextButton.setVisible(false);
            }

        }

    }

}

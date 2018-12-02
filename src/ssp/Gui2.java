package ssp;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cwegner
 */
public class Gui2 extends JFrame
{
//<editor-fold defaultstate="collapsed" desc="Variablen">

    KI ki = new KI();
    Gewinner sieger = new Gewinner();
    SaveResults save = new SaveResults();
    
    JFrame frame;
    JPanel panel1, panel2, panel3;
    JLabel nameLabel, roundLabel, spielstand, gewinner,
            auswahlAnzeige, punktestand, rundenCounter;
    JTextField nameField, roundField;
    JButton eingabeButton, steinButton, schereButton, papierButton, nextButton;
    
    int spielerScore, compScore, rundenZahl, RundenZeiger = 1, siegerNummer;
    String name, runden, spielerwahl, computerwahl;

    //</editor-fold>
    public Gui2()
    {
//<editor-fold defaultstate="collapsed" desc="Frames und Panels">

        // Erstellung des Frames //
        frame = new JFrame("Stein - Schere - Papier");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.lightGray);

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
        panel3 = new JPanel();

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

        // Panel 3 //
        panel3.setLayout(new GridBagLayout());
        panel3.setBounds(200, 100, 400, 60);
        panel3.setVisible(false);
        GridBagConstraints c2 = new GridBagConstraints();
        frame.add(panel3);

        //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Objekte Panel 1">
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

        //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Objekte Panel 2">
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
        
        panel1.revalidate();
        panel1.repaint();

        //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Objekte Panel 3">
        rundenCounter = new JLabel("Runde: " + RundenZeiger);
        panel3.add(rundenCounter, c2);
        panel1.revalidate();
        panel1.repaint();
        //</editor-fold>
    }

//<editor-fold defaultstate="collapsed" desc="Button-Events">
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
                panel3.setVisible(true);
                
            }
            
            if (e.getSource() == steinButton)
            {
                spielerwahl = "Stein";
                Gewinn();
            }
            
            if (e.getSource() == schereButton)
            {
                spielerwahl = "Schere";
                Gewinn();
            }
            
            if (e.getSource() == papierButton)
            {
                spielerwahl = "Papier";
                Gewinn();
            }
            
            if (e.getSource() == nextButton)
            {
                RundenZeiger++;
                rundenCounter.setText("Runde: " + RundenZeiger);
                steinButton.setVisible(true);
                schereButton.setVisible(true);
                papierButton.setVisible(true);
                nextButton.setVisible(false);
                
            }
            
        }
        
    }
//</editor-fold>    
//<editor-fold defaultstate="collapsed" desc="Berechnungen">

    public void Gewinn()
    {
        
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

        // Runden-Schleife //
        for (int i = 1; i < rundenZahl; i++)
        {
            rundenZahl--;
            if (rundenZahl > 0)
            {
                nextButton.setVisible(true);
            }
            
        }

        // Spielende //
        if (RundenZeiger == Integer.parseInt(runden))
        {
            // Ausgabe Endergebnis //
            String resultat = sieger.GewinnerString(spielerScore, compScore);
            rundenCounter.setText(resultat);

            // Druck Endergebnis //
            save.Create();
            save.Write(resultat);
            
        }
        
    }
    //</editor-fold>
}

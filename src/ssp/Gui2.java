package ssp;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author cwegner
 */
public class Gui2
{

    public Gui2()
    {
        // Erstellung des Frames //
        JFrame frame = new JFrame("Stein - Schere - Papier");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setResizable(false);

        // Frame Position Bildschirm-Mitte //
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (dimension.width - w) / 2;
        int y = (dimension.height - h) / 2;
        frame.setLocation(x, y);

        // Panels //
        JPanel panel1 = new JPanel();
        // panel1.setBackground(Color.red);
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        panel1.setBorder(new EmptyBorder(10, 10, 10, 20));
        panel1.setBounds(200, 200, 400, 200);
        panel1.setVisible(true);
        frame.add(panel1);

        // Border //
        TitledBorder border = new TitledBorder(" Deine Angaben ");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        panel1.setBorder(border);

        // Objekte //
        JLabel labelName = new JLabel("Wie ist dein Name?");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel1.add(labelName, constraints);

        JTextField nameField = new JTextField(20);
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel1.add(nameField, constraints);
        nameField.setSize(nameField.getPreferredSize());

        JLabel labelRunden = new JLabel("Wieviele Runden?");
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel1.add(labelRunden, constraints);
        labelRunden.setSize(labelRunden.getPreferredSize());

        JTextField roundField = new JTextField(5);
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel1.add(roundField, constraints);
        nameField.setSize(roundField.getPreferredSize());

        JButton buttonEingabe = new JButton("Bestätigen");
        constraints.weighty = 2;
        constraints.gridx = 0;
        constraints.gridy = 4;
        buttonEingabe.setSize(buttonEingabe.getPreferredSize());
        panel1.add(buttonEingabe, constraints);

        panel1.revalidate();
        panel1.repaint();

    }

}

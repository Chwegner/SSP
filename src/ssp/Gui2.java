package ssp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
        frame.setResizable(false);

        // Fenster Position Bildschirm-Mitte //
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (dimension.width - w) / 2;
        int y = (dimension.height - h) / 2;
        frame.setLocation(x, y);

        // Panels //
        JPanel panel1 = new JPanel();
        frame.add(panel1);

        JPanel panel2 = new JPanel();

        // Objekte //
        JLabel labelName = new JLabel("Wie ist dein Name?");
        JTextField nameField = new JTextField("Eingabe");
        panel1.add(labelName);
        panel1.add(nameField);
    }

}

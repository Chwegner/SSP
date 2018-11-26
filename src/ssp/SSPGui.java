package ssp;

// https://stackoverflow.com/questions/11648208/switch-panels-in-a-jframe //
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author cwegner
 */
public class SSPGui extends JFrame implements ActionListener
{

    private final JLabel label;
    private final JButton button;
    private final JTextField namefield;
    private final JFrame panel;

    // Konstruktor //
    public SSPGui()
    {

        // Objekte kreieren und einfügen //
        panel = new JFrame();
        label = new JLabel("Wie ist dein Name?");
        namefield = new JTextField(15);
        button = new JButton("Klick");

        this.panel.setLayout(new FlowLayout());
        this.panel.setSize(200, 200);
        this.panel.setVisible(true);
        this.panel.setTitle("Stein - Schere - Papier");
        this.panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Objekte dem Actionlistener zuordnen //
        button.addActionListener(this);

        // Objekte dem JPanel zuordnen //
        add(label);
        add(namefield);
        add(button);
        panel.add(label);
        panel.add(namefield);
        panel.add(button);

    }

    // Action-Event Methoden: //
    @Override
    public void actionPerformed(ActionEvent name)
    {
        if (this.button == name.getSource())
        {
            String nameEingabe = namefield.getText();
            System.out.println(nameEingabe);
            this.panel.setVisible(false);
        }

    }

}

package ssp;

import java.awt.Dialog;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cwegner
 */
public class Gui2 extends JFrame {

    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel nameLabel;
    private JLabel roundLabel;
    private JTextField nameField;
    private JTextField roundField;
    private JButton eingabeButton;

    public Gui2() {

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
        setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
        eingabeButton.addActionListener(new EingabeListener());
        this.getContentPane().add(eingabeButton);
        panel1.add(eingabeButton, constraints);
        panel1.revalidate();
        panel1.repaint();

    }

    class EingabeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == eingabeButton) {
                System.out.println("Button gedrückt");
            }

        }

    }

    public String nameString() {
        String name = nameField.getText();
        return name;

    }

}

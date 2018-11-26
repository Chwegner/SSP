
package ssp;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Chef
 */
public class GuiPanel1 {
    
    private JLabel labelName;
    private JLabel labelRunden;
    private JTextField textName;
    private JTextField runden;
    private JButton buttonEingabe;
    private JPanel panelEingabe;
    
    public GuiPanel1(JPanel panel)
    {
    panelEingabe = panel;
    labelName = new JLabel("Wie ist dein Name?");
    textName = new JTextField();
    labelRunden = new JLabel("Wieviele Runden?");
    runden = new JTextField();
    buttonEingabe = new JButton("Eingabe");
    buttonEingabe.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            CardLayout cardLayout = (CardLayout) panelEingabe.getLayout();
            cardLayout.next(panelEingabe);
        }
    });
        panel.add(labelName);
        panel.add(textName);
        panel.add(labelRunden);
        panel.add(runden);
        panel.add(buttonEingabe);    
    }
    
    
    
    
}

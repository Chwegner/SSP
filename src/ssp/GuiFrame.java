package ssp;


import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Chef
 */
public class GuiFrame extends JFrame {

    private JPanel panel;
    private GuiPanel1 panelEingabe;
    private GuiPanel2 panelSpiel;    
    
    private void displayGUI(){
    
    JFrame frame = new JFrame("Stein - Schere - Papier");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    panel.setLayout(new CardLayout());
    panelEingabe = new GuiPanel1(panel);
    panelSpiel   = new GuiPanel2(panel);    
    
    panel.add("Eingabe", panelEingabe);
    
    
    
    
    }
    
    
    
    
    
}

package ssp;

import javax.swing.JOptionPane;

/**
 *
 * @author cwegner
 */
public class SSP {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Start der GUI //
        Gui2 gui = new Gui2();
        String name2 = gui.nameString();
        System.out.println(name2);

        //Eingabe Spielername und Rundenanzahl //
        String name = JOptionPane.showInputDialog("Dein Name?");
        int runden = Integer.parseInt(JOptionPane.showInputDialog("Wieviele Runden?"));

        // Punktestände //
        int SpielerScore = 0;
        int CompScore = 0;

        // Schleife Durchläufe => Anzahl der Runden //
        for (int i = 1; i <= runden; i++) {
            // Wahl des Spielers //
            String spielerwahl = JOptionPane.showInputDialog("Stein, Schere oder Papier");
            // Wahl des Computers //
            KI CompWahl = new KI();
            String Computer = CompWahl.ComputerWahl();
            Gewinner sieger = new Gewinner();

            // Unentschieden - gleiche Wahl //
            if (spielerwahl.equals(Computer)) {
                SpielerScore++;
                CompScore++;
                System.out.println(i + ". Runde: Unentschieden!");

            } else {
                // kein Unentschieden //
                if (sieger.GewinnerString(spielerwahl, Computer) == 1) {
                    SpielerScore++;
                    System.out.println(i + ". Runde: " + name + " gewinnt!");

                } else {
                    CompScore++;
                    System.out.println(i + ". Runde: Der Computer gewinnt!");

                }
            }
            // Ausgabe der Wahlen und aktueller Punktestand //
            System.out.println(name + " wählte: " + spielerwahl);
            System.out.println("Computer wählte: " + Computer);
            System.out.println("Punktestand " + name + " : " + SpielerScore);
            System.out.println("Punktestand Computer: " + CompScore + "\n");

        }

        // Ausgabe Endresultat //
        if (SpielerScore > CompScore) {
            System.out.println(name + " gewinnt das Spiel!!!");
        } else if (SpielerScore < CompScore) {
            System.out.println("Du hast das Spiel verloren!!!");

        } else {
            System.out.println("Das Spiel endet Unentschieden!!!");
        }

        // Erstellen der SaveDatei und speichern des Ergebnisses //
        SaveResults results = new SaveResults();
        results.Create();
        results.Write(name + ": " + SpielerScore + " Computer: " + CompScore + "\r\n");
    }

}

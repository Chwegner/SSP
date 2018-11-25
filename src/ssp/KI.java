package ssp;

/**
 *
 * @author Chef
 */
public class KI {

    public String ComputerWahl() {

        // Zufallszahl 1-3 //
        int temp = (int) (Math.random() * 3 + 1);

        // Zuordnung Zahl zu Auswahl //
        String CompWahl;
        switch (temp) {
            case 1:
                CompWahl = "Stein";
                break;
            case 2:
                CompWahl = "Schere";
                break;
            default:
                CompWahl = "Papier";
                break;
        }
        return CompWahl;
    }

}

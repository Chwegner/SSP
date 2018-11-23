package ssp;

/**
 *
 * @author Chef
 */
public class KI
{

    public String ComputerWahl()
    {

        // Zufallszahl 1-3 //
        int temp = (int) (Math.random() * 3 + 1);

        // Zuordnung Zahl zu Auswahl //
        String CompWahl;
        if (temp == 1)
        {
            CompWahl = "Stein";
        } else if (temp == 2)
        {
            CompWahl = "Schere";
        } else
        {
            CompWahl = "Papier";
        }
        return CompWahl;
    }

}

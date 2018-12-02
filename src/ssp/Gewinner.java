package ssp;

/**
 *
 * @author Chef
 */
public class Gewinner
{

    // Ermittlung des Rundensiegers (1 = Spieler, 2 = Computer, 3 = Unentschieden) nach Spielregeln. //
    public int GewinnerString(String spielerwahl, String Computer)
    {
        int sieger = 0;
        if (spielerwahl.equals("Stein") && Computer.equals("Schere"))
        {
            sieger = 1;
        }
        else if (spielerwahl.equals("Stein") && Computer.equals("Papier"))
        {
            sieger = 2;
        }
        else if (spielerwahl.equals("Schere") && Computer.equals("Stein"))
        {
            sieger = 2;
        }
        else if (spielerwahl.equals("Schere") && Computer.equals("Papier"))
        {
            sieger = 1;
        }
        else if (spielerwahl.equals("Papier") && Computer.equals("Stein"))
        {
            sieger = 1;
        }
        else if (spielerwahl.equals("Papier") && Computer.equals("Schere"))
        {
            sieger = 2;
        }
        else if (spielerwahl.equals("Papier") && Computer.equals("Schere"))
        {
            sieger = 2;
        }
        else if (spielerwahl.equals(Computer))
        {
            sieger = 3;
        }
        else
        {
            sieger = 666;
        }

        return sieger;
    }

    public String GewinnerString(int spieler, int computer)
    {
        String ausgabe;
        if (spieler > computer)
        {
            ausgabe = "Du gewinnst. Endstand " + spieler + " : " + computer;
        }
        else if (spieler < computer)
        {
            ausgabe = "Du verlierst. Endstand " + spieler + " : " + computer;
        }
        else
        {
            ausgabe = "Unentschieden. Endstand " + spieler + " : " + computer;
        }

        return ausgabe;
    }

}

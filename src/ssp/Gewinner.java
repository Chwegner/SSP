package ssp;

/**
 *
 * @author Chef
 */
public class Gewinner {

    public int GewinnerString(String spielerwahl, String Computer) {
        int sieger = 0;
        if (spielerwahl.equals("Stein") && Computer.equals("Schere")) {
            sieger = 1;
        } else if (spielerwahl.equals("Stein") && Computer.equals("Papier")) {
            sieger = 2;
        } else if (spielerwahl.equals("Schere") && Computer.equals("Stein")) {
            sieger = 2;
        } else if (spielerwahl.equals("Schere") && Computer.equals("Papier")) {
            sieger = 1;
        } else if (spielerwahl.equals("Papier") && Computer.equals("Stein")) {
            sieger = 1;
        } else if (spielerwahl.equals("Papier") && Computer.equals("Schere")) {
            sieger = 2;
        }

        return sieger;
    }

}
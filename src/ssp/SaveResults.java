package ssp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Chef
 */
public class SaveResults {

    public void Create() {
        // Falls noch keine Datei existiert, wird sie hier erschaffen //
        try {
            File neueLog = new File("D:\\Downloads\\SSPlog.txt");
            if (!neueLog.isFile()) {
                neueLog.createNewFile();
                System.out.println("Neue Log-Datei wurde erstellt unter " + neueLog);

            }

        } catch (IOException e) {
            System.out.println("Fehler beim Erstellen der Log-Datei.");
            e.printStackTrace(System.out);
        }

    }

    public void Write(String result) {
        // Hier werden die Endresultate mit ensprechendem Datum und Uhrzeit eingefügt //
        try {
            // Aktuelles Datum: //
            Date date = new Date();
            SimpleDateFormat anders = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

            // Schreiben:
            FileWriter ResultWriter = new FileWriter("D:\\Downloads\\SSPlog.txt", true);
            ResultWriter.write(anders.format(date) + " " + result);
            ResultWriter.close();
            System.out.println("Ergebnisse wurden gespeichert.");

        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Ergebnisse.");
            e.printStackTrace(System.out);
        }

    }

}

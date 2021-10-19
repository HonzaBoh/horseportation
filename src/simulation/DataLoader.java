package simulation;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Trida pro nacitani vstupnich dat
 * Data nacita dle parametru urcenych v zadani
 * Slouzi k predani informaci: pocet + mnozina Koni, pocet + mnozina Letadel, souradnice Parize
 * Veskere metody jsou staticke a slouzi k uhlednejsi komunikaci programu se zdrojem souboru za pouziti Scanneru
 * Nekompatibilni se souborem tutorial, nepracuje se smajliky coby znakem komentare
 */
public class DataLoader {
    /**
     * souradnice Parize
     */
    public static int parisX, parisY;

    /**
     * Prostredek pro nacitani dat z radku nactenych z datasetu
     */
    static private Scanner sc;

    /**
     * Prostredek pro nacitani radku z datasetu
     */
    static private BufferedReader br;

    /**
     * Pouziva stejny mechanismus uzivany pri nacitani. Soubory cte po typech.
     * Preformatovany vystup je na konzoli bez baleni informaci do objektu
     *
     * @param FilePath cesta k datasetu pro vypsani
     * @throws FileNotFoundException v pripade zadani spatne cesty k datasetu
     * @throws IOException           v pripade chyby cteni (NENECHAVAT DATASET NA FLASH DISKU A TEN ZKOUSET ZA BEHU ODPOJIT!)
     */
    static void descriptiveRead(String FilePath) throws IOException {
        br = new BufferedReader(new FileReader(new File(FilePath)));
        String line;
        String content = "";
        while ((line = br.readLine()) != null) {
            if (line.length() > 0) {
                if (!line.startsWith(":-)")) {
                    if (line.contains(":-)")) {
                        content += " " + line.substring(0, line.indexOf(":-)"));
                    }
                    else {
                        content += line;
                    }
                }
            }
        }
        System.out.println(content);
        System.out.println("____");
        sc = new Scanner(content);
        sc.useLocale(Locale.US);
        System.out.println("Coordinates of Paris: x = " + sc.nextDouble() + ", y = " + sc.nextDouble());
        int tmp = sc.nextInt();
        System.out.println("Count of horses " + tmp);
        for (int i = 0; i < tmp; i++) {
            System.out.println("Horse #" + (i + 1) + ": x: " + sc.nextDouble() + ", y = " + sc.nextDouble()
                    + ", weight = " + sc.nextDouble() + ", loadingTime = " + sc.nextDouble());
        }

        tmp = sc.nextInt();
        System.out.println("Planes available: " + tmp);
        System.out.println(sc.hasNextDouble());
        System.out.println(sc.hasNextInt());
        for (int i = 0; i < tmp; i++) {
            System.out.println("Plane #" + (i + 1) + ": x: " + sc.nextDouble() + ", y = " + sc.nextDouble()
                    + ", Velocity = " + sc.nextDouble() + ", capacity = " + sc.nextDouble());
        }
    }
}

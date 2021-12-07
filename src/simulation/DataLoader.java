package simulation;

import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Trida pro nacitani vstupnich dat
 * Data nacita dle parametru urcenych v zadani
 * Slouzi k predani informaci: pocet + mnozina koni, pocet + mnozina Letadel, souradnice Parize
 * Veskere metody jsou staticke a slouzi k uhlednejsi komunikaci programu se zdrojem souboru za pouziti Scanneru
 * Nekompatibilni se souborem tutorial, nepracuje se smajliky coby znakem komentare
 */
public class DataLoader {


    /**
     * Prostredek pro nacitani dat z radku nactenych z datasetu
     */
    static private Scanner sc;

    /**
     * Prostredek pro nacitani radku z datasetu
     */
    static private BufferedReader br;

    /**
     * Pouziva stejny mechanismus uzivany pri nacitani. Soubory cte po typech a uklada je do patricnych objektu
     * @param FilePath cesta k souboru
     * @param planes struktura pro ulozeni letadel
     * @param stops struktura pro ulozeni zastavek
     * @throws IOException problem nacteni souboru
     */
    static void objectRead(String FilePath, List<Plane> planes, List<Town> stops) throws IOException {
        br = new BufferedReader(new FileReader(new File(FilePath)));
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.length() > 0 && !line.startsWith(":-)")) {
                    if (line.contains(":-)")) {
                        content.append(" ").append(line.substring(0, line.indexOf(":-)")));
                    }
                    else {
                        content.append(" ").append(line);
                    }
            }
        }
        sc = new Scanner(content.toString());
        sc.useLocale(Locale.US);
        SimulationEnvironment.PARIS_X = sc.nextDouble();
        SimulationEnvironment.PARIS_Y = sc.nextDouble();
        System.out.println("Paris (" + SimulationEnvironment.PARIS_X + ", " + SimulationEnvironment.PARIS_Y +  ")");

        int tmp = sc.nextInt();
        for (int i = 0; i < tmp; i++) {
           stops.add(new Town(sc.nextDouble(), sc.nextDouble(), sc.nextInt(), sc.nextInt()));
        }
        tmp = sc.nextInt();
        for (int i = 0; i < tmp; i++) {
            planes.add(new Plane(sc.nextDouble(), sc.nextDouble(), sc.nextInt(), sc.nextDouble()));
            planes.get(i).setPlaneID(i);
        }
    }

}

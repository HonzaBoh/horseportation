package simulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Background prostredi pro vsechny informace v prubehu simulace
 * Uskladni veskere objekty, ktere v simulaci figuruji
 * Uklada si souradnice Parize, ktere jsou vzdy jedenkrat za simulaci a jsou nemenne (napsana stylem 'final' bez final)
 */
public class SimulationEnvironment {
    /**
     * kartezska X souradnice Parize
     */
    public static double PARIS_X;
    /**
     * kartezska Y souradnice parize
     */
    public static double PARIS_Y;

    /**
     * Prostredek pro zapisovani vstupu s casovym razenim
     */
    public static List<SimulationLog> simulationLogger;

    /**
     * Vypise do konzole cas trvani k potrebnemu ukonceni simulace
     * Pocita s delkou trvani nejdelsi cesty, ostatni dalsi jsou kratsi
     * CasSimulace = max(plane.timeDilation[0] - plane.timeDilation[i]), i == plane.size - 1
     * @param planes seznam vsech letadel
     */
    void simulatedEnd(List<Plane> planes){
        Collections.sort(planes);
        String endMsg;
        if (planes.get(0).getTimeDilatation() < 1){
            endMsg = "Time required for the entire transportation process is actually less than 1 temporal units of time, our planes are fast as fuck :)";
        }
        else {
            endMsg = "Time required for the entire transportation process is " + planes.get(0).getTimeDilatation() + " temporal units of time";
        }
        System.out.println(endMsg);
        Collections.sort(simulationLogger);
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")))){
            pw.println("Paris is located at x: " + PARIS_X + ", y: " + PARIS_Y);
            for (SimulationLog simulationLog : simulationLogger) {
                pw.println(simulationLog);
            }
            pw.println("   ");
            pw.println(endMsg);
        }catch (IOException ioException){
            System.out.println("Pocitac hori");
        }
    }


    /**
     * Spousteci bod pro simulaci - vytvoreni mapy pro vypocet vzdalenosti
     * @param stops seznam zastavek, pro nabirani koni
     * @param planes seznam letadel prepravujici kone
     */
    public void runSimulation(List<Plane> planes, List<Town> stops){
        simulationLogger = new ArrayList<>();
        Mapa mapa = new Mapa(stops, planes);
        mapa.firstFly();
        simulatedEnd(planes);
    }


}

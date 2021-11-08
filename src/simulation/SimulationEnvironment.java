package simulation;

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
     * Vypise do konzole cas trvani k potrebnemu ukonceni simulace
     * Pocita s delkou trvani nejdelsi cesty, ostatni dalsi jsou kratsi
     * CasSimulace = max(plane.timeDilation[0] - plane.timeDilation[i]), i == plane.size - 1
     * @param planes
     */
    void simulatedEnd(List<Plane> planes){
        Collections.sort(planes);
        System.out.println("Time required for the entire transportation process is " + planes.get(0).getTimeDilatation() + " min");
    }

    /**
     * Spousteci bod pro simulaci
     * TODO: vytvoreni tridy mapa, predani jedne instance do simulace
     */
    public void runSimulation(List<Plane> planes, List<Town> stops){
        Mapa mapa = new Mapa(stops, planes);
        mapa.firstFly();
        simulatedEnd(planes);
    }


}

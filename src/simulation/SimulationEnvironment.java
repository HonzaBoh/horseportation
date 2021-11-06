package simulation;

import java.util.List;

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
     * Vypise soucasny stav vsech letadel pri jakekoliv zmene stavu
     * Zmeny stavu: zacatek simulace, odlet, nakladani kone (zacatek i nalozeni), pristani, pristani Pariz
     * @param planes jednotlive entity, jejich cas se vypisuje
     * @param stops debugging ucel, sleduje vyznamne souradnice ve vztahu k vypisu
     */
    public void getStatus(List<Plane> planes, List<Town> stops){

    }

    /**
     * Spousteci bod pro simulaci
     * TODO: vytvoreni tridy mapa, predani jedne instance do simulace
     */
    public void runSimulation(List<Plane> planes, List<Town> stops){
        Mapa mapa = new Mapa(stops, planes);
        mapa.firstFly();
    }


}

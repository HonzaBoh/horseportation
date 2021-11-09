package simulation;

/**
 *  Pomocna trida pro uchavani zapisu do vystupu, slouzi jako jeden simnulacni pri zmene stavu
 */
public class SimulationLog implements Comparable<SimulationLog>{
    /** stav objektu - letadlo*/
    String entry;
    /** casovy udaj zmeny stavu letadla*/
    int timeEntry;

    /**
     *  Konstruktor pro zabaleni entry
     * @param entry zprava
     * @param timeEntry casovy udaj
     */
    public SimulationLog(String entry, int timeEntry) {
        this.entry = entry;
        this.timeEntry = timeEntry;
    }

    /**
     * porovnavaci prostredek jednotlivych logu k serazeni dle casovych udaju
     * @param simulationLog druhy log k porovnani
     * @return vetsi ze dvou porovnanych, integer compare u casovych udaju
     */
    @Override
    public int compareTo(SimulationLog simulationLog) {
        return Integer.compare(this.timeEntry, simulationLog.timeEntry);
    }

    /**
     * String podoba zaznamu, pouzito pro vystup simulace
     * @return supr cupr hezky vypis
     */
    @Override
    public String toString() {
        return "Time: " + timeEntry + ": " + entry;
    }
}

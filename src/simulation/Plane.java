package simulation;

/**
 * Trida Letadlo
 */
public class Plane implements Comparable<Plane>{

    /**
     * Hlida nasledujici zastavku pro vypocet doby presunu
     */
    Town nextStop;

    /**
     * Nasledujici zastavka
     * @param nextStop Dalsi zastavka pro letadlo
     */
    public void setNextStop(Town nextStop) {
        this.nextStop = nextStop;
    }

    /**
     * Vpocita dobu presunu letadla do Parize a zaroven nastavi pozici letadla na pozici Parize
     * @return doba letu do parize
     */
    public double getParisTravelTime(){
        double travelTime = (this.velocity * getParisDistance());
        this.x = SimulationEnvironment.PARIS_X;
        this.y = SimulationEnvironment.PARIS_Y;
        return travelTime;
    }

    /**
     * Ziska vzdalenost soucasneho umisteni letadla od Parize
     * @return vzdalenost letadlo -> Pariz
     */
    public double getParisDistance(){
        return Math.sqrt(Math.pow(SimulationEnvironment.PARIS_X - this.x, 2) + Math.pow(SimulationEnvironment.PARIS_Y - this.y, 2));
    }

    /**
     * Vypocet doby presunu mezi soucasnou a nasledujici pozice
     * Jednoduchy fyzikalni vypocet
     * @return doba presunu v sekundach
     */
    public double getTravelTime(){
        double travelTime = (this.velocity * getDistance());
        this.x = this.nextStop.x;
        this.y = this.nextStop.y;
        return travelTime;
    }

    /**
     * Vzdalenost dvou bodu v rovine
     * @return vzdalenost dvou bodu v rovine dle vypoctu prepony
     */
    public double getDistance(){
        return Math.sqrt(Math.pow(nextStop.x - this.x, 2) + Math.pow(nextStop.y - this.y, 2));
    }

    /**
     * souradnice letadla x
     */
    public double x;
    /**
     * souradnice letadla y
     */
    public double y;
    /**
     * kapacita letadla
     */
    public int capacity;
    /**
     * rychlost v letadla
     */
    public double velocity;
    /**
     * aktualni zaplneni letadla
     */
    public int actualCapacity;

    /**
     * Sleduje cas ve vztahu k simulaci, ve kterem se objekt letadla nachazi, dale figuruje v predani do vystupu
     */
    public double timeDilatation;

    /**
     *  Vrati stav letadla v case po prubeh simulace
     * @return Soucany casovy posun
     */
    public int getTimeDilatation() {
//        System.out.println(this.timeDilatation);
        return (int)timeDilatation;
    }

    /**
     * soucasny stav letadla, ruzne stavy viz. {@code Status} & {@code Mapa.statusChange(...)}
     */
    private String currentStatus;

    /**
     * Zjisteni soucasneho stavu letadla pro vypis v simulaci
     * @return soucasny stav letadla
     */
    public String getCurrentStatusTimed() {
        return currentStatus + ", time is " + getTimeDilatation() + " temporal units of time";
    }

    /**
     * Zjisteni soucasneho stavu letadla pro vypis v simulaci do souboru
     * @return soucasny stav letadla
     */
    public String getCurrentStatus() {
        return currentStatus;
    }

    /**
     * Nastaveni soucasneho stavu letadla, spojeno s jakoukoliv zmenou stavu letadla v simulaci viz {@code Mapa.statusChange()}
     * @param currentStatus soucasny stav letadla
     */
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
        SimulationEnvironment.simulationLogger.add(new SimulationLog(getCurrentStatus(), getTimeDilatation()));
    }

    /**
     * konstruktor
     * @param x ...souradnice x
     * @param y ...souradnice y
     * @param capacity ...kapacita letadla
     * @param speed ...rychlost letadla
     */
    public Plane (double x, double y, int capacity, double speed) {
        this.x = x;
        this.y = y;
        this.capacity = capacity;
        this.velocity = speed;
        actualCapacity = capacity;
        timeDilatation = 0;
    }

    /**
     * Porovna dve letadla na zaklade jejich casu v jedne instanci simulace
     * @param p letdlo, se kterym se toto letadlo porovnanva
     * @return letadlo, ktere je v simulaci drive
     */
    @Override
    public int compareTo(Plane p) {
        return Double.compare(p.getTimeDilatation(), this.timeDilatation);
    }
}

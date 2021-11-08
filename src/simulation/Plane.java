package simulation;

import org.jetbrains.annotations.NotNull;

/**
 * Trida Letadlo
 */
public class Plane implements Comparable{

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
    public double speed;
    /**
     * aktualni zaplneni letadla
     */
    public int actualCapacity;

    /**
     * Sleduje cas ve vztahu k simulaci, ve kterem se objekt letadla nachazi, dale figuruje v predani do vystupu
     */
    public int timeDilatation;

    public int getTimeDilatation() {
        return timeDilatation;
    }

    /**
     * soucasny stav letadla, ruzne stavy viz. {@code Status} & {@code Mapa.statusChange(...)}
     */
    private String currentStatus;

    /**
     * Zjisteni soucasneho stavu letadla pro vypis v simulaci
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
        this.speed = speed;
        actualCapacity = capacity;
        timeDilatation = 0;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return Integer.compare(((Plane) o).getTimeDilatation(), this.timeDilatation);
    }
}

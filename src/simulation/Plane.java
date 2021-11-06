package simulation;
/**
 * Trida Letadlo
 */
public class Plane {
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
    }
}

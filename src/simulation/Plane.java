package simulation;

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
     * rychlost v letadla
     */
    public double speed;
    /**
     * kapacita letadla
     */
    public int capacity;

    public Plane (double x, double y, double speed, int capacity) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.capacity = capacity;
    }
}

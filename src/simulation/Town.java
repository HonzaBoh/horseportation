package simulation;

public class Town {
    /**
     * souradnice mesta x
     */
    public double x;
    /**
     * souradnice mesta y
     */
    public double y;
    /**
     * doba nakladani nakladu
     */
    public double load;
    /**
     * vaha nakladu
     */
    public int weight;

    public Town (double x, double y, double load, int weight) {
        this.x = x;
        this.y = y;
        this.load = load;
        this.weight = weight;
    }
}

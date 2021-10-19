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
    public int load;
    /**
     * vaha nakladu
     */
    public int weight;

    public Town (double x, double y, int load, int weight) {
        this.x = x;
        this.y = y;
        this.load = load;
        this.weight = weight;
    }
}

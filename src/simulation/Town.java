package simulation;


/**
 * Trida Mesto ("kun")
 */
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
    /**
     * konstruktor
     * @param x ...souradnice x
     * @param y ...souradnice y
     * @param load ...doba nalozeni
     * @param weight ...vaha nakladu
     */
    public Town (double x, double y, int weight, int load) {
        this.x = x;
        this.y = y;
        this.load = load;
        this.weight = weight;
    }
}

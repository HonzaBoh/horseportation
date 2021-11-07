package simulation;
import java.util.ArrayList;
import java.util.List;

public class Mapa { //nejde pojmenovat Map? Wtf :D
    /**
     * list letadel, která máme k dispozici
     */
    List<Plane> planes = new ArrayList<>();
    /**
     * list mest, ktera musime proletet
     */
    List<Town> towns = new ArrayList<>();
    /**
     * list mest, ktera jsme proleteli
     */
    List<Town> townsDone = new ArrayList<>();

    /**
     * Konstruktor pro mapu
     * @param towns list mest, ktera se musi proletet
     * @param planes list letadel, ktera mame k dispozici
     */
    public Mapa(List<Town> towns, List<Plane> planes) {
        this.planes = planes;
        this.towns = towns;
    }

    /**
     *  Metoda naplni vsechna letadla co nejvice lze a vykona prvni let smerem do Parize
     */
    public void firstFly() {

        for (int p = 0; p < planes.size() && towns.size() != 0; p++) {
            System.out.println("\nLetadlo: " + p + ", capacity = " + planes.get(p).capacity);
            for (int i = 0; i < towns.size(); i++) {
                if (planes.get(p).actualCapacity - towns.get(i).weight >= 0) {
                    planes.get(p).actualCapacity -= towns.get(i).weight;
                    System.out.println("\tLoading horses with weight: " + towns.get(i).weight);
                    townsDone.add(towns.get(i));
                    towns.remove(i);
                    i = -1;
                }
            }
            System.out.println("Plane " + p + " is going to Paris with actual Capacity: " + planes.get(p).actualCapacity);
        }
    }
}

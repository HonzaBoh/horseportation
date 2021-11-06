package simulation;
import java.util.ArrayList;
import java.util.List;

public class Mapa { //nejde pojmenovat Map? Wtf :D

    List<Plane> planes = new ArrayList<>();
    List<Town> towns = new ArrayList<>();
    List<Town> townsDone = new ArrayList<>();

    int p = 0; //number of plane

    public Mapa(List<Town> towns, List<Plane> planes) {
        this.planes = planes;
        this.towns = towns;
    }

    /*
    Metoda zatim! prvnimu letadlu z listu pritadi mesta tak, aby se mu neprekrocila kapacita, ukaze se tak prvni let
     */
    public void firstFly() {
        System.out.println(planes.get(p).capacity);
        System.out.println();

        for (int i = 0; i < towns.size(); i++) {
            if (planes.get(p).actualCapacity - towns.get(i).weight >= 0) {
                planes.get(p).actualCapacity -= towns.get(i).weight;
                townsDone.add(towns.get(i));
            }
        }
        for (int i = 0; i < townsDone.size(); i++) {
            System.out.println(townsDone.get(i).weight);
        }
        System.out.println();
        System.out.println(planes.get(p).actualCapacity);

        /*
        Zatim najde letadlu mesta ktera muze projet pri prvni ceste
         */
    }
}

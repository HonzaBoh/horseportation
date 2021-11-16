package simulation;

import java.util.ArrayList;
import java.util.List;

public class Mapa { //nejde pojmenovat Map? Wtf :D, Map je Interface, to je uplne neco jineho, co uz existuje :P
    /**
     * list letadel, která máme k dispozici
     */
    List<Plane> planes;
    /**
     * list mest, ktera musime proletet
     */
    List<Town> towns;
    /**
     * list mest, ktera jsme proleteli
     */
    List<Town> townsDone = new ArrayList<>();

    /**
     * Polomer Zeme zaokrouhlen na cele metry
     */
    public static final double EARTH_RADIUS = 6371.0;

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
            statusChange(planes.get(p), Status.SET_OFF, p, null, 0);
            System.out.println(planes.get(p).getCurrentStatusTimed());
//            System.out.println("\nPlane: " + p + " (capacity = " + planes.get(p).capacity + ") is setting off, time is " + planes.get(p).timeDilatation);
            for (int i = 0; i < towns.size(); i++) {
                if (planes.get(p).actualCapacity - towns.get(i).weight >= 0) {
                    planes.get(p).actualCapacity -= towns.get(i).weight;
                    statusChange(planes.get(p), Status.HORSE_LOAD, p, towns.get(i), townsDone.size());
                    System.out.println(planes.get(p).getCurrentStatusTimed());
                    //System.out.println("\tLoading horses with weight: " + towns.get(i).weight);
                    townsDone.add(towns.get(i));
                    towns.remove(i);
                    i = -1;
                }
            }
            statusChange(planes.get(p), Status.PARIS, p, null, 0);
            System.out.println(planes.get(p).getCurrentStatusTimed());
//            System.out.println("Plane " + p + " is going to Paris with actual Capacity: " + planes.get(p).actualCapacity);
        }
    }

    /**
     *
     * @param p letadlo v simulaci
     * @param stat status pro vyhodnoceni chovani letadla a posunu v case simulace
     * @param planeID evidence letadel pro hezky vypis :-)
     * @param horseLoadingPlace urceni specificke zastavky, pokud ji operace vyzaduje, v opacnem pripade null
     */
    private void statusChange(Plane p, Status stat, int planeID, Town horseLoadingPlace, int stopID){
        switch (stat){
            case HORSE_LOAD:
                p.setNextStop(horseLoadingPlace);
                p.timeDilatation+= horseLoadingPlace.load;
                p.setCurrentStatus("Plane " + planeID + " is loading horses from town: " + stopID + " with weight: " + horseLoadingPlace.weight);
                break;
            case PARIS:
                p.setCurrentStatus("Plane " + planeID + " is setting off to Paris with actual Capacity: " + p.actualCapacity);
                break;
            case SET_OFF:
                p.setCurrentStatus("Plane: " + planeID + " (capacity = " + p.capacity +
                    ") is setting off");
                break;
        }

    }
}

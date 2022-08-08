package simulation;

import java.util.*;

/**
 * Trida pro praci a konkretni vypocty v ramci simulace
 * Simulaci provadi na urovni programu, ktera je spise pro funkcionalni ucely, data nasledne preda do prosterdi a Loggeru
 */
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
     * Konstruktor pro mapu
     * @param towns list mest, ktera se musi proletet
     * @param planes list letadel, ktera mame k dispozici
     */
    public Mapa(List<Town> towns, List<Plane> planes) {
        this.planes = planes;
        //added comment
        this.towns = towns;
    }

    /**
     *  Metoda naplni vsechna letadla co nejvice lze a vykona prvni let smerem do Parize
     */
    public void firstFly() {
        int planeSize = planes.size();
        planes.sort(Plane.optimalPlane);// seradi letadla od nejlepsich
        for (int p = 0; towns.size() != 0; p++) {
            statusChange(planes.get(p), Status.SET_OFF, null, 0);
            System.out.println(planes.get(p).getCurrentStatusTimed());
//            System.out.println("\nPlane: " + p + " (capacity = " + planes.get(p).capacity + ") is setting off, time is " + planes.get(p).timeDilatation);
            for (int i = 0; i < towns.size(); i++) {
                if (planes.get(p).actualCapacity - towns.get(i).weight >= 0) {
                    planes.get(p).actualCapacity -= towns.get(i).weight;
                    statusChange(planes.get(p), Status.NEXT_STOP, towns.get(i), townsDone.size());
                    System.out.println(planes.get(p).getCurrentStatusTimed());
                    statusChange(planes.get(p), Status.HORSE_LOAD, towns.get(i), townsDone.size());
                    System.out.println(planes.get(p).getCurrentStatusTimed());
                    //System.out.println("\tLoading horses with weight: " + towns.get(i).weight);
                    townsDone.add(towns.get(i));
                    towns.remove(i);
                    i = -1;
                }
            }
        parisTurn(p, planeSize);
        }
        planes.removeAll(Collections.singleton(null));
    }

    /**
     * Zaradi letadlo na konec seznamu v Parizi
     * @param p polozka v seznam
     * @param planeSize velikost seznamu letadel
     */
    public void parisTurn(int p, int planeSize){
        statusChange(planes.get(p), Status.PARIS, null, 0);
        System.out.println(planes.get(p).getCurrentStatusTimed());
        Plane tmpPlane = planes.get(p);
        if (planeSize > 1 ) {
            planes.add(null);
            planes.add(p + 1, tmpPlane);
            planes.remove(tmpPlane); // pouziti fronty bez fronty
        }else {
            planes.add(p + 1, tmpPlane);
        }
        tmpPlane.actualCapacity = tmpPlane.capacity; //vylozil kone
    }

    /**
     *
     * @param p letadlo v simulaci
     * @param stat status pro vyhodnoceni chovani letadla a posunu v case simulace
     * @param horseLoadingPlace urceni specificke zastavky, pokud ji operace vyzaduje, v opacnem pripade null
     * @param stopID identifikator pro zastavku
     */
    private void statusChange(Plane p, Status stat,  Town horseLoadingPlace, int stopID){
        switch (stat){
            case HORSE_LOAD:
                p.timeDilatation+= horseLoadingPlace.load;
                p.transportedTotal += horseLoadingPlace.weight;
                p.setCurrentStatus("Plane " + p.getPlaneID() + " is loading horses from town: " + stopID + " with weight: " + horseLoadingPlace.weight);
                break;
            case PARIS:
                p.setCurrentStatus("Plane " + p.getPlaneID() + " is setting off to Paris with actual Capacity: " + p.actualCapacity);
                System.out.println(p.getCurrentStatusTimed()); //fuj
                p.timeDilatation += p.getParisTravelTime();
                p.setCurrentStatus("Plane " + p.getPlaneID() + " is landing in Paris with actual Capacity: " + p.actualCapacity);
                break;
            case SET_OFF:
                p.setCurrentStatus("Plane: " + p.getPlaneID() + " (capacity = " + p.capacity +
                    ") is setting off");
                break;
            case NEXT_STOP:
                p.setNextStop(horseLoadingPlace);
                p.timeDilatation += p.getTravelTime();
                p.setCurrentStatus("Plane " + p.getPlaneID() + " landed at town " + stopID + " and is prepared to load horses of weight: " + horseLoadingPlace.weight);
                break;
            default:
                System.out.println("There is something weird going on");
                System.out.println("Houston! We've got a stateless plane");
                break;
        }

    }
}

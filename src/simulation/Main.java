package simulation;

import java.io.IOException;
import java.util.*;

/**
 * Spousteci bod pro program
 * Data nacte a preda do simulacniho prostredi
 */
public class Main {
    /**
     * Startovaci bod programu
     * @param args cesta k souboru
     *
     */
    public static void main(String[] args){
        //DataLoader.descriptiveRead("Data\\parser.txt");
        List<Plane> tmpPlanes = new ArrayList<>();
        List<Town> tmpStops = new ArrayList<>();
        try {
            DataLoader.objectRead(args[0], tmpPlanes, tmpStops);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOE occured, ending terminating...");
            System.exit(0);
        }
        SimulationEnvironment firstSimulation = new SimulationEnvironment();
        firstSimulation.runSimulation(tmpPlanes, tmpStops);
        System.out.println("Readable entry saved to output.txt file");
        System.out.println("\nSimulation finished, thanks for using HorsePortation travel predictions and have a good day!");
    }
}

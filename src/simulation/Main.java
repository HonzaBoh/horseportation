package simulation;

import java.io.IOException;
import java.util.*;

public class Main {
    /**
     * Startovaci bod programu
     */
    public static void main(String[] args) throws IOException {
        //DataLoader.descriptiveRead("Data\\parser.txt");
        List<Plane> tmpPlanes = new ArrayList<>();
        List<Town> tmpStops = new ArrayList<>();
        DataLoader.objectRead(args[0], tmpPlanes, tmpStops);
        SimulationEnvironment firstSimulation = new SimulationEnvironment();
        firstSimulation.runSimulation(tmpPlanes, tmpStops);
        System.out.println("Readable entry saved to output.txt file");
        System.out.println("\nSimulation finished, thanks for using HorsePortation travel predictions and have a good day!");
    }
}

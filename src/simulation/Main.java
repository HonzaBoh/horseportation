package simulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    /**
     * Startovaci bod programu
     * TODO: vymyslet prvni pruchod simulaci, zajistit vypis zmeny stavu v case
     */
    public static void main(String[] args) throws IOException {
        //DataLoader.descriptiveRead("Data\\parser.txt");
        List<Plane> tmpPlanes = new ArrayList<>();
        List<Town> tmpStops = new ArrayList<>();
        DataLoader.objectRead("Data\\parser.txt", tmpPlanes, tmpStops); //správně funguje asi jen pro parser.txt :-(
        SimulationEnvironment firstSimulation = new SimulationEnvironment();
        firstSimulation.runSimulation(tmpPlanes, tmpStops);
        System.out.println("\nSimulation finished, thanks for using HorsePortation travel predictions and have a good day!");
    }
}

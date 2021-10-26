package simulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //DataLoader.descriptiveRead("Data\\parser.txt");
        List<Plane> tmpPlanes = new ArrayList<>();
        List<Town> tmpStops = new ArrayList<>();
        DataLoader.objectRead("Data\\parser.txt", tmpPlanes, tmpStops);
    }
}

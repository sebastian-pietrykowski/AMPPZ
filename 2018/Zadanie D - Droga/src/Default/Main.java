package Default;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Data data = Loader.load(new File("2018/Zadanie D - Droga/input1.txt"));
//        System.out.println(data.toString());
        Road road = new Road(data.nOfSections);
        Simulator simulator = new Simulator(road, data);
        simulator.simulate();
    }
}

package Default;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] oscypkiSets = Loader.loadOscypki(new File("2019/Zadanie H - Oscypki/src/input.txt"));

        int results[] = new int[oscypkiSets.length];
        for (int i = 0; i < oscypkiSets.length; i++)
            results[i] = new Algorithm(oscypkiSets[i]).findMaxSumOfDeliciousnessForAlicja();
        System.out.println(Arrays.toString(results));
    }
}

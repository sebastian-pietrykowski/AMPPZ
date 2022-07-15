package Default;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        long startTime = System.currentTimeMillis();

        int[][] oscypkiSets = Loader.loadOscypki(new File("2019/Zadanie H - Oscypki/src/input.txt"));

        int[] results = new int[oscypkiSets.length];
        for (int i = 0; i < oscypkiSets.length; i++) {
            MaxMovesFinder moves = new MaxMovesFinder(oscypkiSets[i]);
            results[i] = moves.getMaxSumOfDeliciousnessForAlicja();
        }

        Arrays.stream(results).forEach(System.out::println);

        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime-startTime) + "ms.");
    }
}

package Default;

import java.io.*;
import java.util.Arrays;

public class Loader {

    public static int[][] loadOscypki(File file) throws IOException {
        BufferedReader reader = openReader(file);

        int numberOfSets = Integer.parseInt(reader.readLine());
        int[][] oscypkiSets = new int[numberOfSets][];
        for (int numberOfSet = 0; numberOfSet < numberOfSets ; numberOfSet++) {
            int numberOfOscypkiInSet = Integer.parseInt(reader.readLine());
            oscypkiSets[numberOfSet] = new int[numberOfOscypkiInSet];
            oscypkiSets[numberOfSet] = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        reader.close();
        return oscypkiSets;
    }

    private static BufferedReader openReader(File file) throws FileNotFoundException {
        BufferedReader reader;
        if (file == null)
            reader = new BufferedReader(new InputStreamReader(System.in));
        else
            reader = new BufferedReader(new FileReader(file));
        return reader;
    }
}

package Default;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Loader {
    public static int[] load(File file) throws IOException {
        BufferedReader reader = openReader(file);

        int nOfPaintings = Integer.parseInt(reader.readLine());
        int[] paintings = new int[nOfPaintings];

        List<String> words = Arrays.stream(reader.readLine().split("\\s+")).toList();
        for (int i = 0; i < nOfPaintings; i++)
            paintings[i] = Integer.parseInt(words.get(i));

        reader.close();
        return paintings;
    }

    private static BufferedReader openReader(File file) throws FileNotFoundException {
        if (file != null && file.canRead())
            return new BufferedReader(new FileReader(file));
        return new BufferedReader(new InputStreamReader(System.in));
    }
}

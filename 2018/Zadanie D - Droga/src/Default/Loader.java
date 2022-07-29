package Default;

import java.io.*;
import java.util.*;

public class Loader {

    public static Data load(File inputFile) throws IOException {
        BufferedReader reader = openReader(inputFile);
        int[] firstLine = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int nOfSections = firstLine[0];
        int nOfEvents = firstLine[1];

        ArrayList<MyEvent> events = new ArrayList<>();
        for (int i = 0; i < nOfEvents; i++) {
            events.add(loadEvent(reader));
        }
        return new Data(nOfSections, events);
    }

    private static BufferedReader openReader(File inputFile) {
        if (inputFile != null) {
            if (inputFile.canRead()) {
                try {
                    return new BufferedReader(new FileReader(inputFile));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else
                throw new RuntimeException("Can't read file");
        }
        return new BufferedReader(new InputStreamReader((System.in)));
    }

    private static MyEvent loadEvent(BufferedReader reader) throws IOException {
        List<String> list = Arrays.stream(reader.readLine().split("\\s+")).toList();
        int second = Integer.parseInt(list.get(0));
        char type = list.get(1).charAt(0);
        Integer[] params = list.subList(2, list.size()).stream().map(Integer::parseInt).toArray(Integer[]::new);
        return new MyEvent(second, type, params);
    }
}

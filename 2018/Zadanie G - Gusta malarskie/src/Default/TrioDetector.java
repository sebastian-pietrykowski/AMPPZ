package Default;

import java.util.ArrayList;
import java.util.Arrays;

public class TrioDetector {

    public static ArrayList<Integer> getTrioDividers(int[] paintings) {
        ArrayList<Integer> trioDividers = new ArrayList<>();
        Arrays.sort(paintings);

        for (int i = 0; i < paintings.length-2; i++) {
            for (int j = i+1; j < paintings.length-1; j++)
                if (paintings[j] == paintings[i]*2) {
                    for (int k = j+1; k < paintings.length; k++)
                        if (paintings[k] == paintings[i]*3) {
                            trioDividers.add(paintings[i]);
                            break;
                        }
                    break;
                }
        }
        return trioDividers;
    }
}

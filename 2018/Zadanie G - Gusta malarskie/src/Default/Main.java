package Default;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int[] paintings;
        try {
            paintings = Loader.load(new File("2018/Zadanie G - Gusta malarskie/src/input3.txt"));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Integer> dividers = TrioDetector.getTrioDividers(paintings);
        DisputedPaintings disputedPaintings = new DisputedPaintings();
        for (int divider: dividers)
            disputedPaintings.addTrio(divider);

        disputedPaintings.removeDisputedPaintings();

        int nOfPaintingsToShow = paintings.length - disputedPaintings.getNOfRemovedPaintings();
        System.out.println(nOfPaintingsToShow);
    }
}

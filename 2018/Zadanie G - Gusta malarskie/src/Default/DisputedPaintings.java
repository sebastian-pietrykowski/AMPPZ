package Default;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DisputedPaintings {
    private final Map<Integer, ArrayList<Integer>> disputedPaintings = new TreeMap<>(); // nOfSquares -> dividers
    private int nOfRemovedPaintings = 0;

    public void addTrio(int startNumber) {
        if (!disputedPaintings.containsKey(startNumber))
            disputedPaintings.put(startNumber, new ArrayList<>());
        disputedPaintings.get(startNumber).add(startNumber);

        if (!disputedPaintings.containsKey(2*startNumber))
            disputedPaintings.put(2*startNumber, new ArrayList<>());
        disputedPaintings.get(2*startNumber).add(startNumber);

        if (!disputedPaintings.containsKey(3*startNumber))
            disputedPaintings.put(3*startNumber, new ArrayList<>());
        disputedPaintings.get(3*startNumber).add(startNumber);
    }

    public void removeDisputedPaintings() {
        while (disputedPaintings.size() > 0) {
            nOfRemovedPaintings++;
            ArrayList<Integer> dividersToRemove = new ArrayList<>(disputedPaintings.get(getPaintingWithMaxDividers()));
            for (int divider : dividersToRemove)
                safeRemove(divider);
        }
    }

    private int getPaintingWithMaxDividers() {
        int maxDividers = 0;
        int nOfSquares = 0;
        for (var entry: disputedPaintings.entrySet())
            if (entry.getValue().size() > maxDividers) {
                maxDividers = entry.getValue().size();
                nOfSquares = entry.getKey();
            }
        return nOfSquares;
    }

    private void safeRemove(int divider) {
        if (disputedPaintings.get(divider).size() == 1)
            disputedPaintings.remove(divider);
        else
            disputedPaintings.get(divider).remove((Object)divider);

        if (disputedPaintings.get(2*divider).size() == 1)
            disputedPaintings.remove(2*divider);
        else
            disputedPaintings.get(2*divider).remove((Object)divider);

        if (disputedPaintings.get(3*divider).size() == 1)
            disputedPaintings.remove(3*divider);
        else
            disputedPaintings.get(3*divider).remove((Object)divider);
    }

    public int getNOfRemovedPaintings() { return nOfRemovedPaintings; }
}

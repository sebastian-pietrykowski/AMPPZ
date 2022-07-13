package Default;

import java.util.*;
import java.util.stream.IntStream;

public class Algorithm {

    private int[] oscypkiDeliciousness;
    private int sumOfDeliciousnessForAlicja, sumOfDeliciousnessForBob = 0;
    private Map<Integer, ArrayList<boolean[]>> possibleMovesAtLength = new TreeMap<>();

    public Algorithm(int[] oscypkiDeliciousness) {
        this.oscypkiDeliciousness = oscypkiDeliciousness;
    }

    public int findMaxSumOfDeliciousnessForAlicja() {

        int indexOfMaxValueAtEvenPosition = IntStream.range(0, oscypkiDeliciousness.length).filter(i -> i%2 == 0).boxed().max(Comparator.comparing(i -> oscypkiDeliciousness[i])).get();
        int indexOfMaxValueAtOddPosition = IntStream.range(0, oscypkiDeliciousness.length).filter(i -> i%2 == 1).boxed().max(Comparator.comparing(i -> oscypkiDeliciousness[i])).get();

        int maxSumForAlicjaStartingAtEvenPosition = findMaxSumStartingAt(indexOfMaxValueAtEvenPosition);
        int maxSumForAlicjaStartingAtOddPosition = findMaxSumStartingAt(indexOfMaxValueAtOddPosition);

        return Integer.max(maxSumForAlicjaStartingAtEvenPosition, maxSumForAlicjaStartingAtOddPosition);
    }

    private int findMaxSumStartingAt(int startIndex) {
        boolean[] visitedOscypki = new boolean[oscypkiDeliciousness.length];
        visitedOscypki[startIndex] = true;

        ArrayList<Hole> holes = findHoles(visitedOscypki, 0, oscypkiDeliciousness.length-1);
        for (Hole hole: holes)
            hole.print();

        return -1;
    }

    private ArrayList<Hole> findHoles(boolean[] visitedOscypki, int startIndex, int endIndex) {
        ArrayList<Hole> holes = new ArrayList<>();
        int numberOfCurrentHole = 0;
        for (int index = startIndex; index < endIndex+1; index++)
            if (!visitedOscypki[index]) {
                Hole currentHole;
                if (numberOfCurrentHole == holes.size()) {
                    currentHole = new Hole(index);
                    holes.add(currentHole);
                }
                else
                    currentHole = holes.get(numberOfCurrentHole);
                currentHole.endIndex = index;
            }
            else if (holes.size() > numberOfCurrentHole)
                numberOfCurrentHole++;
        return holes;
    }



    private class Hole {
        int startIndex = -1;
        int endIndex = -1;

        Hole(int startIndex) {
            this.startIndex = startIndex;
        }
        void print() {
            System.out.println("Hole: start=" + startIndex + ", end=" + endIndex);
        }
    }
}

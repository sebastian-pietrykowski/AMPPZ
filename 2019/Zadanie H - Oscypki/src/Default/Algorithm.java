package Default;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Algorithm {

    private int[] oscypkiDeliciousness;
    private int sumOfDeliciousnessForAlicja, sumOfDeliciousnessForBob = 0;

    public Algorithm(int[] oscypkiDeliciousness) {
        this.oscypkiDeliciousness = oscypkiDeliciousness;
    }

    public int findMaxSumOfDeliciousnessForAlicja() {

        int indexOfMaxValueAtEvenPostion = IntStream.range(0, oscypkiDeliciousness.length).filter(i -> i%2 == 0).boxed().max(Comparator.comparing(i -> oscypkiDeliciousness[i])).get();
        int indexOfMaxValueAtOddPostion = IntStream.range(0, oscypkiDeliciousness.length).filter(i -> i%2 == 1).boxed().max(Comparator.comparing(i -> oscypkiDeliciousness[i])).get();

        int maxSumForAlicjaStartingAtEvenPositon = findMaxSumStartingAt(indexOfMaxValueAtEvenPostion);
        int maxSumForAlicjaStartingAtOddPositon = findMaxSumStartingAt(indexOfMaxValueAtOddPostion);

        return Integer.max(maxSumForAlicjaStartingAtEvenPositon, maxSumForAlicjaStartingAtOddPositon);
    }

    private int findMaxSumStartingAt(int startIndex) {
        boolean[] visitedOscypki = new boolean[oscypkiDeliciousness.length];
        visitedOscypki[startIndex] = true;
        System.out.println(Arrays.toString(visitedOscypki));
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

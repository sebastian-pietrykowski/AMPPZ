package Default;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxMovesFinder {

    private final int[] oscypkiDeliciousness;
    private byte[] whoTookWhichOscypki;
    private int maxSumOfDeliciousnessForAlicja = 0;

    public MaxMovesFinder(int[] oscypkiDeliciousness) {
        this.oscypkiDeliciousness = oscypkiDeliciousness;
        whoTookWhichOscypki = new byte[oscypkiDeliciousness.length]; // 0 - nobody, 1 - Alicja, 2 - Bob
        Arrays.fill(whoTookWhichOscypki, WhoTook.NOBODY);

        findMaxSumOfDeliciousnessForAlicja();
    }

    private void findMaxSumOfDeliciousnessForAlicja() {

        // Alicja's turn - 1st
        ArrayList<ArrayList<Integer>> possibleMovesCombination = new MovesCombination().determinePossibleMoves(oscypkiDeliciousness.length);
        for (ArrayList<Integer> possibleMovesOption: possibleMovesCombination) {

            byte[] whoTookWhichOscypkiTmp = new byte[oscypkiDeliciousness.length];
            Arrays.fill(whoTookWhichOscypkiTmp, WhoTook.NOBODY);

            for (Integer tookOscypekIndex: possibleMovesOption)
                whoTookWhichOscypkiTmp[tookOscypekIndex] = WhoTook.ALICJA;

            // Bob's turn - 2nd
            ArrayList<Hole> holes = findHoles(whoTookWhichOscypkiTmp);
            for (Hole hole: holes) {
                if (hole.startIndex != hole.endIndex) {
                    int startDeliciousness = oscypkiDeliciousness[hole.startIndex];
                    int endDeliciousness = oscypkiDeliciousness[hole.endIndex];
                    int leftIndex;
                    if (startDeliciousness > endDeliciousness)
                        leftIndex = hole.endIndex;
                    else
                        leftIndex = hole.startIndex;
                    // Alicja's turn - 3rd
                    whoTookWhichOscypkiTmp[leftIndex] = WhoTook.ALICJA;
                }
            }
            int sumOfDeliciousnessForAlicja = getSumOfDeliciousnessForAlicja(whoTookWhichOscypkiTmp);
            if (sumOfDeliciousnessForAlicja > maxSumOfDeliciousnessForAlicja) {
                maxSumOfDeliciousnessForAlicja = sumOfDeliciousnessForAlicja;
                whoTookWhichOscypki = whoTookWhichOscypkiTmp;
            }
        }
    }

    public String getWhoTookWhichOscypki() {
        return Arrays.toString(whoTookWhichOscypki);
    }

    public int getMaxSumOfDeliciousnessForAlicja() {
        return maxSumOfDeliciousnessForAlicja;
    }

    private ArrayList<Hole> findHoles(byte[] whoTookOscypki) {
        ArrayList<Hole> holes = new ArrayList<>();
        int numberOfCurrentHole = 0;
        for (int index = 0; index < whoTookOscypki.length; index++)
            if (whoTookOscypki[index] == WhoTook.NOBODY) {
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

    private int getSumOfDeliciousnessForAlicja(byte[] whoTookWhichOscypki) {
        int sum = 0;
        for (int index = 0; index < oscypkiDeliciousness.length; index++)
            if (whoTookWhichOscypki[index] == WhoTook.ALICJA)
                sum += oscypkiDeliciousness[index];
        return sum;
    }

    private static class Hole {
        int startIndex;
        int endIndex;

        Hole(int startIndex) {
            this.startIndex = startIndex;
        }
    }

    private static class WhoTook {
        final static byte NOBODY = 0;
        final static byte ALICJA = 1;
        final static byte BOB = 2;
    }
}

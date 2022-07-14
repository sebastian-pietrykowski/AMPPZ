package Default;

import java.util.ArrayList;
import java.util.Arrays;

public class Algorithm {

    private final int[] oscypkiDeliciousness;

    public Algorithm(int[] oscypkiDeliciousness) {
        this.oscypkiDeliciousness = oscypkiDeliciousness;
    }

    public int findMaxSumOfDeliciousnessForAlicja() {
        byte[] whoTookOscypkiFinal = new byte[oscypkiDeliciousness.length]; // 0 - nobody, 1 - Alicja, 2 - Bob
        Arrays.fill(whoTookOscypkiFinal, (byte) 0);
        int maxSumOfDeliciousnessForAlicja = 0;

        // Alicja's turn - 1st
        ArrayList<ArrayList<Integer>> possibleMovesCombination = new MovesCombination().determinePossibleMoves(oscypkiDeliciousness.length);
        for (ArrayList<Integer> possibleMovesOption: possibleMovesCombination) {
            byte[] whoTookOscypkiTmp = new byte[oscypkiDeliciousness.length];
            Arrays.fill(whoTookOscypkiTmp, (byte) 0);

            for (Integer tookOscypekIndex : possibleMovesOption)
                whoTookOscypkiTmp[tookOscypekIndex] = 1;

            // Bob's turn - 2nd
            ArrayList<Hole> holes = findHoles(whoTookOscypkiTmp);
            for (Hole hole: holes) {
                if (hole.startIndex == hole.endIndex) {
                    whoTookOscypkiTmp[hole.startIndex] = 2;
                }
                else {
                    int startDeliciousness = oscypkiDeliciousness[hole.startIndex];
                    int endDeliciousness = oscypkiDeliciousness[hole.endIndex];
                    int tookIndex, leftIndex;
                    if (startDeliciousness > endDeliciousness) {
                        tookIndex = hole.startIndex;
                        leftIndex = hole.endIndex;
                    }
                    else {
                        tookIndex = hole.endIndex;
                        leftIndex = hole.startIndex;
                    }
                    whoTookOscypkiTmp[tookIndex] = 2;
                    // Alicja's turn - 3rd
                    whoTookOscypkiTmp[leftIndex] = 1;
                }
            }
            int sumOfDeliciousnessForAlicja = getSumOfDeliciousnessForAlicja(whoTookOscypkiTmp);
            if (sumOfDeliciousnessForAlicja > maxSumOfDeliciousnessForAlicja) {
                maxSumOfDeliciousnessForAlicja = sumOfDeliciousnessForAlicja;
                whoTookOscypkiFinal = whoTookOscypkiTmp;
            }
        }
        return maxSumOfDeliciousnessForAlicja;
    }

    private ArrayList<Hole> findHoles(byte[] whoTookOscypki) {
        ArrayList<Hole> holes = new ArrayList<>();
        int numberOfCurrentHole = 0;
        for (int index = 0; index < whoTookOscypki.length; index++)
            if (whoTookOscypki[index] == 0) {
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

    private int getSumOfDeliciousnessForAlicja(byte[] whoTookOscypki) {
        int sum = 0;
        for (int index = 0; index < oscypkiDeliciousness.length; index++)
            if (whoTookOscypki[index] == 1)
                sum += oscypkiDeliciousness[index];
        return sum;
    }

    private class Hole {
        int startIndex;
        int endIndex;

        Hole(int startIndex) {
            this.startIndex = startIndex;
        }
    }
}

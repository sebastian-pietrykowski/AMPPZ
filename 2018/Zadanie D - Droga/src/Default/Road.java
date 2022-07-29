package Default;

import java.util.Arrays;

public class Road {

    int nOfSections;
    int[] heightOfSnow;

    int[] saltMinutesLeft;

    int currentWhiteoutMinutesCounter;
    int currentWhiteoutF;
    int currentWhiteoutG;

    public Road(int nOfSections) {
        this.nOfSections = nOfSections;

        heightOfSnow = new int[nOfSections];
        Arrays.fill(heightOfSnow, 0);

        saltMinutesLeft = new int[nOfSections];
        Arrays.fill(saltMinutesLeft, 0);
    }

    public void addSnow() {
        currentWhiteoutMinutesCounter++;
        int newSnow = currentWhiteoutF * currentWhiteoutMinutesCounter + currentWhiteoutG;
        for (int i = 0; i < heightOfSnow.length; i++)
            if (saltMinutesLeft[i] == 0)
                heightOfSnow[i] += newSnow;
            else
                saltMinutesLeft[i]--;
    }

    public void applySnowRemoving() {
        Arrays.fill(heightOfSnow, 0);
    }

    public void applySalting(int start, int end, int value) {
        for (int i = start; i < end+1; i++) {
            saltMinutesLeft[i] += value;
            heightOfSnow[i] = 0;
        }
    }

    public void applyQuery(int start, int end) {
        int max =  Arrays.stream(heightOfSnow, start, end + 1).max().orElse(-1);
        int result = max % ((int)Math.pow(10,9) + 7);
        System.out.println(result);
    }

    public void applyWhiteout(int f, int g) {
        currentWhiteoutMinutesCounter = 0;
        currentWhiteoutF = f;
        currentWhiteoutG = g;
    }

    public String toString() {
        return "nOfSections: " + nOfSections +
                ", heightOfSnow: " + Arrays.toString(heightOfSnow) +
                ", saltMinutesLeft: " + Arrays.toString(saltMinutesLeft) +
                ", currentWhiteoutMinutesCounter: " + currentWhiteoutMinutesCounter +
                ", currentWhiteoutF: " + currentWhiteoutF +
                ", currentWhiteoutG: " + currentWhiteoutG;
    }
}

package Default;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MovesCombination {

    private ArrayList<ArrayList<Integer>> possibleMovesCombination;

    private void combinationUtil(ArrayList<Integer> data, int index, int value, int maxValue) {
        if (value == maxValue || value == maxValue-1) {
            data.add(index, value);
            possibleMovesCombination.add((ArrayList<Integer>) data.clone());
            data.remove(index);
            return;
        }
        else if (value > maxValue)
            return;

        data.add(index, value);
        combinationUtil(data, index+1, value+2, maxValue);
        combinationUtil(data, index+1, value+3, maxValue);
        data.remove(index);
    }

    public ArrayList<ArrayList<Integer>> determinePossibleMoves(int searchLength) {
        possibleMovesCombination = new ArrayList<>();

        int maxNumberOfMoves = (searchLength+1)/2;
        ArrayList<Integer> data = new ArrayList<>(maxNumberOfMoves); // temporary array to store current combination
        combinationUtil(data, 0, 0, searchLength-1);
        combinationUtil(data, 0, 1, searchLength-1);

        return possibleMovesCombination;
    }
}

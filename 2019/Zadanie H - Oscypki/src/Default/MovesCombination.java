package Default;

import java.util.ArrayList;

public class MovesCombination {
    private final ArrayList<ArrayList<Integer>> possibleMovesCombination = new ArrayList<>();

    private void combinationUtil(ArrayList<Integer> data, int index, int value, int maxValue) {
        if (value == maxValue || value == maxValue-1) {
            data.add(index, value);
            ArrayList<Integer> dataClone = new ArrayList<>(data);
            possibleMovesCombination.add(dataClone);
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

        int maxNumberOfMoves = (searchLength+1)/2;
        ArrayList<Integer> data = new ArrayList<>(maxNumberOfMoves); // temporary array to store current combination
        combinationUtil(data, 0, 0, searchLength-1);
        combinationUtil(data, 0, 1, searchLength-1);

        return possibleMovesCombination;
    }
}

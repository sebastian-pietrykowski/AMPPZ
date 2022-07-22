package Default;

import java.util.ArrayList;

public class FibonacciContainer {

    private ArrayList<Long> sequence;

    public ArrayList<Long> getFibonacciSequenceToMaxNumber(long maxNumber) {

        if (sequence == null) {
            sequence = new ArrayList<>();
            adjustSequence(maxNumber);
        }
        if (sequence.get(sequence.size()-1) < maxNumber)
            adjustSequence(maxNumber);
        return sequence;
    }

    private void adjustSequence(long maxNumber) {
        if (sequence.size() == 0) {
            sequence.add(1L);
            sequence.add(2L);
        }
        long lastElement = sequence.get(sequence.size()-1);
        while (lastElement < maxNumber) {
            long penultimateElement = sequence.get(sequence.size()-2);
            sequence.add(penultimateElement + lastElement);
            lastElement = sequence.get(sequence.size()-1);
        }
    }

    public static long getFibonacciSequenceElement(long number) {

        if (number == 1)
            return 1;
        if (number == 2)
            return 2;
        if (number < 1)
            return -1;

        long element1 = 1;
        long element2 = 2;
        number -= 2;

        while (number-- > 0) {
            long nextElement = element1 + element2;
            if (nextElement >= PriceFinder.PRICE_LIMIT)
                return -1;
            element1 = element2;
            element2 = nextElement;
        }
        return element2;
    }
}

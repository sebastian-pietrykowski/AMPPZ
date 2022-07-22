package Default;

import java.util.ArrayList;

public class NumberValidator {

    private final Data data;
    private final FibonacciContainer fibonacciContainer = new FibonacciContainer();
    private ArrayList<Long> fibonacciSequence;
    public NumberValidator(Data data) {
        this.data = data;
    }

    public boolean validate(long number) {

        fibonacciSequence = fibonacciContainer.getFibonacciSequenceToMaxNumber(number);

        if (number < 1)
            return false;

        boolean tmp = findIfPriceCanBeDividedByMinNCoupons(number);
        //System.out.println("num: " + number + ", bool: " + tmp);
        return tmp && data.numberOfCoupons <= number; // 2 - only ones
    }

    private boolean findIfPriceCanBeDividedByMinNCoupons(long value) {
        short minNumberOfCoupons = 0;
        int lastIndex = fibonacciSequence.size()-1;

        while (minNumberOfCoupons++ < data.numberOfCoupons) {
            lastIndex = findFibonacciIndexOfValueEqualToOrSmallerThan(value, lastIndex);
            if (lastIndex == -1)
                return false;
            value -= fibonacciSequence.get(lastIndex);
            if (value == 0)
                return true;
        }
        return value == 0;
    }

    private int findFibonacciIndexOfValueEqualToOrSmallerThan(long value, int lastIndex) {
        for (int i = lastIndex; i > -1; i--)
            if (fibonacciSequence.get(i) <= value)
                return i;
        return -1;
    }
}

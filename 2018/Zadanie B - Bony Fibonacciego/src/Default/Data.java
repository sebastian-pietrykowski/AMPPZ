package Default;

public class Data {
    public final byte numberOfCoupons;
    public final long priceNumberToBeFound;

    public Data(byte numberOfCoupons, long priceNumberToBeFound) {
        this.numberOfCoupons = numberOfCoupons;
        this.priceNumberToBeFound = priceNumberToBeFound;
    }

    @Override
    public String toString() {
        return "[numberOfCoupons: " + numberOfCoupons + ", priceNumberToBeFound: " +
                priceNumberToBeFound + "]";
    }
}

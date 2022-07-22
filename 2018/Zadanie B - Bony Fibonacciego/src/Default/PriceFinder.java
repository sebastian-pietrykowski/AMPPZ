package Default;

public class PriceFinder {
    private final Data data;
    private final NumberValidator validator;

    public static final double PRICE_LIMIT = Math.pow(10, 18);

    public PriceFinder(Data data) {
        this.data = data;
        validator = new NumberValidator(data);
    }

    public String findPrice() {
        return data.numberOfCoupons == 1 ? findPriceOneCoupon() : findPriceManyCoupons();
    }

    private String findPriceManyCoupons() {
        long counter = 0;
        long currentPrice = data.numberOfCoupons;

        while (counter < data.priceNumberToBeFound) {
            //System.out.println(currentPrice);
            if (validator.validate(currentPrice++)){
                //System.out.println("c" + (currentPrice-1));
                counter++;}
            if (currentPrice == PRICE_LIMIT)
                return "NIE";
        }
        return "" + (currentPrice-1);
    }

    private String findPriceOneCoupon() {

       long price = FibonacciContainer.getFibonacciSequenceElement(data.priceNumberToBeFound);
        if (price == -1)
            return "NIE";

        return "" + price;
    }
}

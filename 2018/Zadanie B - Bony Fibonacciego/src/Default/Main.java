package Default;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Data data;
        try {
            data = new Loader().load();
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }

        long startTime = System.currentTimeMillis();

        String foundPrice = new PriceFinder(data).findPrice();
        System.out.println(foundPrice);

        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime-startTime) + " ms.");
    }
}

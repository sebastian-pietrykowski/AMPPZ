package Default;

import java.io.*;

public class Loader {

    private final File file;

    public Loader() {
        file = null;
    }
    public Loader(File file) throws FileNotFoundException {
        this.file = file;
        if (!file.canRead())
            throw new FileNotFoundException();
    }

    private BufferedReader openReader() {
        if (file != null) {
            try {
                return new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public Data load() throws IOException, NumberFormatException {
        BufferedReader reader = openReader();
        String[] line = reader.readLine().split("\\s+");

        byte numberOfCoupons;
        long priceNumberToBeFound;
        try {
            numberOfCoupons = Byte.parseByte(line[0]);
            priceNumberToBeFound = Long.parseLong(line[1]);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        if ((numberOfCoupons < 1 || numberOfCoupons > 100) ||
                (priceNumberToBeFound < 1 || priceNumberToBeFound > Math.pow(10,18)))
            throw new NumberFormatException();

        reader.close();
        return new Data(numberOfCoupons, priceNumberToBeFound);
    }
}

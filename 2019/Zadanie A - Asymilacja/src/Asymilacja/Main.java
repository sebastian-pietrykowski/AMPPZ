package Asymilacja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        Loader loader = null;
        try {
            loader = new Loader(new File("src/Asymilacja/data.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        ArrayList<SetDataContainer> sets = loader.load();
        //sets.forEach( s -> s.printState());
        long start = System.currentTimeMillis();
        for( SetDataContainer set: sets) {
            new Attacks(set).attack();
            System.out.println(set.getNumberOfMobilizations());
        }
        long end = System.currentTimeMillis();
        System.out.println("Algorithm took " + (end-start) + " ms");
    }
}

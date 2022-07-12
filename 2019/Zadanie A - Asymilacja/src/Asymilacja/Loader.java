package Asymilacja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader {

    private Scanner scanner;
    private ArrayList<SetDataContainer> sets;

    public Loader(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
    }

    public ArrayList<SetDataContainer> load() {
        int numberOfSets = getNumberOfSets();
        sets = new ArrayList<>(numberOfSets);
        for(int index = 0; index < numberOfSets; index++)
            sets.add(loadSet());
        return sets;
    }

    private int getNumberOfSets() {
        return Integer.parseInt(scanner.nextLine());
    }

    private SetDataContainer loadSet() {
        String[] wordsInLine1 = scanner.nextLine().split("\\s+");
        if( wordsInLine1.length != 2)
            throw new IllegalArgumentException("Too many numbers in line");
        int numberOfPlanets = Integer.parseInt(wordsInLine1[0]);
        int sizeOfArmy = Integer.parseInt(wordsInLine1[1]);

        ArrayList<Integer> numberOfInhabitantsOnPlanets = new ArrayList<>(numberOfPlanets);
        String[] wordsInLine2 = scanner.nextLine().split("\\s+");
        for(String word: wordsInLine2) {
            int numberOfInhabitantsOnPlanet = Integer.parseInt(word);
            numberOfInhabitantsOnPlanets.add(numberOfInhabitantsOnPlanet);
        }
        return new SetDataContainer(numberOfInhabitantsOnPlanets, sizeOfArmy);
    }
}

package Asymilacja;

import java.util.ArrayList;
import java.util.Collections;

public class Finder {

    public static int findIndexOfStrongestPlanetToAttack(SetDataContainer data) {
        ArrayList<Integer> numberOfInhabitantsOnPlanets = data.getNumberOfInhabitantsOnPlanetsToAttack();
        int sizeOfArmy = data.getSizeOfArmy();
        Collections.sort(numberOfInhabitantsOnPlanets);
        int approximatedIndex = BinarySearch.search(numberOfInhabitantsOnPlanets, sizeOfArmy);
        while( approximatedIndex > -1 && numberOfInhabitantsOnPlanets.get(approximatedIndex) > sizeOfArmy)
            approximatedIndex--;
        return approximatedIndex;
    }
}

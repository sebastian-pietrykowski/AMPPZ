package Asymilacja;

import java.util.ArrayList;

public class Attacks {

    SetDataContainer data;

    public Attacks(SetDataContainer data) {
        this.data = data;
    }

    public void attack() {
        while(true) {
            int indexOfStrongestPlanetToAttack = Finder.findIndexOfStrongestPlanetToAttack(data);

            // attack
            if(indexOfStrongestPlanetToAttack != -1) {
                if(isPlanetToAttackStrongestOfAllAndDoesntRepeat(indexOfStrongestPlanetToAttack)) {
                    attackPlanet(indexOfStrongestPlanetToAttack);
                    attackRemainingPlanets();
                }
                else
                    attackPlanet(indexOfStrongestPlanetToAttack);
            }
            // don't attack
            else if(data.getNumberOfPlanetsToMobilize() == 0 && data.getNumberOfPlanetsToAttack() >= 0) {
                data.setNumberOfMobilizations(-1);
                break;
            }
            else if(data.getNumberOfPlanetsToAttack() == 0)
                break;
            else
                mobilizeStrongestPlanet();
        }
    }

    private void attackRemainingPlanets() {
        for( int indexOfPlanet = 0; indexOfPlanet < data.getNumberOfInhabitantsOnPlanetsToAttack().size(); indexOfPlanet++) {
            int numberOfInhabitantsOnPlanet = data.getNumberOfInhabitantsOnPlanetsToAttack().get(indexOfPlanet);
            if( numberOfInhabitantsOnPlanet <= data.getSizeOfArmy())
                attackPlanet(indexOfPlanet);
        }
    }

    private void attackPlanet(int indexOfPlanetToAttack) {
        int numberOfInhabitantsOnPlanet = data.getNumberOfInhabitantsOnPlanetsToAttack().get(indexOfPlanetToAttack);;
        int sizeOfArmy = data.getSizeOfArmy() - numberOfInhabitantsOnPlanet;
        data.setSizeOfArmy(sizeOfArmy);
        data.getNumberOfInhabitantsOnPlanetsToAttack().remove(indexOfPlanetToAttack);
        data.addConqueredPlanet(numberOfInhabitantsOnPlanet*2);
    }

    private void mobilizeStrongestPlanet() {
        int sizeOfArmy = data.getSizeOfArmy() + data.getNumberOfCitizensOnStrongestPlanetToMobilize();
        data.setSizeOfArmy(sizeOfArmy);
        data.increaseNumberOfMobilizations();
    }

    private boolean isPlanetToAttackStrongestOfAllAndDoesntRepeat(int indexOfPlanetToAttack) {
        ArrayList<Integer> numberOfInhabitantsOnPlanetsToAttack = data.getNumberOfInhabitantsOnPlanetsToAttack();
        int numberOfInhabitantsOfPlanetToAttack = numberOfInhabitantsOnPlanetsToAttack.get(indexOfPlanetToAttack);
        int length = numberOfInhabitantsOnPlanetsToAttack.size();

        if(length == 1)
            return true;

        int valueOfLastElement = numberOfInhabitantsOnPlanetsToAttack.get(length-1);
        int valueOfNextToLastElement = numberOfInhabitantsOnPlanetsToAttack.get(length-2);
        return numberOfInhabitantsOfPlanetToAttack == valueOfLastElement
                && numberOfInhabitantsOfPlanetToAttack != valueOfNextToLastElement;
    }
}

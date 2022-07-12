package Asymilacja;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SetDataContainer {

    private int numberOfMobilizations = 0;
    private int sizeOfArmy;
    private ArrayList<Integer> numberOfInhabitantsOnPlanetsToAttack;
    private PriorityQueue<Integer> numberOfInhabitantsOnPlanetsToMobilize;

    public SetDataContainer(ArrayList<Integer> numberOfInhabitantsOnPlanetsToAttack, int sizeOfArmy) {
        this.numberOfInhabitantsOnPlanetsToAttack = numberOfInhabitantsOnPlanetsToAttack;
        this.sizeOfArmy = sizeOfArmy;
        createPriorityQueue();
    }

    private void createPriorityQueue() {
        numberOfInhabitantsOnPlanetsToMobilize = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public ArrayList<Integer> getNumberOfInhabitantsOnPlanetsToAttack() {
        return numberOfInhabitantsOnPlanetsToAttack;
    }

    public int getNumberOfPlanetsToAttack() {
        return numberOfInhabitantsOnPlanetsToAttack.size();
    }

    public int getNumberOfMobilizations() {
        return numberOfMobilizations;
    }

    public void increaseNumberOfMobilizations() { numberOfMobilizations++; }

    public void setNumberOfMobilizations(int numberOfMobilizations) {
        this.numberOfMobilizations = numberOfMobilizations;
    }

    public int getSizeOfArmy() { return  sizeOfArmy; }

    public void setSizeOfArmy(int sizeOfArmy) { this.sizeOfArmy = sizeOfArmy; }

    public void addConqueredPlanet(int numberOfInhabitants) {
        numberOfInhabitantsOnPlanetsToMobilize.add(numberOfInhabitants);
    }

    public int getNumberOfCitizensOnStrongestPlanetToMobilize() {
        return numberOfInhabitantsOnPlanetsToMobilize.poll();
    }

    public int getNumberOfPlanetsToMobilize() {
        return numberOfInhabitantsOnPlanetsToMobilize.size();
    }
    public boolean didConquerAllPlanets() {
        return numberOfInhabitantsOnPlanetsToAttack.size() == 0;
    }

    public void printState() {
        System.out.println("number of mobilizations: " + numberOfMobilizations);
        System.out.println("size of army: " + sizeOfArmy);
        System.out.println("number of inhabitants on planets to attack: " + numberOfInhabitantsOnPlanetsToAttack.toString());
        System.out.println("number of inhabitants on planets to mobilize: " + numberOfInhabitantsOnPlanetsToMobilize.toString());
        System.out.println("------------------------------------");
    }
}

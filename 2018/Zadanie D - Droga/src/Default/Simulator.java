package Default;

public class Simulator {
    Road road;
    Data data;
    int minutesCounter = 0;
    int happenedEvents = 0;

    public Simulator(Road road, Data data) {
        this.road = road;
        this.data = data;
    }

    private void simulateNextMinute() {
        minutesCounter++;
        road.addSnow();
        if (data.events.get(happenedEvents).second == minutesCounter) {
            data.events.get(happenedEvents).applyEvent(road);
            happenedEvents++;
        }
//        System.out.println("second: " + minutesCounter + ", " + road.toString());
    }

    public void simulate() {
//        System.out.println(road.toString());
        while (minutesCounter != data.events.get(data.events.size()-1).second)
            simulateNextMinute();
    }
}

package Default;

import java.util.ArrayList;

public class Data {
    int nOfSections;
    ArrayList<MyEvent> events;

    public Data(int nOfSections, ArrayList<MyEvent> events) {
        this.nOfSections = nOfSections;
        this.events = events;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nOfSections: ").append(nOfSections).append("\n");
        for (MyEvent event : events) sb.append(event).append("\n");
        return sb.toString();
    }
}

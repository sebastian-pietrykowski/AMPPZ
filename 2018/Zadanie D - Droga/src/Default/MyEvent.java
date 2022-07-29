package Default;

import java.util.Arrays;

public class MyEvent {
    int second;
    char type;
    Integer[] params;

    MyEvent(int second, char type, Integer[] params) {
        this.second = second;
        this.type = type;
        this.params = params;
    }

    public String toString() {
        return "[second: " + second +
                ", type: " + type +
                ", params: " + Arrays.toString(params) +
                "]";
    }

    public void applyEvent(Road road) {
        switch (type) {
            case 'L' -> road.applySnowRemoving();
            case 'S' -> road.applySalting(params[0]-1, params[1]-1, params[2]);
            case '?' -> road.applyQuery(params[0]-1, params[1]-1);
            case 'B' -> road.applyWhiteout(params[0], params[1]);
        }
    }




}

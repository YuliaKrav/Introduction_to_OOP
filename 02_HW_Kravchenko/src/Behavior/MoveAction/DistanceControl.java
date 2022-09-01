package Behavior.MoveAction;

public abstract class DistanceControl {
    private int distance;
    private final int callingSteptoPerson;

    public DistanceControl(int distance, int callingSteptoPerson) {
        this.distance = distance;
        this.callingSteptoPerson = callingSteptoPerson;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCallingSteptoPerson() {
        return callingSteptoPerson;
    }

    public void oneStep(int times) {
        distance = distance - callingSteptoPerson * times < 0 ? 0 : distance - callingSteptoPerson * times;
    }
}

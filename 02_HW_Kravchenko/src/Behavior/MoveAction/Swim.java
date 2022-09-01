package Behavior.MoveAction;

public class Swim extends DistanceControl implements MoveBehavior {
    public Swim(int distance, int callingSteptoPerson) {
        super(distance, callingSteptoPerson);
    }

    @Override
    public void move() {
        System.out.println("An animal swims.");
    }

    @Override
    public void move(String type, String name, int times) {
        System.out.print("The distance equals " + getDistance() + " m. ");
        oneStep(times);
        String movement = "The animal-" + type + " " + name + " swims around the tank. The distance is the same.";
        String near = "The animal-" + type + " " + name + " is near its owner. The distance equals 0 m.";
        System.out.println(getDistance() == 0 ? near : movement);
    }
}

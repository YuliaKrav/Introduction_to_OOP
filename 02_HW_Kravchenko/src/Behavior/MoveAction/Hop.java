package Behavior.MoveAction;

public class Hop extends DistanceControl implements MoveBehavior {

    public Hop(int distance, int callingSteptoPerson) {
        super(distance, callingSteptoPerson);
    }

    @Override
    public void move() {
        System.out.println("An animal hops.");
    }

    @Override
    public void move(String type, String name, int times) {
        System.out.print("The distance equals " + getDistance() + " m. ");
        oneStep(times);
        String movement = "The animal-" + type + " " + name + " hops from its owner. The distance increased by "
                + Math.abs(getCallingSteptoPerson()) * times + " m. and became " + getDistance() + " m.";
        String near = "The animal-" + type + " " + name + " is near its owner. The distance equals 0 m.";
        System.out.println(getDistance() == 0 ? near : movement);
    }
}

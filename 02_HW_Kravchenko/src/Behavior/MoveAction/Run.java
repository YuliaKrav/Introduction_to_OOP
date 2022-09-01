package Behavior.MoveAction;

public class Run extends DistanceControl implements MoveBehavior {
    public Run(int distance, int callingSteptoPerson) {
        super(distance, callingSteptoPerson);
    }

    @Override
    public void move() {
        System.out.println("An animal runs.");
    }

    @Override
    public void move(String type, String name, int times) {
        System.out.print("The distance equals " + getDistance() + " m. ");
        oneStep(times);
        String movement = "The animal-" + type + " " + name + " runs to its owner. The distance decreased down to "
                + (getCallingSteptoPerson() * times > getDistance() ? getDistance() : getCallingSteptoPerson() * times) + " m. and become "
                + getDistance() + " m.";
        String near = "The animal-" + type + " " + name + " is near its owner. The distance equals 0 m.";
        System.out.println(getDistance() == 0 ? near : movement);
    }
}

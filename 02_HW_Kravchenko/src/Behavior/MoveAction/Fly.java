package Behavior.MoveAction;

public class Fly implements MoveBehavior {
    @Override
    public void move() {
        System.out.println("An animal flies.");
    }

    @Override
    public void move(String type, String name, int times) {

    }
}

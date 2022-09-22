package entities.employees;

import entities.constantscountersenums.PositionName;

public class Tester extends Employee {
    public Tester(Human human) {
        super(human, PositionName.getTESTER_POSITION_NAME());
    }
}

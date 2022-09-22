package entities.employees;

import entities.constantscountersenums.PositionName;

public class Driver extends Employee {
    public Driver(Human human, int salary) {
        super(human, salary, PositionName.getDRIVER_POSITION_NAME());
    }

    public Driver(Human human) {
        super(human, PositionName.getDRIVER_POSITION_NAME());
    }
}

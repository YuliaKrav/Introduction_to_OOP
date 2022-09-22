package entities.employees;

import entities.constantscountersenums.PositionName;

public class Cleaner extends Employee {

    public Cleaner(Human human, int salary) {
        super(human, salary, PositionName.getCLEANER_POSITION_NAME());
    }

    public Cleaner(Human human) {
        super(human, PositionName.getCLEANER_POSITION_NAME());
    }
}

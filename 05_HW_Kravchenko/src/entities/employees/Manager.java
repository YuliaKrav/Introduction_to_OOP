package entities.employees;

import entities.constantscountersenums.PositionName;

public class Manager extends Employee {
    public Manager(Human human, int salary) {
        super(human, salary, PositionName.getMANAGER_POSITION_NAME());
    }

    public Manager(Human human) {
        super(human, PositionName.getMANAGER_POSITION_NAME());
    }
}

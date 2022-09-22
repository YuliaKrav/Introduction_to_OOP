package entities.employees;

import entities.constantscountersenums.PositionName;

public class Operator extends Employee {
    public Operator(Human human, int salary) {
        super(human, salary, PositionName.getOPERATOR_POSITION_NAME());
    }

    public Operator(Human human) {
        super(human, PositionName.getOPERATOR_POSITION_NAME());
    }
}

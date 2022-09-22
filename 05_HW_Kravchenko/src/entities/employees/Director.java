package entities.employees;

import entities.constantscountersenums.PositionName;

public class Director extends Employee {
    public Director(Human human, int salary) {
        super(human, salary, PositionName.getDIRECTOR_POSITION_NAME());
    }

    public Director(Human human) {
        super(human, PositionName.getDIRECTOR_POSITION_NAME());
    }
}

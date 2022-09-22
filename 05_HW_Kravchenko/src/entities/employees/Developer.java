package entities.employees;

import entities.constantscountersenums.PositionName;

public class Developer extends Employee {
    public Developer(Human human) {
        super(human, PositionName.getDEVELOPER_POSITION_NAME());
    }
}

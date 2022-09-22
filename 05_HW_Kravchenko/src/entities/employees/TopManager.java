package entities.employees;

import entities.constantscountersenums.PositionName;

public class TopManager extends Employee {
    public TopManager(Human human, int salary) {
        super(human, salary, PositionName.getTOP_MANAGER_POSITION_NAME());
    }

    public TopManager(Human human) {
        super(human, PositionName.getTOP_MANAGER_POSITION_NAME());
    }
}

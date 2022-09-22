package entities.employees;

import entities.constantscountersenums.PositionName;

public class HRSpecialist extends Employee {
    public HRSpecialist(Human human, int salary) {
        super(human, salary, PositionName.getHR_SPECIALIST_POSITION_NAME());
    }

    public HRSpecialist(Human human) {
        super(human, PositionName.getHR_SPECIALIST_POSITION_NAME());
    }
}

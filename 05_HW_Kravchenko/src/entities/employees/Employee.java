package entities.employees;

import java.rmi.server.UID;
import java.util.UUID;

public abstract class Employee {
    private String id;
    private String positionName;

    private Human human;
    private int salary;

    public Employee(Human human, int salary) {
        this(human, salary, "none");
    }

    public Employee(Human human, String positionName) {
        this(human, 0, positionName);
    }

    public Employee(Human human, int salary, String positionName) {
        this.id = UUID.randomUUID().toString();
        this.human = human;
        this.salary = salary;
        this.positionName = positionName;
    }

    public String getId() {
        return id;
    }

    public String getPositionName() {
        return positionName;
    }

    public Human getHuman() {
        return human;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
//        return "ID: " + id + " " + human + " " + "Position: " + positionName;
        return human + " " + "Position: " + positionName;
    }
}

package servives;

import entities.employees.Employee;
import entities.employees.Human;

public interface EmployeesServiceInt {
    void hire(Employee employee);

    void fire(Human human);

    String getAllEmployees();

    Employee findEmployeeByHuman(Human human);

    boolean isHumanInternalEmployee(Human human);
}

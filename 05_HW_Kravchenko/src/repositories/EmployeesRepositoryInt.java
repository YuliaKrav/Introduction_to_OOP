package repositories;

import entities.employees.Employee;
import entities.employees.Human;

import java.util.List;
import java.util.Map;

public interface EmployeesRepositoryInt {
    void addEmployee(Employee employee);

    void removeEmployee(Human human);

    String getAllEmployees();

    Employee getEmployeeByHuman(Human human);

    boolean isHumanInternalEmployee(Human human);
}

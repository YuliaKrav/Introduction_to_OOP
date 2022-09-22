package servives;

import entities.employees.Employee;
import entities.employees.Human;
import repositories.EmployeesRepository;

public class EmployeesService implements EmployeesServiceInt {
    private EmployeesRepository employeesRepository;

    public EmployeesService() {
        this.employeesRepository = new EmployeesRepository();
    }

    public void hire(Employee employee) {
        employeesRepository.addEmployee(employee);
    }

    @Override
    public void fire(Human human) {
        employeesRepository.removeEmployee(human);
    }

    @Override
    public String getAllEmployees() {
        return employeesRepository.getAllEmployees();
    }

    @Override
    public Employee findEmployeeByHuman(Human human) {
        return employeesRepository.getEmployeeByHuman(human);
    }

    @Override
    public boolean isHumanInternalEmployee(Human human) {
        return employeesRepository.isHumanInternalEmployee(human);
    }
}

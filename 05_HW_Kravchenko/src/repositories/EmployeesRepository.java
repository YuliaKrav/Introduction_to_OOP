package repositories;

import entities.employees.Employee;
import entities.employees.Human;
import servives.EmployeesServiceInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeesRepository implements EmployeesRepositoryInt {
    Map<String, List<Employee>> positionEmployeeListMap;

    public EmployeesRepository() {
        this.positionEmployeeListMap = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        positionEmployeeListMap.putIfAbsent(employee.getPositionName(), new ArrayList<>());
        List<Employee> newEmployeeList = positionEmployeeListMap.get(employee.getPositionName());
        newEmployeeList.add(employee);
        positionEmployeeListMap.put(employee.getPositionName(), newEmployeeList);
        System.out.println("A new employee - " + employee + " has been hired.");
    }

    @Override
    public void removeEmployee(Human human) {
        boolean isFound = false;
        for (List<Employee> employeeList : positionEmployeeListMap.values()) {
            for (Employee employee : employeeList) {
                if (employee.getHuman().equals(human)) {
                    employeeList.remove(employee);
                    System.out.println(employee + " has been fired.");
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        if (!isFound) {
            System.out.println(human + " is not an employee of the company.");
        }
    }

    @Override
    public String getAllEmployees() {
        String resultStringToPrint = "All employees of the company:\n";
        for (var stringListEntry : positionEmployeeListMap.entrySet()) {
            resultStringToPrint += stringListEntry.getKey() + " " + stringListEntry.getValue() + "\n";
        }
        return resultStringToPrint;
    }

    @Override
    public Employee getEmployeeByHuman(Human human) {
        for (List<Employee> employeeList : positionEmployeeListMap.values()) {
            for (Employee employee : employeeList) {
                if (employee.getHuman().equals(human)) {
                    return employee;
                }
            }
        }
        System.out.println(human + " is not an employee of the company.");
        return null;
    }

    @Override
    public boolean isHumanInternalEmployee(Human human) {
        for (List<Employee> employeeList : positionEmployeeListMap.values()) {
            for (Employee employee : employeeList) {
                if (employee.getHuman().equals(human)) {
                    System.out.println(human + " is an employee of the company.");
                    return true;
                }
            }
        }
        System.out.println(human + " is not an employee of the company.");
        return false;
    }

}

package companies;

import entities.employees.Employee;
import entities.employees.Human;

import java.util.List;

public interface CompanyInt {
    void hireNewStaff(Employee employee);

    void hireAllNewStaff(List<Employee> employeeList);

    void fireSelectedStaff(Human human);

    void fireAllSelectedStaff(List<Human> peopleList);

    void printAllEmployees();

    void printAllActualDocuments();

    void printAllActualProjects();

    void createNewProject(Employee owner, String projectName);

    Employee findEmployeeByHuman(Human human);

    void addEmployeeToProject(Employee projectOwner, int projectNumber, Employee projectNewMember);

    boolean isHumanInternalEmployee(Human human);


//    void addEmployeeToProject();
}

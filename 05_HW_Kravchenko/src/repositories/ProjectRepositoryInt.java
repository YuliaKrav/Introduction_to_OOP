package repositories;

import entities.documents.Document;
import entities.employees.Employee;

public interface ProjectRepositoryInt {
    boolean isEligibleToCreateProject(Employee employee);

    void addNewProject(Employee employee, Document projectDoc);

    public String getAllProjects();

    boolean isEmployeeProjectOwner(Employee projectOwner, int projectNumber);

    void addNewMemberToProject(Employee projectOwner, int projectNumber, Employee projectNewMember);
}

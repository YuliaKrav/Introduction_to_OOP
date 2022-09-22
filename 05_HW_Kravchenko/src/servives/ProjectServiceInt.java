package servives;

import entities.documents.Document;
import entities.employees.Employee;

public interface ProjectServiceInt {
    void addNewProject(Employee employee, Document projectDoc);

    boolean isEligibleToCreateProject(Employee employee);

    String getAllProjects();

    boolean isEmployeeProjectOwner(Employee projectOwner, int projectNumber);

    void addNewMemberToProject(Employee projectOwner, int projectNumber, Employee projectNewMember);
}

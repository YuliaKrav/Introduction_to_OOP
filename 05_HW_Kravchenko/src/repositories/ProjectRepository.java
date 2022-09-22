package repositories;

import entities.projects.Project;
import entities.documents.Document;
import entities.documents.ProjectDoc;
import entities.employees.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepository implements ProjectRepositoryInt {
    private Map<Employee, List<Project>> employeeToProjectsMap;

    public ProjectRepository() {
        this.employeeToProjectsMap = new HashMap<>();
    }

    @Override
    public boolean isEligibleToCreateProject(Employee employee) {
        ProjectDoc projectDoc = new ProjectDoc(employee, "Check");
        List<Class> responsibleClasses = projectDoc.getResponsibleClassToCreate();
        for (Class responsibleClass : responsibleClasses) {
            if (employee.getClass().equals(responsibleClass)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addNewProject(Employee employee, Document projectDoc) {
        employeeToProjectsMap.putIfAbsent(employee, new ArrayList<>());
        List<Project> newProjectList = employeeToProjectsMap.get(employee);
        newProjectList.add(new Project(employee, projectDoc));
        employeeToProjectsMap.put(employee, newProjectList);
        System.out.println(employee + " has created a '" + ((ProjectDoc) projectDoc).getProjectName() + "' project.");
    }

    @Override
    public void addNewMemberToProject(Employee projectOwner, int projectNumber, Employee projectNewMember) {
        if (employeeToProjectsMap.containsKey(projectOwner)) {
            List<Project> newProjectList = employeeToProjectsMap.get(projectOwner);
            for (Project project : newProjectList) {
                if (project.getProjectId() == projectNumber) {
                    List<Employee> projectTeam = project.getTeam();
                    projectTeam.add(projectNewMember);
                    project.getProjectDoc().addAccessToDocument(projectNewMember);
                    System.out.println(projectNewMember + " has been added to the project with id=" + projectNumber);
                    break;
                }
            }
        }
    }

    public String getAllProjects() {
        String resultStringToPrint = "All projects of the company:\n";
        for (var stringListEntry : employeeToProjectsMap.entrySet()) {
            resultStringToPrint += stringListEntry.getKey() + "\n" + stringListEntry.getValue() + "\n";
        }
        return resultStringToPrint;
    }

    @Override
    public boolean isEmployeeProjectOwner(Employee projectOwner, int projectNumber) {
        if (employeeToProjectsMap.containsKey(projectOwner)) {
            List<Project> newProjectList = employeeToProjectsMap.get(projectOwner);
            for (Project project : newProjectList) {
                if (project.getProjectId() == projectNumber) {
                    return true;
                }
            }
        }
        return false;
    }
}

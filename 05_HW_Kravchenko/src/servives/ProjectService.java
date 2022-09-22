package servives;

import entities.documents.Document;
import entities.employees.Employee;
import repositories.ProjectRepository;

public class ProjectService implements ProjectServiceInt {
    private ProjectRepository projectRepository;

    public ProjectService() {
        this.projectRepository = new ProjectRepository();
    }

    @Override
    public void addNewProject(Employee employee, Document projectDoc) {
        projectRepository.addNewProject(employee, projectDoc);
    }

    @Override
    public void addNewMemberToProject(Employee projectOwner, int projectNumber, Employee projectNewMember) {
        projectRepository.addNewMemberToProject(projectOwner, projectNumber, projectNewMember);
    }

    @Override
    public boolean isEligibleToCreateProject(Employee employee) {
        return projectRepository.isEligibleToCreateProject(employee);
    }

    @Override
    public String getAllProjects() {
        return projectRepository.getAllProjects();
    }

    @Override
    public boolean isEmployeeProjectOwner(Employee projectOwner, int projectNumber) {
        return projectRepository.isEmployeeProjectOwner(projectOwner, projectNumber);
    }
}

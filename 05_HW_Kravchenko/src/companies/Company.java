package companies;

import entities.constantscountersenums.DocumentationName;
import entities.documents.AgreementDoc;
import entities.documents.ProjectDoc;
import entities.employees.Employee;
import entities.employees.Human;
import entities.employees.Manager;
import servives.DocumentService;
import servives.EmployeesService;
import servives.ProjectService;

import java.util.List;

public class Company implements CompanyInt {
    private String name;
    EmployeesService employeesService;
    DocumentService documentService;
    ProjectService projectService;

    public Company(String name) {
        this.name = name;
        this.employeesService = new EmployeesService();
        this.documentService = new DocumentService();
        this.projectService = new ProjectService();
        System.out.println("A Company " + name + " has been created.");
    }

    public void hireNewStaff(Employee employee) {
        employeesService.hire(employee);
        documentService.addDocument(new AgreementDoc(employee));
    }

    public void hireAllNewStaff(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            hireNewStaff(employee);
        }
    }

    @Override
    public void fireSelectedStaff(Human human) {
        employeesService.fire(human);
        documentService.deleteDocument(DocumentationName.getAGREEMENT_NAME(), human);
    }

    @Override
    public void fireAllSelectedStaff(List<Human> peopleList) {
        for (Human human : peopleList) {
            fireSelectedStaff(human);
        }
    }

    @Override
    public void printAllEmployees() {
        System.out.println(employeesService.getAllEmployees());
    }

    @Override
    public void printAllActualDocuments() {
        System.out.println(documentService.getAllDocuments());
    }

    @Override
    public void printAllActualProjects() {
        System.out.println(projectService.getAllProjects());
    }

    @Override
    public void createNewProject(Employee owner, String projectName) {
        if (isEligibleToCreateProject(owner)) {
            ProjectDoc newProject = new ProjectDoc(owner, projectName);
            documentService.addDocument(newProject);
            projectService.addNewProject(owner, newProject);
        } else {
            System.out.println(owner + " has no right to create a project.");
        }
    }

    @Override
    public Employee findEmployeeByHuman(Human human) {
        return employeesService.findEmployeeByHuman(human);
    }

    @Override
    public void addEmployeeToProject(Employee projectOwner, int projectNumber, Employee projectNewMember) {
        if (isEmployeeProjectOwner(projectOwner, projectNumber)) {
            projectService.addNewMemberToProject(projectOwner, projectNumber, projectNewMember);
        } else {
            System.out.println(projectOwner + " is not able to add a new member to the project with id=" + projectNumber);
        }
    }

    @Override
    public boolean isHumanInternalEmployee(Human human) {
        return employeesService.isHumanInternalEmployee(human);
    }

    private boolean isEligibleToCreateProject(Employee employee) {
        return projectService.isEligibleToCreateProject(employee);
    }

    private boolean isEmployeeProjectOwner(Employee projectOwner, int projectNumber) {
        return projectService.isEmployeeProjectOwner(projectOwner, projectNumber);
    }
}

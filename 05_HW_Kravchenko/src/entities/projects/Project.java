package entities.projects;

import entities.constantscountersenums.GenerateId;
import entities.documents.Document;
import entities.documents.ProjectDoc;
import entities.employees.Employee;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private int projectId;
    private Employee owner;
    private String projectName;
    private ProjectDoc projectDoc;
    private List<Employee> team;
    private List<Document> additionalDocuments;

    public Project(Employee owner, Document projectDoc) {
        this.projectId = GenerateId.getIdProjectCounter();
        this.owner = owner;
        this.projectDoc = (ProjectDoc) projectDoc;
        this.projectName = ((ProjectDoc) projectDoc).getProjectName();
        this.team = new ArrayList<>();
        team.add(owner);
        this.additionalDocuments = new ArrayList<>();
    }

    public int getProjectId() {
        return projectId;
    }

    public List<Employee> getTeam() {
        return team;
    }

    public ProjectDoc getProjectDoc() {
        return projectDoc;
    }

    @Override
    public String toString() {
        return "№: " + projectId + " Owner: " + owner + " Documents: " + projectDoc + " Team: " + team;
    }
}

package entities.documents;

import entities.constantscountersenums.DocumentationName;
import entities.employees.Employee;
import entities.employees.TopManager;

public class ProjectDoc extends Document {
    //private final AccessLevelEnum DEFAULT_ACCESS_LEVEL = AccessLevelEnum.HIGH;
    private Employee creator;
    private String projectName;
    boolean isInProgress;

    public ProjectDoc(Employee creator, String name) {
        super(DocumentationName.getPROJECT_DOC_NAME());
        addAccessToDocument(TopManager.class);
        addResponsibilityToCreate(TopManager.class);
        this.creator = creator;
        projectName = new String(name);
        isInProgress = true;
    }

    public String getProjectName() {
        return projectName;
    }

    @Override
    public void makeDocumentInactive() {
        isInProgress = false;
    }
}

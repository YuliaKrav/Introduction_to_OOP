package entities.documents;

import entities.constantscountersenums.AccessLevelEnum;
import entities.constantscountersenums.GenerateId;
import entities.employees.Employee;

import java.util.ArrayList;
import java.util.List;

public abstract class Document {
    private int id;
    private String type;
    private List<Class> responsibleClassToCreate;
    private List<Employee> accessPeople;
    private List<Class> accessPositionClass;


    public Document(AccessLevelEnum accessLevel) {
        this("None");
    }

    public Document(String type) {
        this.id = GenerateId.getIdDocumentCounter();
        this.type = type;

        responsibleClassToCreate = new ArrayList<>();
        accessPeople = new ArrayList<>();
        accessPositionClass = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public List<Employee> getAccessPeople() {
        return accessPeople;
    }

    public List<Class> getAccessPositionClass() {
        return accessPositionClass;
    }

    public List<Class> getResponsibleClassToCreate() {
        return responsibleClassToCreate;
    }

    @Override
    public String toString() {
        return "Name: " + type;
    }

    public void addAccessToDocument(Employee employee) {
        getAccessPeople().add(employee);
    }

    public void addAccessToDocument(Class<?> classType) {
        getAccessPositionClass().add(classType);
    }

    public void addResponsibilityToCreate(Class<?> classType) {
        getResponsibleClassToCreate().add(classType);
    }

    public abstract void makeDocumentInactive();
}

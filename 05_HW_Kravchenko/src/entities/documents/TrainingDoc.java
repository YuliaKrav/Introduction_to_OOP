package entities.documents;

import entities.constantscountersenums.DocumentationName;
import entities.employees.Director;
import entities.employees.Employee;
import entities.employees.HRSpecialist;
import entities.employees.TopManager;

public class TrainingDoc extends Document {
    boolean isActual;

    public TrainingDoc(String name) {
        super(DocumentationName.getTRAINING_DOC_NAME());
        addAccessToDocument(HRSpecialist.class);
        addAccessToDocument(TopManager.class);
        addAccessToDocument(Director.class);

        isActual = true;
    }

    @Override
    public void makeDocumentInactive() {
        isActual = false;
    }

}

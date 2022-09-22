package entities.documents;

import entities.constantscountersenums.DocumentationName;
import entities.employees.Employee;
import entities.employees.HRSpecialist;

public class AgreementDoc extends Document {
    private Employee employee;
    //    boolean isSigned;
    private boolean isActive;

    public AgreementDoc(Employee employee) {
        super(DocumentationName.getAGREEMENT_NAME());
        this.employee = employee;
        addAccessToDocument(employee);
        addAccessToDocument(HRSpecialist.class);
//        isSigned = true;
        isActive = true;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public void makeDocumentInactive() {
        isActive = false;
    }

    @Override
    public String toString() {
        return "Name: " + getType() + " Employee: " + employee;
    }
}

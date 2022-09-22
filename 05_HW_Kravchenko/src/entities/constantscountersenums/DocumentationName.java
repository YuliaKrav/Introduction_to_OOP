package entities.constantscountersenums;

import java.util.ArrayList;
import java.util.List;

public class DocumentationName {
    private static final String AGREEMENT_NAME = "agreement";
    private static final String PROJECT_DOC_NAME = "project documents";
    private static final String TRAINING_DOC_NAME = "agreement";

    List<String> allDocumentationNames;

    public DocumentationName(List<String> allDocumentationNames) {
        this.allDocumentationNames = new ArrayList<>();
        allDocumentationNames.add(AGREEMENT_NAME);
        allDocumentationNames.add(PROJECT_DOC_NAME);
        allDocumentationNames.add(TRAINING_DOC_NAME);
    }

    public static String getAGREEMENT_NAME() {
        return AGREEMENT_NAME;
    }

    public static String getPROJECT_DOC_NAME() {
        return PROJECT_DOC_NAME;
    }

    public static String getTRAINING_DOC_NAME() {
        return TRAINING_DOC_NAME;
    }
}

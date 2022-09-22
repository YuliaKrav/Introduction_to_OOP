package repositories;

import entities.documents.AgreementDoc;
import entities.documents.Document;
import entities.employees.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentsRepository implements DocumentsRepositoryInt {
    Map<String, List<Document>> typeDocumentListMap;
    List<Document> documentArchiveList;

    public DocumentsRepository() {
        this.typeDocumentListMap = new HashMap<>();
        this.documentArchiveList = new ArrayList<>();
    }

    public void addDocument(Document document) {
        typeDocumentListMap.putIfAbsent(document.getType(), new ArrayList<>());
        List<Document> newDocumentList = typeDocumentListMap.get(document.getType());
        newDocumentList.add(document);
        typeDocumentListMap.put(document.getType(), newDocumentList);
        System.out.println("New document - " + document + " has been added to the system.");
    }

    @Override
    public void removeDocument(Document document) {
    }

    @Override
    public void removeDocumentToArchive(String documentType, Human human) {
        List<Document> newDocumentList = typeDocumentListMap.get(documentType);
        for (Document document : newDocumentList) {
            if (document instanceof AgreementDoc) {
                if (((AgreementDoc) document).getEmployee().getHuman().equals(human)) {
                    newDocumentList.remove(document);
                    typeDocumentListMap.put(documentType, newDocumentList);
                    document.makeDocumentInactive();
                    documentArchiveList.add(document);
                    System.out.println("A document - " + document + " has been added to the archive.");
                    break;
                }
            }
        }
    }

    @Override
    public String getAllDocuments() {
        String resultStringToPrint = "All documents of the company:\n";
        for (var stringListEntry : typeDocumentListMap.entrySet()) {
            resultStringToPrint += stringListEntry.getKey() + " " + stringListEntry.getValue() + "\n";
        }
        return resultStringToPrint;
    }
}

package repositories;

import entities.documents.Document;
import entities.employees.Human;

public interface DocumentsRepositoryInt {
    void addDocument(Document document);

    void removeDocument(Document document);

    void removeDocumentToArchive(String documentType, Human human);

    String getAllDocuments();
}

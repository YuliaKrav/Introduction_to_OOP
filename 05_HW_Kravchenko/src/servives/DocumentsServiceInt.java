package servives;

import entities.documents.Document;
import entities.employees.Human;;

public interface DocumentsServiceInt {
    void addDocument(Document document);

    void deleteDocument(String documentType, Human human);

    String getAllDocuments();
}

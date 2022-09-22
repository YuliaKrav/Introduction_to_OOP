package servives;

import entities.documents.Document;
import entities.employees.Human;
import repositories.DocumentsRepository;

public class DocumentService implements DocumentsServiceInt {
    DocumentsRepository documentsRepository;


    public DocumentService() {
        this.documentsRepository = new DocumentsRepository();
    }


    public void addDocument(Document document) {
        documentsRepository.addDocument(document);
    }

    @Override
    public void deleteDocument(String documentType, Human human) {
        documentsRepository.removeDocumentToArchive(documentType, human);
    }

    @Override
    public String getAllDocuments() {
        return documentsRepository.getAllDocuments();
    }
}

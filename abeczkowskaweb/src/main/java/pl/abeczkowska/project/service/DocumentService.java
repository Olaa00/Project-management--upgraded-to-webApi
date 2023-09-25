package pl.abeczkowska.project.service;

import pl.abeczkowska.project.repository.DocumentRepository;
import pl.abeczkowska.project.service.interfaces.iDocumentService;
import pl.abeczkowska.project.model.Document;

import java.sql.SQLException;
import java.util.List;

public class DocumentService implements iDocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public void createDocument(Document document) throws SQLException {
        documentRepository.createDocument(document);
    }

    @Override
    public void editDocument(Document document) throws SQLException {
        documentRepository.editDocument(document);
    }

    @Override
    public Document getDocumentByTitle(String title) throws SQLException {
        return documentRepository.getDocumentByTitle(title);
    }

    @Override
    public void deleteDocument(String title) throws SQLException {
        documentRepository.deleteDocument(title);
    }

    @Override
    public List<Document> showDocumentsForUser(String username) throws SQLException {
        return documentRepository.showDocumentsForUser(username);
    }
}

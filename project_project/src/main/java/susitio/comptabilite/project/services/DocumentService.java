package susitio.comptabilite.project.services;

import susitio.comptabilite.project.entities.Document;

import java.util.List;

public interface DocumentService {
    public List<Document> getDocuments() ;
    public Document getDocumentById(int Id) ;
    public void addDocument(Document document) ;
    public void deleteDocument(int id) ;
}

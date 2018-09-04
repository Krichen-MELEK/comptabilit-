package susitio.comptabilite.project.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import susitio.comptabilite.project.entities.Document;
import susitio.comptabilite.project.enums.TypeFolder;

public interface DocumentService {
    public List<Document> getDocuments() ;
    public Document getDocumentById(int Id) ;
    public void deleteDocument(int id) ;
	public void uploadDocuments(MultipartFile file, TypeFolder type, String annee);
}

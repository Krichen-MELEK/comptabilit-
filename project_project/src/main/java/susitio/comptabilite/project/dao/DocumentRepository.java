package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import susitio.comptabilite.project.entities.Document;
import susitio.comptabilite.project.entities.Personne;
import susitio.comptabilite.project.enums.TypeFolder;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document,Integer> {
    public List<Document> getDocumentByAnneeDeCreationAndPersonneEmmeteurDocumentAndType(String annee, Personne personne, TypeFolder type) ;
}

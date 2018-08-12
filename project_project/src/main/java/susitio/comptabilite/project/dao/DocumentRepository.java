package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import susitio.comptabilite.project.entities.Document;

public interface DocumentRepository extends JpaRepository<Document,Integer> {
}

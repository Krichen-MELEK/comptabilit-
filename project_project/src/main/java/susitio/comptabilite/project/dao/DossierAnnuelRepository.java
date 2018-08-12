package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import susitio.comptabilite.project.entities.DossierAnnuel;

import java.util.List;

public interface DossierAnnuelRepository extends JpaRepository<DossierAnnuel,Integer> {

    public List<DossierAnnuel> findByClient() ;
}

package susitio.comptabilite.project.services;

import org.springframework.stereotype.Repository;
import susitio.comptabilite.project.entities.DossierAnnuel;

import java.util.List;

@Repository
public interface DossierAnnuelService {

    public List<DossierAnnuel> getDossierAnnuelByClient() ;
    public DossierAnnuel getDossierAnnuelById(int id) ;
    public void addDossierAnnuel(DossierAnnuel dossierAnnuel) ;
    public void deleteDossierAnnuel(int id) ;
}

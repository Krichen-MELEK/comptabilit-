package susitio.comptabilite.project.services;

import susitio.comptabilite.project.entities.DossierAnnuel;

import java.util.List;

public interface DossierAnnuelService {

    public List<DossierAnnuel> getDossierAnnuel() ;
    public DossierAnnuel getDossierAnnuelById(int id) ;
    public void addDossierAnnuel(DossierAnnuel dossierAnnuel) ;
    public void deleteDossierAnnuel(int id) ;
}

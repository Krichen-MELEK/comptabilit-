package susitio.comptabilite.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import susitio.comptabilite.project.dao.DossierAnnuelRepository;
import susitio.comptabilite.project.entities.DossierAnnuel;

import java.util.List;

@Service
public class DossierAnnuelServiceImpl implements DossierAnnuelService {

    @Autowired
    DossierAnnuelRepository dossierAnnuelRepository ;

    @Override
    public List<DossierAnnuel> getDossierAnnuelByClient() {
        return dossierAnnuelRepository.findByClient();
    }

    @Override
    public DossierAnnuel getDossierAnnuelById(int id) {
        return dossierAnnuelRepository.findById(id).get();
    }

    @Override
    public void addDossierAnnuel(DossierAnnuel dossierAnnuel) {
        dossierAnnuelRepository.save(dossierAnnuel) ;
    }

    @Override
    public void deleteDossierAnnuel(int id) {
        dossierAnnuelRepository.deleteById(id);
    }
}

package susitio.comptabilite.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import susitio.comptabilite.project.dao.DossierAnnuelRepository;
import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.DossierAnnuel;

@Service
public class DossierAnnuelServiceImpl implements DossierAnnuelService {

    @Autowired
    DossierAnnuelRepository dossierAnnuelRepository ;

    @Override
    public List<DossierAnnuel> getDossierAnnuelByClient(Client client) {
        return dossierAnnuelRepository.findByClient(client);
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

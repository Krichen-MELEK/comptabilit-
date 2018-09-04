package susitio.comptabilite.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import susitio.comptabilite.project.dao.PersonneRepository;
import susitio.comptabilite.project.entities.Personne;

import java.util.List;



@Service
public class PersonneServiceImp implements PersonneService {
    @Autowired
    PersonneRepository personneRepository ;

    @Override
    public Personne getPersonneById(int id) {
        return personneRepository.findById(id).get() ;
    }
}

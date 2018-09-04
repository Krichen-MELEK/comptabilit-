package susitio.comptabilite.project.services;

import org.springframework.stereotype.Repository;
import susitio.comptabilite.project.entities.Personne;

import java.util.List;

@Repository
public interface PersonneService {

    public Personne getPersonneById(int id);
}

package susitio.comptabilite.project.services;

import susitio.comptabilite.project.entities.Personne;

public interface PersonneService {

    public Personne getPersonneById(int id);

	Personne getPersonneByEmail(String email);
}

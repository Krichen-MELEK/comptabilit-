package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import susitio.comptabilite.project.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne,Integer> {
}

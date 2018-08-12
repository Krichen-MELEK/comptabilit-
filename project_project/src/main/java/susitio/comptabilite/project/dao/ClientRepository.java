package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import susitio.comptabilite.project.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

}

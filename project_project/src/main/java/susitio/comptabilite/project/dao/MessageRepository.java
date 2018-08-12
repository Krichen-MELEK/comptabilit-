package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import susitio.comptabilite.project.entities.Message;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {
    public List<Message> findByPersonneEmetteur(int id) ;
    public List<Message> findByPersonneRecepteur(int id) ;
}

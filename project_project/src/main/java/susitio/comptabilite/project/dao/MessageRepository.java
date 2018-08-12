package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import susitio.comptabilite.project.entities.Message;

public interface MessageRepository extends JpaRepository<Message,Integer> {
}

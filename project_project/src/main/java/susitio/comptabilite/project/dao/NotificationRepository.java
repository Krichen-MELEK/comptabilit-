package susitio.comptabilite.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import susitio.comptabilite.project.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}

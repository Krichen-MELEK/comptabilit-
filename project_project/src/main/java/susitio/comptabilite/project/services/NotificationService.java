package susitio.comptabilite.project.services;

import org.springframework.stereotype.Repository;
import susitio.comptabilite.project.entities.Notification;

import java.util.List;

@Repository
public interface NotificationService {
    public List<Notification> getNotification() ;
    public Notification getNotificationById(int id) ;
    public void addNotification(Notification notification) ;
    public void deleteNotification(int id) ;
}

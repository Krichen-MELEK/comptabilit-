package susitio.comptabilite.project.services;

import susitio.comptabilite.project.entities.Notification;

import java.util.List;

public interface NotificationService {
    public List<Notification> getNotification() ;
    public Notification getNotificationById(int id) ;
    public void addNotification(Notification notification) ;
    public void deleteNotification(int id) ;
}

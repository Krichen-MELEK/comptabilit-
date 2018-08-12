package susitio.comptabilite.project.services;

import org.springframework.stereotype.Service;
import susitio.comptabilite.project.entities.Notification;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Override
    public List<Notification> getNotification() {
        return null;
    }

    @Override
    public Notification getNotificationById(int id) {
        return null;
    }

    @Override
    public void addNotification(Notification notification) {

    }

    @Override
    public void deleteNotification(int id) {

    }
}

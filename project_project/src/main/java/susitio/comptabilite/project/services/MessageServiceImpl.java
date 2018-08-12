package susitio.comptabilite.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import susitio.comptabilite.project.dao.MessageRepository;
import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.Message;
import susitio.comptabilite.project.entities.Notification;
import susitio.comptabilite.project.enums.TypeNotification;

import java.util.List;



@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository ;

    @Autowired
    NotificationService notificationService ;

    @Autowired
    ClientService clientService ;

    @Override
    public List<Message> getMessagesEmmeteur(int id) {
        return messageRepository.findByPersonneEmetteur(id);
    }

    @Override
    public List<Message> getMessagesRecepteur(int id) {
        return messageRepository.findByPersonneRecepteur(id);
    }

    @Override
    public Message getMessageById(int id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public void addMessage(Message message) {
        Client client = clientService.getClientById(message.getPersonneEmetteur().getId()) ;
        String contenueNotification = client.getNom() + "\n" + message.getObject() ;
        Notification notification = new Notification(TypeNotification.message,contenueNotification,message.getId()) ;
        notificationService.addNotification(notification);
        messageRepository.save(message) ;
    }

    @Override
    public void deleteMessage(int id) {
        messageRepository.deleteById(id);
    }

    @Override
    public void luMessage(int id) {
        Message message = messageRepository.findById(id).get() ;
        message.setLu(true);
    }

}

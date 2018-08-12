package susitio.comptabilite.project.services;

import susitio.comptabilite.project.entities.Message;

import java.util.List;

public interface MessageService {

    public List<Message> getMessagesEmmeteur(int id) ;
    public List<Message> getMessagesRecepteur(int id) ;
    public Message getMessageById(int id) ;
    public void addMessage(Message message) ;
    public void deleteMessage(int id) ;
    public void luMessage(int id) ;
}

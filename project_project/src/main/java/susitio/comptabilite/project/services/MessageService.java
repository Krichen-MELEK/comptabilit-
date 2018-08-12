package susitio.comptabilite.project.services;

import susitio.comptabilite.project.entities.Message;

import java.util.List;

public interface MessageService {

    public List<Message> getMessages() ;
    public Message getMessageById(int id) ;
    public void addMessage(Message message) ;
    public void deleteMessage(int id) ;
}

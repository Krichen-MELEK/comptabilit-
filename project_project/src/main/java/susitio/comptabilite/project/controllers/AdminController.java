package susitio.comptabilite.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.Collaborateur;
import susitio.comptabilite.project.entities.Message;
import susitio.comptabilite.project.entities.Notification;
import susitio.comptabilite.project.services.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ClientService clientService ;

    @Autowired
    private CollaborateurService collaborateurService ;

    @Autowired
    private AdminService adminService ;

    @Autowired
    private MessageService messageService ;

    @Autowired
    private NotificationService notificationService ;

    @GetMapping({"/client/view/all"})
    public List<Client> getAllClient(){
        return clientService.getClients() ;
    }

    @GetMapping({"/client/view/{id}"})
    public Client getClientById(@PathVariable final int id){
        return clientService.getClientById(id) ;
    }

    @DeleteMapping({"/client/delete/{id}"})
    public void deleteClient(@PathVariable final int id){
        clientService.deleteClient(id);
    }

    @GetMapping({"/client/approuver/{id}"})
    public void approuveCleint(@PathVariable final int id){
        clientService.approuverClient(id);
    }

    @GetMapping({"/collaborateur/view/all"})
    public List<Collaborateur> getAllCollaborateur(){
        return collaborateurService.getCollaborateurs() ;
    }

    @GetMapping({"/collaborateur/view/{id}"})
    public Collaborateur getCollaborateurById(@PathVariable final int id){
        return collaborateurService.getCollaborateurById(id) ;
    }

    @DeleteMapping({"/collaborateur/delete/{id}"})
    public void deleteCollaborateur(@PathVariable final int id){
        collaborateurService.deleteCollaborateur(id);
    }

    @PostMapping({"/collaborateur/add"})
    public void createCollaborateur(@RequestBody Collaborateur collaborateur){
        collaborateurService.addCollaborateur(collaborateur);
    }

    @PutMapping({"/collaborateur/update"})
    public void updateCollaborateur(@RequestBody Collaborateur collaborateur){
        collaborateurService.addCollaborateur(collaborateur);
    }

   /* @GetMapping({"/message/reception/view/all/{idAdmin}"})
    public List<Message> getAllMessagesReception(@PathVariable final int idAdmin){
        return adminService.getMessageRecepteur(idAdmin) ;
    }

    @GetMapping({"/message/Envoie/view/all/{idAdmin}"})
    public List<Message> getAllMessagesEnvoie(@PathVariable final int idAdmin){
        return adminService.getMessageEnvoie(idAdmin) ;
    } */

    @GetMapping({"message/view/{id}"})
    public Message getMessage(@PathVariable final int id){
        return messageService.getMessageById(id) ;
    }

    @PostMapping({"/message/create"})
    public void createMessage(@RequestBody Message message){
        messageService.addMessage(message);
    }

    @DeleteMapping({"message/delete/{id}"})
    public void deleteMessage(@PathVariable final int id){
        messageService.deleteMessage(id);
    }

    @GetMapping({"/message/lu/{id}"})
    public void luMessage(@PathVariable final int id){
        messageService.luMessage(id);
    }

    /*@GetMapping({"/notification/vu/{id}"})
    public void vuNotification(@PathVariable final int id){
        notificationService.vuNotification(id);
    }

    @GetMapping({"/notification/view/all/{idadmin}"})
    public List<Notification> getNotifications(@PathVariable final int idadmin){
        return notificationService.getNotificationByPersonne(idadmin) ;
    }*/
}

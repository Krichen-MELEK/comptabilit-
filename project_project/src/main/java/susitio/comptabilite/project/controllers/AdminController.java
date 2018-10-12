package susitio.comptabilite.project.controllers;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import susitio.comptabilite.project.dao.DocumentRepository;
import susitio.comptabilite.project.entities.*;
import susitio.comptabilite.project.enums.TypeNotification;
import susitio.comptabilite.project.services.AdminService;
import susitio.comptabilite.project.services.ClientService;
import susitio.comptabilite.project.services.CollaborateurService;
import susitio.comptabilite.project.services.MessageService;
import susitio.comptabilite.project.services.NotificationService;
import susitio.comptabilite.project.services.PersonneService;

@RestController
@RequestMapping("/api/admin")
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

    @Autowired
    private PersonneService personneService ;

    @Autowired
    private DocumentRepository documentRepository ;

    @GetMapping({"/client/view/all"})
    public List<Client> getAllClient(){
        return clientService.getClients() ;
    }

    @GetMapping({"/client/validation/{valide}"})
    public List<Client> getClientByValidation(@PathVariable final Boolean valide){
        return clientService.getNonValidationClients(valide) ;
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

    @GetMapping({"/message/reception/view/all/{idAdmin}"})
    public List<Message> getAllMessagesReception(@PathVariable final int idAdmin){
        return messageService.getMessagesRecepteur(personneService.getPersonneById(idAdmin));
    }

    @GetMapping({"/message/Emetteur/view/all/{idAdmin}"})
    public List<Message> getAllMessagesEnvoie(@PathVariable final int idAdmin){
        return messageService.getMessagesEmmeteur(personneService.getPersonneById(idAdmin)) ;
    }

    @GetMapping({"message/view/{id}"})
    public Message getMessage(@PathVariable final int id){
        return messageService.getMessageById(id) ;
    }

    @PostMapping({"/message/create/{emmeteur}/{recepteur}"})
    public void createMessage(@RequestBody Message message, @PathVariable final int emmeteur, @PathVariable final  int recepteur){
        message.setPersonneEmetteur(clientService.getClientById(emmeteur));
        message.setPersonneRecepteur(clientService.getClientById(recepteur));
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

    @GetMapping({"/notification/vu/{id}"})
    public void vuNotification(@PathVariable final int id){
        notificationService.luNotification(id);
    }
    @GetMapping({"/notification/delete/{id}"})
    public void deleteNotification(@PathVariable final int id){
        notificationService.deleteNotification(id);
    }
    @GetMapping({"/notification/{id}/{type}"})
    public List<Notification> getNotification(@PathVariable final int id,@PathVariable final TypeNotification type){
        Personne personne = personneService.getPersonneById(id) ;
        return notificationService.getNotificationByPersinneAndType(personne,type) ;
    }

    @GetMapping({"/client/{id}"})
    public Client getPersonne(@PathVariable final int id){
        System.out.println(id);
        return clientService.getClientById(id) ;
    }
    @DeleteMapping({"/document/delete/{id}"})
    public void deleteDocument(@PathVariable final int id){
        Document document = documentRepository.getOne(id) ;
        File file = new File("C:\\Users\\MJ_INFO\\IdeaProjects\\comptabilit-\\project_project\\src\\main\\angular\\comptable\\src\\assets\\ProfilePictureStore\\" + document.getName());

        if(file.delete()){
            System.out.println(file.getName() + " is deleted!");
            documentRepository.delete(document);
        }else{
            System.out.println("Delete operation is failed.");
        }

    }
}

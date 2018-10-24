package susitio.comptabilite.project.controllers;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import susitio.comptabilite.project.dao.DocumentRepository;
import susitio.comptabilite.project.entities.*;
import susitio.comptabilite.project.enums.TypeFolder;
import susitio.comptabilite.project.enums.TypeNotification;
import susitio.comptabilite.project.exceptions.BusinessException;
import susitio.comptabilite.project.services.*;

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

    @Autowired
    private DocumentService documentService ;

    @Autowired
    DossierAnnuelService dossierAnnuelService ;

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

    @GetMapping({"/client/desapprouver/{id}"})
    public void desapprouveCleint(@PathVariable final int id){
        clientService.desapprouverClient(id);
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

    @PostMapping("/upload/News")
    public void addDocumentNews(@RequestParam("type") TypeFolder type, @RequestParam("contenue") String contenue, @RequestParam("annee") String annee, @RequestParam("nomNews") String nomNews) {
        documentService.uploadDocumentsNews(type,annee,contenue,clientService.getClientById(1),clientService.getClientById(1),nomNews);
    }
    @PostMapping("/upload/news/file")
    public void addDocumentNewsFile(@RequestParam("file") MultipartFile file, @RequestParam("type") TypeFolder type, @RequestParam("contenue") String contenue, @RequestParam("annee") String annee, @RequestParam("nomNews") String nomNews) {
        documentService.uploadDocumentsNewsFile(file,type,annee,contenue,clientService.getClientById(1),clientService.getClientById(1),nomNews);

    }
    @GetMapping("/document/news/{type}")
    public List<Document> getDocumentNews(@PathVariable final  TypeFolder type){
        return documentService.getDocumentNews(type) ;
    }

    @GetMapping("/document/dossierJuridique/{annee}/{id}")
    public List<Document> getDossierJuridique(@PathVariable final String annee, @PathVariable final  int id){
        Client client = null;
        try {
            client = clientService.getLoggedInClient();
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return documentService.getDossier(annee,client,TypeFolder.dossierJuridique) ;
    }

    @GetMapping("/document/bilanAnnuel/{annee}/{id}")
    public List<Document> getBilanAnnuel(@PathVariable final String annee, @PathVariable final  int id){
        Client client = null;
        try {
            client = clientService.getLoggedInClient();
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return documentService.getDossier(annee,client,TypeFolder.dossierAnnuel) ;
    }
    @GetMapping("/document/bilanMensuel/{annee}/{mois}/{id}")
    public List<Document> getBilanMensuel(@PathVariable final String annee,@PathVariable final TypeFolder mois , @PathVariable final  int id){
        Client client = null;
        try {
            client = clientService.getLoggedInClient();
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return documentService.getDossier(annee,client,mois) ;
    }

    @GetMapping("/document/annee/{id}")
    public List<DossierAnnuel> getAlLDossier(@PathVariable final int id){
        try {
            return dossierAnnuelService.getDossierAnnuelByClient(clientService.getLoggedInClient()) ;
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return null ;
    }

    @GetMapping("/document/annee/cloturer/{id}")
    public void anneeCloturer(@PathVariable final int id){
        dossierAnnuelService.closeYear(id);
    }
    @GetMapping("/document/annee/activer/{id}")
    public void anneeActiver(@PathVariable final int id){
        dossierAnnuelService.openYear(id);
    }
}

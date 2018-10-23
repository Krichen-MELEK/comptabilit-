package susitio.comptabilite.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.Document;
import susitio.comptabilite.project.enums.TypeFolder;
import susitio.comptabilite.project.exceptions.BusinessException;
import susitio.comptabilite.project.services.ClientService;
import susitio.comptabilite.project.services.DocumentService;
import susitio.comptabilite.project.services.PersonneService;

@CrossOrigin
@RestController
@RequestMapping("/api/client")
public class ClientController {

	private static String UPLOAD_FOLDER = "C://test//";
	
	@Autowired
	ClientService clientService;
	@Autowired
	DocumentService documentService;
	@Autowired
	PersonneService personneService;
	
	@GetMapping("/get")
	public UserDetails getCurrentParent() throws BusinessException {
		System.out.println("abcd");
		return personneService.getLoggedInUser();
	}    
    @PostMapping("/add")
	public Client addClient(@RequestBody Client client) {
		clientService.addClient(client);
		return client;
	}
    @PostMapping("/upload")
	public void addDocument(@RequestParam("file") MultipartFile file,@RequestParam("type") TypeFolder type,@RequestParam("contenue") String contenue,@RequestParam("annee") String annee) {
    	documentService.uploadDocuments(file,type,annee,contenue,clientService.getClientById(1),clientService.getClientById(1));

	}
	@PostMapping("/upload/News")
	public void addDocumentNews(@RequestParam("type") TypeFolder type,@RequestParam("contenue") String contenue,@RequestParam("annee") String annee,@RequestParam("nomNews") String nomNews) {
		documentService.uploadDocumentsNews(type,annee,contenue,clientService.getClientById(1),clientService.getClientById(1),nomNews);

	}
	@PostMapping("/upload/news/file")
	public void addDocumentNewsFile(@RequestParam("file") MultipartFile file,@RequestParam("type") TypeFolder type,@RequestParam("contenue") String contenue,@RequestParam("annee") String annee,@RequestParam("nomNews") String nomNews) {
		documentService.uploadDocumentsNewsFile(file,type,annee,contenue,clientService.getClientById(1),clientService.getClientById(1),nomNews);

	}
	@GetMapping("/document/dossierJuridique/{annee}/{id}")
	public List<Document> getDossierJuridique(@PathVariable final String annee, @PathVariable final  int id){
    	Client client = clientService.getClientById(id) ;
    	return documentService.getDossier(annee,client,TypeFolder.dossierJuridique) ;
	}
	@GetMapping("/document/bilanAnnuel/{annee}/{id}")
	public List<Document> getBilanAnnuel(@PathVariable final String annee, @PathVariable final  int id){
		Client client = clientService.getClientById(id) ;
		return documentService.getDossier(annee,client,TypeFolder.dossierAnnuel) ;
	}
	@GetMapping("/document/bilanMensuel/{annee}/{mois}/{id}")
	public List<Document> getBilanMensuel(@PathVariable final String annee,@PathVariable final TypeFolder mois , @PathVariable final  int id){
		Client client = clientService.getClientById(id) ;
		return documentService.getDossier(annee,client,mois) ;
	}
    @GetMapping("/document/{id}")
	public Document getDocument(@PathVariable final int id){
    	return documentService.getDocumentById(id) ;
	}
	@GetMapping("/document/news/{type}")
	public List<Document> getDocumentNews(@PathVariable final  TypeFolder type){
		return documentService.getDocumentNews(type) ;
	}

}


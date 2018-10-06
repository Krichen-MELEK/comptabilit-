package susitio.comptabilite.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.enums.TypeFolder;
import susitio.comptabilite.project.services.ClientService;
import susitio.comptabilite.project.services.DocumentService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

	private static String UPLOAD_FOLDER = "C://test//";
	
	@Autowired
	ClientService clientService;
	@Autowired
	DocumentService documentService;
	
    @PostMapping("/add")
	public Client addClient(@RequestBody Client client) {
    	System.out.println(client);
		clientService.addClient(client);
		return client;
	}
    
    @PostMapping("/upload")
	public void addDocument(@RequestParam("file") MultipartFile file,@RequestParam("type") TypeFolder type,@RequestParam("annee") String annee) {
    	documentService.uploadDocuments(file,type,annee);

	}
    
}   


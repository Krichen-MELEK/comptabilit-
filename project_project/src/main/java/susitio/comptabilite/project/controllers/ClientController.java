package susitio.comptabilite.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.stereotype.Controller;
>>>>>>> origin/master
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.services.ClientService;


@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService clientService;
    @PostMapping("/add")
	public Client process(@RequestBody Client client) {
    	System.out.println(client);
		clientService.addClient(client);
		return client;
	}
=======
import susitio.comptabilite.project.services.DocumentService;

@Controller
@RequestMapping("/client")
public class ClientController {
	@Autowired
	DocumentService documentService;
	

	
>>>>>>> origin/master
}

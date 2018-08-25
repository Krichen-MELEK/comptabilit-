package susitio.comptabilite.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
}   


package susitio.comptabilite.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import susitio.comptabilite.project.services.DocumentService;

@Controller
@RequestMapping("/client")
public class ClientController {
	@Autowired
	DocumentService documentService;
	

	
}

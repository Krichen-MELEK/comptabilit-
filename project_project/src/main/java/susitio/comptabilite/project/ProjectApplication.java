package susitio.comptabilite.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import susitio.comptabilite.project.dao.ClientRepository;
import susitio.comptabilite.project.dao.MessageRepository;
import susitio.comptabilite.project.dao.PersonneRepository;
import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.Message;
import susitio.comptabilite.project.services.ClientService;
import susitio.comptabilite.project.services.PersonneService;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ProjectApplication.class, args);
		ProjectApplication projectApplication = new ProjectApplication();
		projectApplication.addDummyDBEntries(ctx);
		}
	
	@Autowired
	public ClientRepository clientRepository;
	@Autowired
	public MessageRepository messageRepository ;
	@Autowired
	public PersonneService personneService;
	@Autowired
	public ClientService clientService ;
	
	public void addDummyDBEntries(ApplicationContext ctx) {
		
		
		clientRepository = ctx.getBean(ClientRepository.class);
		clientRepository.save(new Client("ali","fist","ali@gmail.com","52850645","147","susitio","159487","14725836","159","web","sfax","susitio@gmail.com"));
		clientRepository.save(new Client("morad","majedi","morad@gmail.com","12345678", "123","webMedia","159487","14725836","159","web","tunis","medianet@gmail.com"));
		clientRepository.save(new Client("mohamed","krichen","mohamed@gmail.com","12345689","333","tanit","159487","14725836","159","web","jerba","tanit@gmail.com"));
		messageRepository = ctx.getBean(MessageRepository.class) ;
		messageRepository.save(new Message("hi","hi"));
	}
}

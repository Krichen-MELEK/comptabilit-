package susitio.comptabilite.project.services;

import java.util.List;

import org.springframework.stereotype.Repository;
import susitio.comptabilite.project.entities.Client;

@Repository
public interface ClientService {

	public List<Client> getClients();
	
	public Client getClientById(int id);
	
	public void addClient(Client client);
	
	public void deleteClient(int id);

	public void approuverClient(int id);

	public List<Client> getNonValidationClients(Boolean valide) ;
	
}

package susitio.comptabilite.project.services;

import java.util.List;

import susitio.comptabilite.project.entities.Client;

public interface ClientService {

	public List<Client> getClients();
	
	public Client getClientById(int id);
	
	public void addClient(Client client);
	
	public void deleteClient(int id);

	public void approuverClient(int id);
	
	
}

package susitio.comptabilite.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import susitio.comptabilite.project.dao.ClientRepository;
import susitio.comptabilite.project.entities.Client;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client getClientById(int id) {
		return clientRepository.findById(id).get();
	}

	@Override
	public void addClient(Client client) {
		clientRepository.save(client);
	}

	@Override
	public void deleteClient(int id) {
		
		clientRepository.deleteById(id);
	}

	@Override
	public void approuverClient(int id) {
		Client client = clientRepository.findById(id).get();
		client.setValidation(true);
		clientRepository.save(client);
	}


}

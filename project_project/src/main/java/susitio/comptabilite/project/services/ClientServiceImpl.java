package susitio.comptabilite.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import susitio.comptabilite.project.dao.ClientRepository;
import susitio.comptabilite.project.dao.RoleRepository;
import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.Role;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
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
		client.setMotDePasse(passwordEncoder.encode(client.getPassword()));
		Role role = roleRepository.findById(3).get();
		client.setRole(role);
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

	@Override
	public List<Client> getNonValidationClients(Boolean valide) {
		return  clientRepository.findClientByValidation(valide) ;
	}


}

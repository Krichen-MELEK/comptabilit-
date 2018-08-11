package susitio.comptabilite.project.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Client extends Personne {

    String nomSociete ;
    String matricule ;
    String telSociete ;
    String numRegistreCommerce ;
    String secteurActivite ;
    String adresseSociete ;
    String emailSociete ;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}

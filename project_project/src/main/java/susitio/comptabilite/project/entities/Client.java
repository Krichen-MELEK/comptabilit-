package susitio.comptabilite.project.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue(value="Client") 
public class Client extends Personne {

    private String nomSociete ;
    private String matricule ;
    private String telSociete ;
    private String numRegistreCommerce ;
    private String secteurActivite ;
    private String adresseSociete ;
    private String emailSociete ;
    @OneToMany(mappedBy = "client")
    private List<Document> documents ;
    @OneToMany(mappedBy = "client")
    private List<DossierAnnuel> dossierAnnuels ;
    @OneToMany(mappedBy = "client")
    private List<Payment> payments ;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}

package susitio.comptabilite.project.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;


@AllArgsConstructor
@Data
@Entity
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

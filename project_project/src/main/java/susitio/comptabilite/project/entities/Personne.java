package susitio.comptabilite.project.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;



@AllArgsConstructor
@Data
@MappedSuperclass
public class Personne {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String telephone ;
	private String login;
	private String motDePasse;
	@OneToMany(mappedBy = "personneEmetteur")
	private List<Message> messagesEmetteur ;
	@OneToMany(mappedBy = "personneRecepteur")
	private List<Message> messagesRecepteur ;
	@OneToMany(mappedBy = "personne")
	private List<Notification> notifications ;
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	


}

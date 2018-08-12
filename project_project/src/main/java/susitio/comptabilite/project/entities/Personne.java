package susitio.comptabilite.project.entities;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity  
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)   
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

	public Personne(String nom, String prenom, String adresse, String email, String telephone, String login,
			String motDePasse, List<Message> messagesEmetteur, List<Message> messagesRecepteur,
			List<Notification> notifications) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.login = login;
		this.motDePasse = motDePasse;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<Message> getMessagesEmetteur() {
		return messagesEmetteur;
	}

	public void setMessagesEmetteur(List<Message> messagesEmetteur) {
		this.messagesEmetteur = messagesEmetteur;
	}

	public List<Message> getMessagesRecepteur() {
		return messagesRecepteur;
	}

	public void setMessagesRecepteur(List<Message> messagesRecepteur) {
		this.messagesRecepteur = messagesRecepteur;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	
	
	

	


}

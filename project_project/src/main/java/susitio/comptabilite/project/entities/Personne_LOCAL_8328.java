package susitio.comptabilite.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone ;
	private String motDePasse;
	@OneToMany(mappedBy = "personneEmetteur")
	@JsonIgnore
	private List<Message> messagesEmetteur ;
	@OneToMany(mappedBy = "personneRecepteur")
	@JsonIgnore
	private List<Message> messagesRecepteur ;
	@OneToMany(mappedBy = "personne")
	@JsonIgnore
	private List<Notification> notifications ;
	@OneToMany(mappedBy = "personneEmmeteurDocument")
	@JsonIgnore
	private List<Document> documentsEmmetteur ;
	@OneToMany(mappedBy = "personneRecepteurDocument")
	@JsonIgnore
	private List<Document> documentsRecepteur ;

	public List<Document> getDocumentsEmmetteur() {
		return documentsEmmetteur;
	}

	public void setDocumentsEmmetteur(List<Document> documentsEmmetteur) {
		this.documentsEmmetteur = documentsEmmetteur;
	}

	public List<Document> getDocumentsRecepteur() {
		return documentsRecepteur;
	}

	public void setDocumentsRecepteur(List<Document> documentsRecepteur) {
		this.documentsRecepteur = documentsRecepteur;
	}

	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(String nom, String prenom, String email, String telephone,
			String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.motDePasse = motDePasse;
		this.messagesEmetteur = new ArrayList<Message>();
		this.messagesRecepteur = new ArrayList<Message>();
		this.notifications = new ArrayList<Notification>();
		

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

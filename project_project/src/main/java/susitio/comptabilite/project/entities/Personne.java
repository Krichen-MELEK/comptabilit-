package susitio.comptabilite.project.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter @NoArgsConstructor
public class Personne {
	
	@Id@GeneratedValue
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String telephone ;
	private String login;
	private String motDePasse;



}

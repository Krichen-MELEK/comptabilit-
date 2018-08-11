package susitio.comptabilite.project.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
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
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	


}

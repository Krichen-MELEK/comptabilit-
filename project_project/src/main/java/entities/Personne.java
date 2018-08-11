package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
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

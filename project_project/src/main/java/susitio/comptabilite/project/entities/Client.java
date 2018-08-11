package susitio.comptabilite.project.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;


@Getter
@Setter @NoArgsConstructor
@Entity
public class Client extends Personne {

    String nomSociete ;
    String matricule ;
    String telSociete ;
    String numRegistreCommerce ;
    String secteurActivite ;
    String adresseSociete ;
    String emailSociete ;

    public Client(String nomSociete, String matricule, String telSociete, String numRegistreCommerce, String secteurActivite, String adresseSociete, String emailSociete) {
        this.nomSociete = nomSociete;
        this.matricule = matricule;
        this.telSociete = telSociete;
        this.numRegistreCommerce = numRegistreCommerce;
        this.secteurActivite = secteurActivite;
        this.adresseSociete = adresseSociete;
        this.emailSociete = emailSociete;
    }
}

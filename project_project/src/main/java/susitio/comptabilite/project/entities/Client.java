package susitio.comptabilite.project.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor
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

}

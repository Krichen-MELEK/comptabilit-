package susitio.comptabilite.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import susitio.comptabilite.project.enums.TypeFolder;

import javax.persistence.*;


@AllArgsConstructor
@Data
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String object ;
    private String contenue ;
    private String destination ;
    private Boolean lu ;
    private String dateEnvoie ;
    @ManyToOne
    private Personne personneEmetteur ;
    @ManyToOne
    private Personne personneRecepteur ;

    public Message() {
    }

    public Message(String object, String contenue, String destination, Boolean lu, String dateEnvoie, Personne personneEmetteur, Personne personneRecepteur) {
        this.object = object;
        this.contenue = contenue;
        this.destination = destination;
        this.lu = lu;
        this.dateEnvoie = dateEnvoie;
        this.personneEmetteur = personneEmetteur;
        this.personneRecepteur = personneRecepteur;
    }
}

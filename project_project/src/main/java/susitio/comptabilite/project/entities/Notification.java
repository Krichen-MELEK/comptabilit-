package susitio.comptabilite.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import susitio.comptabilite.project.enums.TypeNotification;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id  ;
    private TypeNotification typeNotification;
    private String contenue ;
    private Integer idobject ;
    private Boolean vu ;
    @ManyToOne
    private Personne personne;

    public Notification() {
    }

    public Notification(TypeNotification typeNotification, String contenue, int idobject, Boolean vu, Personne personne) {
        this.typeNotification = typeNotification;
        this.contenue = contenue;
        this.idobject = idobject;
        this.vu = vu;
        this.personne = personne;
    }
}

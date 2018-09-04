package susitio.comptabilite.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Data
@Entity
public class DossierAnnuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String nom ;
    private String annee ;
    @OneToMany(mappedBy="dossierAnnuel")
    @JsonIgnore
    private List<Document> documents ;
    @ManyToOne
    private Client client ;

    public DossierAnnuel() {

    }

    public DossierAnnuel(String nom, String annee, Client client) {
        this.nom = nom;
        this.annee = annee;
        this.documents = new ArrayList<Document>();
        this.client = client;
    }
}

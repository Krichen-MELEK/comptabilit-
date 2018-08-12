package susitio.comptabilite.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import susitio.comptabilite.project.enums.TypeFolder;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String path ;
    private String dateCreation  ;
    private TypeFolder type ;
    @ManyToOne
    private DossierAnnuel dossierAnnuel ;
    @ManyToOne
    private Client client ;

    public Document(String path, String dateCreation, TypeFolder type, DossierAnnuel dossierAnnuel, Client client) {
        this.path = path;
        this.dateCreation = dateCreation;
        this.type = type;
        this.dossierAnnuel = dossierAnnuel;
        this.client = client;
    }

    public Document() {
    }
}

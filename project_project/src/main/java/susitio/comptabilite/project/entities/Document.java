package susitio.comptabilite.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import susitio.comptabilite.project.enums.TypeFolder;


@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name;
    private String path ;
    private String dateCreation  ;
    private TypeFolder type ;
    @ManyToOne
    private DossierAnnuel dossierAnnuel ;
    @ManyToOne
    private Client client ;

    public Document() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public TypeFolder getType() {
		return type;
	}

	public void setType(TypeFolder type) {
		this.type = type;
	}

	public DossierAnnuel getDossierAnnuel() {
		return dossierAnnuel;
	}

	public void setDossierAnnuel(DossierAnnuel dossierAnnuel) {
		this.dossierAnnuel = dossierAnnuel;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
    
    
}

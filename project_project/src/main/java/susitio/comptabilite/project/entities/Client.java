package susitio.comptabilite.project.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="ID")
public class Client extends Personne {

    private String nomSociete ;
    private String matricule ;
    private String telSociete ;
    private String numRegistreCommerce ;
    private String secteurActivite ;
    private String adresseSociete ;
    private String emailSociete ;
    private boolean validation;
    @OneToMany(mappedBy = "client")
    private List<Document> documents ;
    @OneToMany(mappedBy = "client")
    private List<DossierAnnuel> dossierAnnuels ;
    @OneToMany(mappedBy = "client")
    private List<Payment> payments ;
	public Client() {
		super();
		this.validation=false;
	}

    public String getNomSociete() {
        return nomSociete;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getTelSociete() {
        return telSociete;
    }

    public String getNumRegistreCommerce() {
        return numRegistreCommerce;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public String getAdresseSociete() {
        return adresseSociete;
    }

    public String getEmailSociete() {
        return emailSociete;
    }

    public boolean isValidation() {
        return validation;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public List<DossierAnnuel> getDossierAnnuels() {
        return dossierAnnuels;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setTelSociete(String telSociete) {
        this.telSociete = telSociete;
    }

    public void setNumRegistreCommerce(String numRegistreCommerce) {
        this.numRegistreCommerce = numRegistreCommerce;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public void setAdresseSociete(String adresseSociete) {
        this.adresseSociete = adresseSociete;
    }

    public void setEmailSociete(String emailSociete) {
        this.emailSociete = emailSociete;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void setDossierAnnuels(List<DossierAnnuel> dossierAnnuels) {
        this.dossierAnnuels = dossierAnnuels;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}

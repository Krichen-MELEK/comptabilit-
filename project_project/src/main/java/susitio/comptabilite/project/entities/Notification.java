package susitio.comptabilite.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import susitio.comptabilite.project.enums.TypeNotification;


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

	public Notification(TypeNotification typeNotification, String contenue, Integer idobject, Boolean vu) {
		super();
		this.typeNotification = typeNotification;
		this.contenue = contenue;
		this.idobject = idobject;
		this.vu = vu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeNotification getTypeNotification() {
		return typeNotification;
	}

	public void setTypeNotification(TypeNotification typeNotification) {
		this.typeNotification = typeNotification;
	}

	public String getContenue() {
		return contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}

	public Integer getIdobject() {
		return idobject;
	}

	public void setIdobject(Integer idobject) {
		this.idobject = idobject;
	}

	public Boolean getVu() {
		return vu;
	}

	public void setVu(Boolean vu) {
		this.vu = vu;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

    
}

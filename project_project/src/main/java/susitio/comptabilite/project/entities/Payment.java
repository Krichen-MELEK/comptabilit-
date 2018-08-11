package susitio.comptabilite.project.entities;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Payment {

	private int id ;
	private String nom;
	private Date dateDeCreation;
	private String Status;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

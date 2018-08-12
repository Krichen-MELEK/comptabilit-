package susitio.comptabilite.project.entities;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String nom;
	private Date dateDeCreation;
	private String Status;
	@ManyToOne
	private Client client ;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

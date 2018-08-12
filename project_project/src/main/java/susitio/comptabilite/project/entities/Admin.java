package susitio.comptabilite.project.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue(value="Admin") 
public class Admin extends Personne {

}

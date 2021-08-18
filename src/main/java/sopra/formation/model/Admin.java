package sopra.formation.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {

	public Admin() {
		super();
	}

	public Admin(Long id, int version, String nom, String prenom, String email, String mdp) {
		super(id, version, nom, prenom, email, mdp);
		// TODO Auto-generated constructor stub
	}

	public Admin(String nom, String prenom, String email, String mdp) {
		super(nom, prenom, email, mdp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [getId()=" + getId() + ", getVersion()=" + getVersion() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getEmail()=" + getEmail() + ", getMdp()=" + getMdp()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	

}

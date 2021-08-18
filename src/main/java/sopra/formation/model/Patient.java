package sopra.formation.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("patient")
public class Patient extends Compte {

	public Patient() {
		super();
	}

	public Patient(Long id, int version, String nom, String prenom, String email, String mdp) {
		super(id, version, nom, prenom, email, mdp);
		// TODO Auto-generated constructor stub
	}

	public Patient(String nom, String prenom, String email, String mdp) {
		super(nom, prenom, email, mdp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Patient [getId()=" + getId() + ", getVersion()=" + getVersion() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getEmail()=" + getEmail() + ", getMdp()=" + getMdp()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	

}

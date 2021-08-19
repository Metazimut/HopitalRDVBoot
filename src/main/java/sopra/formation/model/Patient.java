package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("patient")
public class Patient extends Compte {

	@OneToMany(mappedBy = "patient")
	@JsonView({Views.ViewPatient.class, Views.ViewPatientRdv.class})
	private List<Rdv> rdv = new ArrayList<Rdv>();
	
	public Patient() {
		super();
	}

	public Patient(Long id, int version, String nom, String prenom, String email, String mdp) {
		super(id, version, nom, prenom, email, mdp);
		// TODO Auto-generated constructor stub
	}

	public Patient(Long id, String nom, String prenom, String email, String mdp) {
		super(id, nom, prenom, email, mdp);
		// TODO Auto-generated constructor stub
	}

	public Patient(String nom, String prenom, String email, String mdp) {
		super(nom, prenom, email, mdp);
		// TODO Auto-generated constructor stub
	}

	public Patient(Long id, int version, String nom, String prenom, String email, String mdp, List<Rdv> rdv) {
		super(id, version, nom, prenom, email, mdp);
		this.rdv = rdv;
	}

	public Patient(String nom, String prenom, String email, String mdp, List<Rdv> rdv) {
		super(nom, prenom, email, mdp);
		this.rdv = rdv;
	}
}

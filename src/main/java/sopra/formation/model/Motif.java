package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "motif")
public class Motif {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name = "libelle")
	private String libelle;
	@Column(name = "duree")
	private double duree;
	@OneToMany(mappedBy = "motif")
	private List<Rdv> rdv = new ArrayList<Rdv>();
	@ManyToOne
	@JoinColumn(name="specialite_id")
	private Specialite specialite;
	
	
	public Motif() {
		super();
	}


	public Motif(Long id, int version, String libelle, double duree, List<Rdv> rdv, Specialite specialite) {
		this.id = id;
		this.version = version;
		this.libelle = libelle;
		this.duree = duree;
		this.rdv = rdv;
		this.specialite = specialite;
	}


	public Motif(int version, String libelle, double duree, List<Rdv> rdv, Specialite specialite) {
		this.version = version;
		this.libelle = libelle;
		this.duree = duree;
		this.rdv = rdv;
		this.specialite = specialite;
	}


	public Motif(Long id, int version, String libelle, double duree) {
		super();
		this.id = id;
		this.version = version;
		this.libelle = libelle;
		this.duree = duree;
	}
	
	


	public Motif(String libelle, double duree) {
		super();
		this.libelle = libelle;
		this.duree = duree;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	
	public List<Rdv> getRdv() {
		return rdv;
	}


	public void setRdv(List<Rdv> rdv) {
		this.rdv = rdv;
	}


	public Specialite getSpecialite() {
		return specialite;
	}


	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}


	@Override
	public String toString() {
		return "Motif [id=" + id + ", version=" + version + ", libelle=" + libelle
				+ "]";
	}


	
	
	
	
}

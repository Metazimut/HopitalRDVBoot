package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Specialite")
public class Specialite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name="libelle")
	private String libelle;
	@OneToMany(mappedBy="specialite")
	private List<PraticienSpecialite> praticienSpecialites = new ArrayList<PraticienSpecialite>();
	@OneToMany(mappedBy="specialite")
	private List<Motif> motifs = new ArrayList<Motif>();
	
	
	public Specialite() {
		super();
	}
	
	public Specialite(Long id, String libelle) {
		this.id=id;
		this.libelle=libelle;
	}
	
	public Specialite(String libelle) {
		this.libelle=libelle;
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


	public List<PraticienSpecialite> getPraticienSpecialites() {
		return praticienSpecialites;
	}

	public void setPraticienSpecialites(List<PraticienSpecialite> praticienSpecialites) {
		this.praticienSpecialites = praticienSpecialites;
	}

	public List<Motif> getMotifs() {
		return motifs;
	}

	public void setMotifs(List<Motif> motifs) {
		this.motifs = motifs;
	}

	@Override
	public String toString() {
		return "Specialite [id=" + id + ", version=" + version + ", libelle=" + libelle + "]";
	}



	
	
	
	
}

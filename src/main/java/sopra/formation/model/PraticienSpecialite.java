package sopra.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "Praticien_Specialite")
public class PraticienSpecialite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@ManyToOne
	@JoinColumn(name="praticien")
	@JsonView(Views.ViewSpecialite.class)
	private Praticien praticien;
	@ManyToOne
	@JoinColumn(name="specialite")
	@JsonView(Views.ViewPraticien.class)
	private Specialite specialite;
	
	public PraticienSpecialite() {
		super();
	}
	
	public PraticienSpecialite(Long id, Praticien praticien, Specialite specialite) {
		this.id=id;
		this.praticien=praticien;
		this.specialite=specialite;
	}
	
	public PraticienSpecialite(Long id) {
		this.id=id;
	}
	
	public PraticienSpecialite(Praticien praticien, Specialite specialite) {
		this.praticien=praticien;
		this.specialite=specialite;
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

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return "PraticienSpecialite [id=" + id + ", version=" + version +"]";
	}
	
	
}

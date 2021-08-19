package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Creneaux")
public class Creneaux {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name="date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonView(Views.ViewCommon.class)
	private Date creneauxDispo;
	@OneToMany(mappedBy = "creneaux")
	private List<Rdv> rdv = new ArrayList<Rdv>();
	@ManyToOne
	@JoinColumn(name="Praticien")
	private Praticien praticien;
	
	public Creneaux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Creneaux(Long id, int version, Date creneauxDispo, List<Rdv> rdv, Praticien praticien) {
		super();
		this.id = id;
		this.version = version;
		this.creneauxDispo = creneauxDispo;
		this.rdv = rdv;
		this.praticien = praticien;
	}
	
	public Creneaux(Date creneauxDispo) {
		super();
		this.creneauxDispo = creneauxDispo;
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

	public Date getCreneauxDispo() {
		return creneauxDispo;
	}

	public void setCreneauxDispo(Date creneauxDispo) {
		this.creneauxDispo = creneauxDispo;
	}

	public List<Rdv> getRdv() {
		return rdv;
	}

	public void setRdv(List<Rdv> rdv) {
		this.rdv = rdv;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	@Override
	public String toString() {
		return "Creneaux [id=" + id + ", version=" + version + ", creneauxDispo=" + creneauxDispo + "]";
	}

	
	
}

package sopra.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "rdv")
public class Rdv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "lieu")
	@JsonView({Views.ViewCommon.class, Views.ViewPatientRdv.class})
	private String lieu;
	@Column(name = "dtRdv")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonView({Views.ViewCommon.class, Views.ViewPatientRdv.class})
	private Date dtRdv;
	@Enumerated(EnumType.STRING)
	@JsonView({Views.ViewCommon.class, Views.ViewPatientRdv.class})
	private Status status;
	@ManyToOne
	@JoinColumn(name="motif_id")
	@JsonView(Views.ViewPatientRdv.class)
	private Motif motif;
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="creneaux_id")
	private Creneaux creneaux;
	
	
	public Rdv() {
		super();
	}


	public Rdv(Long id, int version, String lieu, Date dtRdv, Status status, Motif motif, Patient patient,
			Creneaux creneaux) {
		this.id = id;
		this.version = version;
		this.lieu = lieu;
		this.dtRdv = dtRdv;
		this.status = status;
		this.motif = motif;
		this.patient = patient;
		this.creneaux = creneaux;
	}


	public Rdv(int version, String lieu, Date dtRdv, Status status, Motif motif, Patient patient, Creneaux creneaux) {
		this.version = version;
		this.lieu = lieu;
		this.dtRdv = dtRdv;
		this.status = status;
		this.motif = motif;
		this.patient = patient;
		this.creneaux = creneaux;
	}
	
	public Rdv(String lieu, Date dtRdv, Status status) {
		this.lieu = lieu;
		this.dtRdv = dtRdv;
		this.status = status;
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

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Date getDtRdv() {
		return dtRdv;
	}

	public void setDtRdv(Date dtRdv) {
		this.dtRdv = dtRdv;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	

	public Motif getMotif() {
		return motif;
	}


	public void setMotif(Motif motif) {
		this.motif = motif;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Creneaux getCreneaux() {
		return creneaux;
	}


	public void setCreneaux(Creneaux creneaux) {
		this.creneaux = creneaux;
	}


	@Override
	public String toString() {
		return "Rdv [id=" + id + ", version=" + version + ", lieu=" + lieu + ", dtRdv=" + dtRdv + ", status=" + status
				+"]";
	}



	
	
	
	
	
	
}

package sopra.formation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Admin;
import sopra.formation.model.Compte;
import sopra.formation.model.Patient;
import sopra.formation.model.Praticien;
import sopra.formation.model.Specialite;



public interface ICompteRepository extends JpaRepository<Compte, Long> {
	
	@Query("select a from Admin a")
	List<Admin> findAllAdmin(); // @Query

	@Query("select p from Patient p")
	List<Patient> findAllPatient(); // @Query
	
	@Query("select pr from Praticien pr")
	List<Praticien> findAllPraticien(); // @Query

	Admin findAllAdminByEmail(@Param("email") String email); // NamedQuery 

	Patient findAllPatientByEmail(@Param("email") String email); // NamedQuery
	
	Praticien findAllPraticienByEmail(@Param("email") String email); // NamedQuery
	
	Admin findAllAdminByNom(@Param("Nom") String nom); // NamedQuery 

	Patient findAllPatientByNom(@Param("Nom") String nom); // NamedQuery
	
	Praticien findAllPraticienByNom(@Param("Nom") String nom); // NamedQuery
	
	@Query("select ps.praticien from PraticienSpecialite ps where ps.id = (select ps.id from PraticienSpecialite ps join ps.specialite s where s =:spe)")
	Praticien findAllPraticienBySpe(@Param("spe") Specialite spe);
	
	Praticien findAllPraticienByLieu(@Param("lieu") String lieu);
	
	Optional<Praticien> findPraticienById(@Param("Id") Long idPraticien); // NamedQuery

	Optional<Patient> findPatientById(@Param("Id") Long idPatient); // NamedQuery
	
	Optional<Admin> findAdminById(@Param("Id") Long idAdmin); // NamedQuery
}

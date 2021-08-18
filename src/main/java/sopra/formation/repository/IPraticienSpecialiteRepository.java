package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.PraticienSpecialite;
import sopra.formation.model.Specialite;

public interface IPraticienSpecialiteRepository extends JpaRepository<PraticienSpecialite, Long>{

	PraticienSpecialite findPraticienSpecialiteBySpecialite(@Param("specialite") Specialite specialite);

}

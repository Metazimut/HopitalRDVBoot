package sopra.formation.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Specialite;

public interface ISpecialiteRepository extends JpaRepository<Specialite, Long> {

}

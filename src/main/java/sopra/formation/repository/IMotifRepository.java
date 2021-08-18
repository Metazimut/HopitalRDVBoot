package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Motif;

public interface IMotifRepository extends JpaRepository<Motif, Long> {

}
